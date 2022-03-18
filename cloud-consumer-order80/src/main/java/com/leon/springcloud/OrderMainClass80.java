package com.leon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author chengliang
 * @Date 2022/3/16 0:56
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderMainClass80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainClass80.class, args);
    }
}
