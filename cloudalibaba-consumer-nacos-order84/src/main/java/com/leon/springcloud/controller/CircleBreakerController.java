package com.leon.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.leon.springcloud.entity.CommonResult;
import com.leon.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author chengliang
 * @Date 2022/5/24 23:29
 */

@RestController
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")//没有配置返回给前端错误页面
//    @SentinelResource(value = "fallback", fallback = "handlerFallback")//fallback只负责程序异常
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler")//blockHandler只负责sentinel配置违规
    @SentinelResource(value = "fallback", blockHandler = "blockHandler",fallback = "handlerFallback")//
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数......");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该id没有对应记录，空指针异常......");
        }

        return result;
    }


    //本例是fallback
    public CommonResult handlerFallback(@PathVariable("id") Long id, Throwable e) {
        Payment payment = new Payment(id, null);
        return new CommonResult(444, "兜底异常handlerFallback：" + e.getMessage(), payment);
    }

    //本例是blockHandler
    public CommonResult blockHandler(@PathVariable("id") Long id, BlockException e) {
        Payment payment = new Payment(id, null);
        return new CommonResult(445, "blockHandler限流，无此流水：" + e.getMessage(), payment);
    }
}

