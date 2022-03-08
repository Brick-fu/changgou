package com.changgou.order.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@RabbitListener(queues = {"order.listener.queue"})
public class OrderDelayMessageListener {

    @RabbitHandler
    public void getMsg(String msg){
        System.out.println("获得监听消息：" + msg);
    }
}
