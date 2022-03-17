package com.changgou.order.rabbitmq.listener;

import com.alibaba.fastjson.JSON;
import com.changgou.common.enums.OrderEnum;
import com.changgou.order.service.TbOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@RabbitListener(queues = {"${mq.pay.queue.order}"})
public class OrderPayMessageListener {

    @Autowired
    private TbOrderService orderService;

    private final Logger logger = LoggerFactory.getLogger(OrderPayMessageListener.class);

    @RabbitHandler
    public void consumeMessage(String msg){
        logger.info("OrderPayMessageListener.consumeMessage,{}",msg);
        Map<String,String> map = JSON.parseObject(msg, Map.class);
        String return_code = map.get("return_code");
        String return_msg = map.get("return_msg");

        if("SUCCESS".equals(return_code)){
            String result_code = map.get("result_code");
            String err_code_des = map.get("err_code_des");
            String err_code = map.get("err_code");
            String transaction_id = map.get("transaction_id");
            String out_trade_no = map.get("out_trade_no");
            String time_end = map.get("time_end");
            if("SUCCESS".equals(result_code)){
                map.put("payState", OrderEnum.PAY_STATE_YES.getCode());
            }else{
                //支付失败，调佣微信关闭支付，取消订单回滚库存！
                logger.info("支付失败!code={}，msg：{}",err_code,err_code_des);
                map.put("payState", OrderEnum.PAY_STATE_FAIL.getCode());
            }
            orderService.updateStatus(map);
        }else{
            logger.info("支付失败!code={}，msg：{}",return_code,return_msg);
        }
    }
}
