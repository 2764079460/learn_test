package com.markerhub.config;

import com.markerhub.shiro.AccountRealm;
import com.markerhub.shiro.JwtFilter;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by xiangmiao on 2020/6/12.
 * shiro启用注解拦截控制器
 * 认证流程：构造SecurityManager环境 -> subject.login()提交认证 -> SecurityManager.login()执行认证 -> Authenticator执行认证 -> Realm根据身份获取验证信息
 * 授权流程：构造SecurityManager环境 -> subject.isPermitted()授权 -> SecurityManager.isPermitted()执行授权 -> Authorizer执行授权 -> Realm根据身份获取资源权限信息
 */
@Configuration
public class ShiroConfig {

    @Autowired(required = false)
    JwtFilter jwtFilter;

    /**
     * sessionManager即会话管理，shiro框架定义了一套会话管理，它不依赖web容器的session，所以shiro可以使用在非web应用上，也可以将分布式应用的会话集中在一点管理，
     * 此特性可使它实现单点登录
     * @param redisSessionDAO
     * @return
     */
    @Bean
    public SessionManager sessionManager(RedisSessionDAO redisSessionDAO) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();

        // inject redisSessionDAO
        //SessionDAO即会话dao，是对session会话操作的一套接口，比如要将session存储到数据库，可以通过jdbc将会话存储到数据库。
        sessionManager.setSessionDAO(redisSessionDAO);
        return sessionManager;
    }

    /**
     * SecurityManager即安全管理器，对全部的subject进行安全管理，它是shiro的核心，负责对所有的subject进行安全管理。
     * 通过SecurityManager可以完成subject的认证、授权等，实质上SecurityManager是通过Authenticator进行认证，通过Authorizer进行授权，
     * 通过SessionManager进行会话管理等。
     * SecurityManager是一个接口，继承了Authenticator, Authorizer, SessionManager这三个接口
     * @param accountRealm
     * (Realm即领域，相当于datasource数据源，securityManager进行安全认证需要通过Realm获取用户权限数据，
     * 比如：如果用户身份数据在数据库那么realm就需要从数据库获取用户身份信息。注意：不要把realm理解成只是从数据源取数据，在realm中还有认证授权校验的相关的代码。)
     * @param sessionManager
     * @param redisCacheManager
     * @return
     */
    @Bean
    public SessionsSecurityManager securityManager(AccountRealm accountRealm, SessionManager sessionManager, RedisCacheManager redisCacheManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(accountRealm);

        //inject sessionManager
        securityManager.setSessionManager(sessionManager);

        // CacheManager即缓存管理，将用户权限数据存储在缓存，这样可以提高性能。
        securityManager.setCacheManager(redisCacheManager);
        return securityManager;
    }


    /**
     * Shiro连接约束配置,即过滤链的定义
     * 添加白名单
     * @return
     */
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/**", "jwt"); // 主要通过注解方式校验权限
        chainDefinition.addPathDefinitions(filterMap);
        return chainDefinition;
    }
    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager,
                                                         ShiroFilterChainDefinition shiroFilterChainDefinition) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        Map<String, Filter> filters = new HashMap<>();
        //添加过滤器(对应shiroFilterChainDefinition的 key "/**")指定要进入过滤器的url
        filters.put("jwt", jwtFilter);
        shiroFilter.setFilters(filters);
        // ==filterMap.put("/**", "jwt"); // 主要通过注解方式校验权限
        Map<String, String> filterMap = shiroFilterChainDefinition.getFilterChainMap();
        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;
    }

}
