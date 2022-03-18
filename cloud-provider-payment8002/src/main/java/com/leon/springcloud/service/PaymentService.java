package com.leon.springcloud.service;

import com.leon.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author chengliang
 * @Date 2022/3/16 0:26
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
