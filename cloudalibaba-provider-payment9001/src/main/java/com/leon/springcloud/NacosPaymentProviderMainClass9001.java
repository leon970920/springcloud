package com.leon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author chengliang
 * @Date 2022/3/27 23:43
 */

@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentProviderMainClass9001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentProviderMainClass9001.class, args);
    }
}
