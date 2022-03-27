package com.leon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author chengliang
 * @Date 2022/3/28 0:05
 */

@SpringBootApplication
@EnableDiscoveryClient
public class NacosOrderConsumerMainClass83 {
    public static void main(String[] args) {
        SpringApplication.run(NacosOrderConsumerMainClass83.class, args);
    }
}
