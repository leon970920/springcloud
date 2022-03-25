package com.leon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author chengliang
 * @Date 2022/3/26 1:12
 */

@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMainClass3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMainClass3366.class, args);
    }
}
