package com.vueblog.client;

import com.vueblog.entity.OrderBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiangmiao on 2020/7/13.
 */
@FeignClient(name = "service")
public interface orderClient {

    @PostMapping("/order/add")
    void addOrder(@RequestBody OrderBean bean);
}
