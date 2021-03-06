package com.controller;

import com.bean.UserAddress;
import com.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    //@RequestParam从请求路径的?获取:127.0.0.1:8081/initOrder?userId=1&***
    @GetMapping("/initOrder")
    public List<UserAddress> initOrder(@RequestParam(value = "userId",required = true) String userId) {
        List<UserAddress> userAddresses = orderService.initOrder(userId);
        return userAddresses;
    }
}
