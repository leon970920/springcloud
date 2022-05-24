package com.leon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author chengliang
 * @Date 2022/4/3 15:18
 */

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMainClass8401 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelMainClass8401.class, args);
    }
}
