package com.leon.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author chengliang
 * @Date 2022/4/3 15:19
 */

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        //暂停800毫秒
//        try {
//            TimeUnit.MILLISECONDS.sleep(800);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return "test-----A";
    }

    @GetMapping("/testB")
    public String testB(){
        return "test-----B";
    }


    @GetMapping("/testHotKey")
    //Sentinel默认提示都是Blocked by Sentinel(flow limiting)
    //触发规则后自定义兜底策略
    @SentinelResource(value = "testHotKey",blockHandler = "dealHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2) {
        return "-------testHotKey";
    }

    public String dealHotKey(String p1, String p2, BlockException exception) {
        return "-----dealHotKey";
    }
}
