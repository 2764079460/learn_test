package com.vueblog.controller;

import com.vueblog.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiangmiao on 2020/7/13.
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/updateStock")
    public void updateStock(@RequestParam(value = "goodsId") Long goodsId, @RequestParam(value = "stock")Integer stock) {
        goodsService.substractStock(goodsId,stock);
    }
}
