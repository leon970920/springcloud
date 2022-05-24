package com.leon.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.leon.springcloud.entity.CommonResult;

/**
 * @Author chengliang
 * @Date 2022/5/24 0:35
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException exception) {
        return new CommonResult(444, "按客户自定义,global----------1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444, "按客户自定义,global--------2");
    }
}
