package com.leon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author chengliang
 * @Date 2022/3/18 0:01
 */

@SpringBootApplication
//该注解用于向consul或zookeeper作为注册中心时注册服务
@EnableDiscoveryClient
public class PaymentMainClass8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMainClass8004.class, args);
    }
}
