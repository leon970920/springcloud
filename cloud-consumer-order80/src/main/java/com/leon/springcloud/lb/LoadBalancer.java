package com.leon.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author chengliang
 * @Date 2022/3/18 23:22
 */
public interface LoadBalancer {
    /**
     * 获取本次请求需访问的服务实例
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
