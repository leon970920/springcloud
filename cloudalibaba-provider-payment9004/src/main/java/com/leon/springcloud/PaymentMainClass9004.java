package com.leon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author chengliang
 * @Date 2022/5/24 23:15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMainClass9004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMainClass9004.class, args);
    }
}
