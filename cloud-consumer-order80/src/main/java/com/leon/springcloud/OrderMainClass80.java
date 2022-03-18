package com.leon.springcloud;

import com.leon.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author chengliang
 * @Date 2022/3/16 0:56
 */
@SpringBootApplication
@EnableEurekaClient
//启用自定义负载均衡策略
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRule.class)
public class OrderMainClass80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainClass80.class, args);
    }
}
