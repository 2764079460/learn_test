package com.vueblog.controller;

import com.vueblog.client.goodsClient;
import com.vueblog.client.orderClient;
import com.vueblog.client.walletClient;
import com.vueblog.entity.OrderBean;
import com.vueblog.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

/**
 * Created by xiangmiao on 2020/7/11.
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired(required = false)
    orderClient order;

    @Autowired(required = false)
    goodsClient goods;

    @Autowired(required = false)
    walletClient wallet;

    @GlobalTransactional
    @GetMapping("/add")
    public String add(){
        Date date = new Date();
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        System.out.println("uuid:"+uuid.length());
        OrderBean bean = new OrderBean();
        bean.setCreateTime(date.getTime());
        bean.setGoodsId(1L);
        bean.setUpdateTime(date.getTime());
        bean.setUserId(3L);
        bean.setOrderNo(uuid);
        order.addOrder(bean);
        goods.updateStock(1L, 1);
        wallet.updateMoney(3L,1);
        return "OK";
    }
}
