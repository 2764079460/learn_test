package com.markerhub.websokcet.config;

import org.apache.ibatis.javassist.bytecode.stackmap.TypeData;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by xiangmiao on 2020/8/14.
 */
public class WarAndJarWebscoketAutoWired implements Condition {

    private static Properties properties;

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //用于ServerEndpointExporter,fales为外部容器(tomcat)启动时不注入，true为springboot内部容器(main启动)启动时则注入
        boolean isMain = false;
        try {
            Properties properties = new Properties();
            String path = TypeData.ClassName.class.getClassLoader().getResource("websocket.properties").getPath();
            InputStream inputStream = new BufferedInputStream(new FileInputStream(path));
            properties.load(inputStream);
            inputStream.close();
            String deploy = properties.getProperty("deploy");
            isMain = "local".equals(deploy);//本地main启动true
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return isMain;
    }
}
