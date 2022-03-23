package com.leon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author chengliang
 * @Date 2022/3/23 23:15
 */

@SpringBootApplication
@EnableEurekaClient
public class GatewayMainClass9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMainClass9527.class, args);
    }
}
