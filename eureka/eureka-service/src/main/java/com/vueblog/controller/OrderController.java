package com.vueblog.controller;

import com.vueblog.entity.OrderBean;
import com.vueblog.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;


/**
 * Created by xiangmiao on 2020/7/13.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public void addOrder(@RequestBody OrderBean bean) {
        /*Date date = new Date();
        String uuid = UUID.randomUUID().toString();
        OrderBean bean = new OrderBean();
        bean.setCreateTime(date.getTime());
        bean.setGoodsId(1L);
        bean.setUpdateTime(date.getTime());
        bean.setUserId(3L);
        bean.setOrderNo(uuid);*/
        orderService.add(bean);
    }
}
