package com.vueblog.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xiangmiao on 2020/7/13.
 */
@FeignClient(name = "goods-service")
public interface goodsClient {

    @PostMapping("/goods/updateStock")
    void updateStock(@RequestParam(value = "goodsId") Long goodsId, @RequestParam(value = "stock") Integer stock);
}
