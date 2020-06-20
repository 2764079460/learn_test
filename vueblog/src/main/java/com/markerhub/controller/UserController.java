package com.markerhub.controller;


import cn.hutool.crypto.SecureUtil;
import com.markerhub.common.Lang.Result;
import com.markerhub.entity.User;
import com.markerhub.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2020-06-11
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @RequiresAuthentication
    @GetMapping("/{id}")
    public Result test(@PathVariable("id") Integer id) {
        User user = userService.getById(id);
        return Result.succ(user);
    }


    //@RequiresAuthentication
    @PostMapping(value = "/save")
    public Result save(@Validated @RequestBody User user) {
        user.setPassword(SecureUtil.md5(user.getPassword()));
        userService.save(user);
        return Result.succ(200,"成功",null);
    }
}
