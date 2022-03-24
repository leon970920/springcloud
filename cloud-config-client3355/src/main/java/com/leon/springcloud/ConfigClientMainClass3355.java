package com.leon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author chengliang
 * @Date 2022/3/25 0:34
 */

@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMainClass3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMainClass3355.class, args);
    }
}
