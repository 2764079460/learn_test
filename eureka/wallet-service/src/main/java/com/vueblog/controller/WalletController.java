package com.vueblog.controller;

import com.vueblog.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiangmiao on 2020/7/13.
 */
@RestController
@RequestMapping("wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping("/updateMoney")
    public void updateMoney(@RequestParam(value = "userId")Long userId, @RequestParam(value = "money")double money) {
        walletService.substractMoney(userId,money);
    }
}
