package com.leon.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author chengliang
 * @Date 2022/3/22 0:42
 */

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK Fallback";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "paymentInfo_Timeout Fallback";
    }
}
