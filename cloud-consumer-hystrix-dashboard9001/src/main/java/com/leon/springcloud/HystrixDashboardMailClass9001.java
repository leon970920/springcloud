package com.leon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author chengliang
 * @Date 2022/3/22 1:38
 */

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMailClass9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMailClass9001.class, args);
    }
}
