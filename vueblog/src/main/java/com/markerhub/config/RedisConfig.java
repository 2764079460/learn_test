package com.markerhub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by xiangmiao on 2020/7/10.
 */
@Configuration
@ImportResource(locations = {"classpath:application-redis.xml"})
public class RedisConfig {

}
