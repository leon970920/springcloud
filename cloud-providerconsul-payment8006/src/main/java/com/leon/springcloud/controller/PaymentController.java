package com.leon.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author chengliang
 * @Date 2022/3/18 0:05
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private Integer serverPort;

    @RequestMapping("/payment/consul")
    public String paymentzk() {
        return "springcloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
