package com.leon.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author chengliang
 * @Date 2022/3/24 0:53
 */
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("进入全局过滤器！！！！！！！！");
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");

        //直接返回
        if (uname == null) {
            log.info("用户名非法！！！！");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }

        //进入过滤链
        return chain.filter(exchange);
    }

    /**
     * 过滤器顺序
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
