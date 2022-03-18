package com.leon.springcloud.controller;

import com.leon.springcloud.entity.CommonResult;
import com.leon.springcloud.entity.Payment;
import com.leon.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chengliang
 * @Date 2022/3/16 0:30
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private Integer serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据成功,serverPort:  "+serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败,serverPort:  "+serverPort);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果：" + payment);

        if (payment != null) {
            return new CommonResult(200, "查询数据成功,serverPort:  "+serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID:,serverPort:  "+serverPort + id);
        }
    }

    //返回负载均衡获取到的服务器端口
    @GetMapping(value = "/payment/lb")
    public Integer getPaymentLB() {
        return serverPort;
    }
}
