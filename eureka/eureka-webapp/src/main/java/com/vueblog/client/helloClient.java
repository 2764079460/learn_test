package com.vueblog.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xiangmiao on 2020/6/24.
 */
@FeignClient(name = "service")
public interface helloClient {

    @RequestMapping("/hello/hi")
    String hello(@RequestParam(value = "name") String name);

    @RequestMapping("/user/info")
    String user(@RequestParam(value = "name") String name);
}
