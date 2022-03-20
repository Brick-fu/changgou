package com.changgou.order.service.impl;

import com.changgou.common.enums.OrderEnum;
import com.changgou.common.enums.OrderItemEnum;
import com.changgou.common.utils.DateUtil;
import com.changgou.goods.feign.SkuFeign;
import com.changgou.order.controller.OrderController;
import com.changgou.order.dao.OrderItemDao;
import com.changgou.order.pojo.Order;
import com.changgou.order.dao.OrderDao;
import com.changgou.order.pojo.OrderItem;
import com.changgou.order.service.CartService;
import com.changgou.order.service.OrderService;
import com.changgou.common.utils.IdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * (TbOrder)表服务实现类
 *
 * @author makejava
 * @since 2022-02-14 23:09:12
 */
@Service("tbOrderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Autowired
    private CartService cartService;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SkuFeign skuFeign;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final Logger logger = LoggerFactory.getLogger(OrderController.class);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Order queryById(String id) {
        return this.orderDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param order 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Order> queryByPage(Order order, PageRequest pageRequest) {
        long total = this.orderDao.count(order);
        return new PageImpl<>(this.orderDao.queryAllByLimit(order, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order insert(Order order) {
        this.orderDao.insert(order);
        return order;
    }

    @Override
    public Order saveOrder(Order order) {
        List<Long> skuIds = order.getSkuIds();
        List<OrderItem> orderItems = new ArrayList<>();
        //统计计算
        int totalMoney = 0;
        int totalPayMoney=0;
        int num = 0;
        Map<String,Integer> map = new HashMap<>();
        for(Long skuId:skuIds){
            OrderItem orderItem = (OrderItem) redisTemplate.opsForHash().get("CART_" + order.getUsername(), skuId);
            logger.info("TbOrderServiceImpl.saveOrder.orderItem,{}", orderItem);
            //总金额
            totalMoney += orderItem.getMoney();
            //实际支付金额
            totalPayMoney += orderItem.getPayMoney();
            //总数量
            num += orderItem.getNum();
            orderItems.add(orderItem);
            map.put(String.valueOf(orderItem.getSkuId()), orderItem.getNum());
        }
        order.setTotalNum(num);
        order.setTotalMoney(totalMoney);
        order.setPayMoney(totalPayMoney);
        order.setPreMoney(totalMoney-totalPayMoney);
        //其他数据完善
        order.setCreateTime(new Date());
        order.setUpdateTime(order.getCreateTime());
        order.setBuyerRate(OrderEnum.NO.getCode());        //0:未评价，1：已评价
        order.setSourceType(OrderEnum.ORDER_SOURCE_WEB.getCode());       //来源，1：WEB
        order.setOrderStatus(OrderEnum.ORDER_STATE_NO_COMPLETE.getCode());      //0:未完成,1:已完成，2：已退货
        order.setPayStatus(OrderEnum.PAY_STATE_NO.getCode());        //0:未支付，1：已支付，2：支付失败
        order.setConsignStatus(OrderEnum.CONSIGN_STATE_NO.getCode());    //0:未发货，1：已发货，2：已收货
        order.setId(String.valueOf(idWorker.nextId()));

        //int count = this.tbOrderDao.insert(tbOrder);
        //将订单放到redis中
        redisTemplate.opsForHash().put("ORDER", order.getId(), order);
        for(OrderItem orderItem: orderItems){
            orderItem.setId(String.valueOf(idWorker.nextId()));
            orderItem.setIsReturn(OrderItemEnum.NO_RETURN_GOODS.getCode());
            orderItem.setOrderId(order.getId());
            orderItemDao.insert(orderItem);
            //将订单明细放到redis中
            //redisTemplate.opsForList().rightPush(tbOrder.getId(),orderItem);
            //清除购物车
            redisTemplate.opsForHash().delete("CART_" + order.getUsername(),orderItem.getSkuId());
        }

        //删除商品库存
        skuFeign.decrCount(map);

        //发送延时消息
        rabbitTemplate.convertAndSend("order.delay.queue", (Object) order.getId(), new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setExpiration("20000");
                return message;
            }
        });
        return order;
    }

    /*
     * @Desc 修改订单状态
     * @Date 下午6:20 2022/3/6
     * @Author brick
     **/
    @Override
    public void updateStatus(Map<String,String> map) {
        String transactionId = String.valueOf(map.get("transaction_id"));
        String orderId = String.valueOf(map.get("out_trade_no"));
        String timeStr = String.valueOf(map.get("time_end"));
        String payState = String.valueOf(map.get("payState"));
        Date payTime = null;
        if(!StringUtils.isEmpty(timeStr)){
            payTime = DateUtil.parseDateBy14(timeStr);
        }
        //1.修改订单状态
        Order order = (Order) redisTemplate.opsForHash().get("ORDER",orderId);
        order.setUpdateTime(new Date());
        order.setPayTime(payTime);
        order.setTransactionId(transactionId);  //交易流水号
        order.setPayStatus(payState);    //支付状态
        orderDao.insert(order);
        //List<TbOrderItem> list = redisTemplate.opsForList().range(order.getId(), 0, -1);
        //2.删除Redis中的订单记录
        redisTemplate.boundHashOps("ORDER").delete(orderId);
    }

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order update(Order order) {
        this.orderDao.update(order);
        return order;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.orderDao.deleteById(id) > 0;
    }
}
