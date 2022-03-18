package com.leon.springcloud.controller;

import com.leon.springcloud.entity.CommonResult;
import com.leon.springcloud.entity.Payment;
import com.leon.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @Author chengliang
 * @Date 2022/3/16 0:59
 */
@RestController
@Slf4j
public class OrderController {

    //注入自定义负载均衡算法
    @Autowired
    private LoadBalancer loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    //单机版
    //public static final String PAYMENT_URL = "http://localhost:8001";
    //通过服务名称访问 集群版可实现负载均衡
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/lb")
    public Integer getPaymentLB() {

        //获取所有服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        //获取应访问的服务
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        //获取服务地址
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri + "/payment/lb", Integer.class);

    }
}
