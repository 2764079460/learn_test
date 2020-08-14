package com.markerhub.websokcet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Created by xiangmiao on 2020/8/13.
 * springboot内置容器启动项目的，则需要配置一个Bean。如果是采用外部的容器，则不需要配置
 */
@Component
public class WebSocketConfig {

    /**
     * ServerEndpointExporter 作用
     *
     * 这个Bean会自动注册使用@ServerEndpoint注解声明的websocket endpoint
     *
     * @return
     */
    @Bean
    @Conditional(WarAndJarWebscoketAutoWired.class)
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
