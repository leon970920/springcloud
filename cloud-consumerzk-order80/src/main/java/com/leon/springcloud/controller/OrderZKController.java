package com.leon.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author chengliang
 * @Date 2022/3/18 0:37
 */
@RestController
@Slf4j
public class OrderZKController {
    //通过服务名调用
    public static final String INVOKE_URL = "http://cloud-provider-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);

        return result;
    }
}
