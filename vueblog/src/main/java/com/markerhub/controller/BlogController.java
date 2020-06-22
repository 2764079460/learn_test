package com.markerhub.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.common.Lang.Result;
import com.markerhub.entity.Blog;
import com.markerhub.service.BlogService;
import com.markerhub.util.ShiroUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2020-06-11
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogService blogService;


    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage) {
        Page page = new Page(currentPage, 5);
        IPage pageData = blogService.page(page, new QueryWrapper<Blog>().orderByDesc("created"));
        return Result.succ(pageData);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable(name = "id") Integer id) {
        Blog blog = blogService.getById(id);
        Assert.notNull(blog,"该博客已被删除！");
        return Result.succ(blog);
    }


    @RequiresAuthentication
    @PostMapping("/edit")
    public Result edit(@RequestBody Blog blog) {
        if (blog.getId() != null) {
            Blog blog1 = blogService.getById(blog.getId());
            //用户校验
            Assert.isTrue(blog1.getUserId().equals(ShiroUtil.getProfile().getId()), "不是本人！");
        } else {
            blog.setUserId(ShiroUtil.getProfile().getId());
            blog.setCreated(LocalDateTime.now());
            blog.setStatus(0);
        }
        blogService.saveOrUpdate(blog);
        return Result.succ(null);
    }
}
