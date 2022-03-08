package com.changgou.pay.queue;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PayQueue {

    @Autowired
    private Environment env;

    @Bean
    public Exchange directExchange(){
        return new DirectExchange(env.getProperty("mq.pay.exchange.order"),true,false);
    }

    @Bean
    public Queue orderQueue(){
        return new Queue(env.getProperty("mq.pay.queue.order"),true);
    }

    @Bean
    public Binding orderBinding(Queue orderQueue, Exchange directExchange){
        return BindingBuilder.bind(orderQueue).to(directExchange).with(env.getProperty("mq.pay.routing.key")).noargs();
    }
}
