package com.leon.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author chengliang
 * @Date 2022/3/18 23:25
 */

@Component
public class MyLB implements LoadBalancer {
    //并发原子类
    //当前请求次数，默认从0开始
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //得到当前请求总次数
    public final int getAndIncrement() {
        int current;
        int next;
        //自选获取服务请求总次数next，并将下一次请求的current设置为next
        do {
            current = atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("************next: " + next);

        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
