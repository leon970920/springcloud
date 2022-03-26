package com.leon.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author chengliang
 * @Date 2022/3/27 1:42
 */

//@Component
@EnableBinding(Sink.class) //绑定消息的接受通道 Sink
public class ReceiveMessageController {

    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT) //监听是否有消息
    public void receiveMessage(Message<String> message) {
        System.out.println("消费者1号接收到消息： " + message.getPayload() + "\t" + "port: " + serverPort);
    }
}
