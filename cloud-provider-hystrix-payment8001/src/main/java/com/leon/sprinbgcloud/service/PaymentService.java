package com.leon.sprinbgcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author chengliang
 * @Date 2022/3/21 23:23
 */

@Service
public class PaymentService {

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + "paymentInfo_OK,id: " + id + "\t" + "哈哈哈哈哈";
    }


    /**
     * 超时访问
     * 3秒钟以内正常返回，超过三秒钟或者运行异常调用降级方法
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_Timeout(Integer id) {
//        int age = 10 / 0;

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + "paymentInfo_Timeout,id: " + id + "\t" + "哈哈哈哈哈超时了";
    }

    /**
     * 超时降级方法
     *
     * @param
     * @return
     */
    public String paymentInfo_TimeoutHandler() {
        return "线程池： " + Thread.currentThread().getName() + "\t" + "服务器繁忙，请稍后访问！";
    }


    //==============服务熔断==============
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_Fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启服务熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//服务熔断触发调用次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//服务熔断触发调用时间
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//服务熔断触发调用失败率
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("*********id 不能为负数");
        }

        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号： " + serialNumber;
    }


    public String paymentCircuitBreaker_Fallback(Integer id) {
        return "id 不能为负数，请稍后再试" + "id";
    }
}
