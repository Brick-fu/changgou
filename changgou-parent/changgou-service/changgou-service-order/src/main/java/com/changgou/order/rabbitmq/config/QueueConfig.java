package com.changgou.order.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    private static final String  delayQueue = "order.delay.queue";
    private static final String orderQueue = "order.listener.queue";
    private static final String orderExchange = "order.listener.exchange";

    @Bean
    public Queue orderDelayQueue(){
        return QueueBuilder.durable(delayQueue)
                .withArgument("x-dead-letter-exchange",orderExchange)
                .withArgument("x-dead-letter-routing-key",orderQueue)
                .build();
    }

    @Bean
    public Queue orderListenerQueue(){
        return new Queue(orderQueue,true);
    }

    @Bean
    public Exchange orderListenerExchange(){
        return new DirectExchange(orderExchange,true,false);
    }

    @Bean
    public Binding orderListenerBinding(){
        return BindingBuilder.bind(orderListenerQueue()).to(orderListenerExchange()).with(orderQueue).noargs();
    }
}
