package com.changgou.order.rabbitmq.listener;

import com.changgou.common.utils.DateUtil;
import com.changgou.order.service.impl.CartServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@RabbitListener(queues = {"order.listener.queue"})
public class OrderDelayMessageListener {

    private final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

    @RabbitHandler
    public void getMsg(String msg){
        System.out.println(DateUtil.getDateTimeTo14() + "获得监听消息：" + msg);
        logger.info("OrderDelayMessageListener.getMsg,{}",msg);
        //判断订单是否被支付，如果支付不做操作
        //如果没用支付，取消订单
        //取消微信支付
        //回退库存
    }
}
