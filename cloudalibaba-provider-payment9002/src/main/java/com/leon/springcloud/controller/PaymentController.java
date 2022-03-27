package com.leon.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chengliang
 * @Date 2022/3/27 23:45
 */

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable(value = "id") Integer id) {
        return "nacos registry,serverPort: " + serverPort + "\tid: " + id;
    }
}
