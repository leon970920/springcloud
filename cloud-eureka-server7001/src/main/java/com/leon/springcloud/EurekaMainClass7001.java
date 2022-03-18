package com.leon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 访问 localhost:7001进入Eureka Server界面
 *
 * @Author chengliang
 * @Date 2022/3/16 23:21
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaMainClass7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMainClass7001.class, args);
    }
}
