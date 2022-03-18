package com.leon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author chengliang
 * @Date 2022/3/17 0:10
 */

@SpringBootApplication
@EnableEurekaClient
public class PaymentMainClass8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMainClass8002.class, args);
    }
}
