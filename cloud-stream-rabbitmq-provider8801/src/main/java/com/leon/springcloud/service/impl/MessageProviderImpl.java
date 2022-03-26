package com.leon.springcloud.service.impl;

import cn.hutool.core.lang.UUID;
import com.leon.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

/**
 * @Author chengliang
 * @Date 2022/3/27 1:21
 */

@EnableBinding(Source.class)  //绑定消息的推送管道 源
public class MessageProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel output; //消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        //发送消息
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("***********serial: " + serial);
        return null;
    }
}
