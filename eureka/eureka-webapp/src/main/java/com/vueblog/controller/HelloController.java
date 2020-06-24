package com.vueblog.controller;

import com.vueblog.client.helloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xiangmiao on 2020/6/24.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired(required = false)
    private helloClient helloClient;

    @GetMapping("/hi")
    public String hello(@RequestParam("name") String name) {
        return helloClient.hello(name);
    }


    @RequestMapping("/user")
    public String user(@RequestParam("name") String name) {
        return helloClient.user(name);
    }
}
