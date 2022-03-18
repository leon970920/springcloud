package com.leon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author chengliang
 * @Date 2022/3/18 0:34
 */

@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMainClass80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZKMainClass80.class, args);
    }
}
