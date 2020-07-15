package com.vueblog.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xiangmiao on 2020/7/13.
 */
@FeignClient(name = "wallet-service")
public interface walletClient {

    @PostMapping("/wallet/updateMoney")
    void updateMoney(@RequestParam(value = "userId")Long userId, @RequestParam(value = "money")double money);
}
