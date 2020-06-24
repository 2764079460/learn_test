package com.vueblog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiangmiao on 2020/6/24.
 */

@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("/hi")
    public String hello(@RequestParam String name) {
        return "服务提供者hello"+name;
    }
}
