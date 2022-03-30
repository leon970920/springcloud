package com.leon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author chengliang
 * @Date 2022/3/29 23:28
 */

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClientMainClass3377 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientMainClass3377.class, args);
    }
}
