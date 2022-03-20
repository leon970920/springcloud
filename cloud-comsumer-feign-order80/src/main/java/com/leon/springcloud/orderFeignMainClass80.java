package com.leon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author chengliang
 * @Date 2022/3/20 22:09
 */

@SpringBootApplication
@EnableFeignClients
public class orderFeignMainClass80 {
    public static void main(String[] args) {
        SpringApplication.run(orderFeignMainClass80.class, args);
    }
}
