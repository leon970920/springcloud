package com.leon.springcloud.service.impl;

import com.leon.springcloud.dao.PaymentDao;
import com.leon.springcloud.entity.Payment;
import com.leon.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author chengliang
 * @Date 2022/3/16 0:27
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
