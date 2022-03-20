package com.leon.springcloud.service;

import com.leon.springcloud.entity.CommonResult;
import com.leon.springcloud.entity.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author chengliang
 * @Date 2022/3/20 22:11
 */

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable(value = "id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public Integer paymentTimeout();
}
