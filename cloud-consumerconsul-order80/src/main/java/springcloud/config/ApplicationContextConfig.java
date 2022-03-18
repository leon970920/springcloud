package springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author chengliang
 * @Date 2022/3/16 1:03
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //赋予restTemplate负载均衡的能力  默认轮询
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
