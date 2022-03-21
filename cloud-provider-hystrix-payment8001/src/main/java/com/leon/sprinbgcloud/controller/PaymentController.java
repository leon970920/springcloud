package com.leon.sprinbgcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.leon.sprinbgcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chengliang
 * @Date 2022/3/21 23:28
 */

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private Integer serverPort;


    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentService.paymentInfo_OK(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        return paymentService.paymentInfo_Timeout(id);
    }

    //============服务熔断=========
    @GetMapping("/payment/hystrix/circuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {

        return paymentService.paymentCircuitBreaker(id);
    }
}
