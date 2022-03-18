package com.leon.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author chengliang
 * @Date 2022/3/18 22:47
 */

@Configuration
public class MyRule {

    @Bean(name = "leonRule")
    public IRule myRule() {
        //随机访问
        return new RandomRule();
    }
}
