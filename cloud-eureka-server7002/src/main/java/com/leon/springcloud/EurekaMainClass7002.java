package com.leon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author chengliang
 * @Date 2022/3/16 23:49
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaMainClass7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMainClass7002.class, args);
    }
}
