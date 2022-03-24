package com.leon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author chengliang
 * @Date 2022/3/24 23:31
 */

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigCenter3344MainClass {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenter3344MainClass.class, args);
    }
}
