package com.changgou.order.service.impl;

import com.changgou.common.enums.OrderEnum;
import com.changgou.common.enums.OrderItemEnum;
import com.changgou.common.utils.DateUtil;
import com.changgou.goods.feign.SkuFeign;
import com.changgou.order.dao.TbOrderItemDao;
import com.changgou.order.pojo.TbOrder;
import com.changgou.order.dao.TbOrderDao;
import com.changgou.order.pojo.TbOrderItem;
import com.changgou.order.service.CartService;
import com.changgou.order.service.TbOrderService;
import com.changgou.common.utils.IdWorker;
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
public class TbOrderServiceImpl implements TbOrderService {
    @Resource
    private TbOrderDao tbOrderDao;

    @Autowired
    private CartService cartService;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private TbOrderItemDao tbOrderItemDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SkuFeign skuFeign;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbOrder queryById(String id) {
        return this.tbOrderDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbOrder> queryByPage(TbOrder tbOrder, PageRequest pageRequest) {
        long total = this.tbOrderDao.count(tbOrder);
        return new PageImpl<>(this.tbOrderDao.queryAllByLimit(tbOrder, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbOrder 实例对象
     * @return 实例对象
     */
    @Override
    public TbOrder insert(TbOrder tbOrder) {
        this.tbOrderDao.insert(tbOrder);
        return tbOrder;
    }

    @Override
    public TbOrder saveOrder(TbOrder tbOrder) {
        List<Long> skuIds = tbOrder.getSkuIds();
        List<TbOrderItem> tbOrderItems = new ArrayList<>();
        //统计计算
        int totalMoney = 0;
        int totalPayMoney=0;
        int num = 0;
        Map<String,Integer> map = new HashMap<>();
        for(Long skuId:skuIds){
            TbOrderItem tbOrderItem = (TbOrderItem) redisTemplate.opsForHash().get("cart_" + tbOrder.getUsername(), skuId);
            //总金额
            totalMoney += tbOrderItem.getMoney();
            //实际支付金额
            totalPayMoney += tbOrderItem.getPayMoney();
            //总数量
            num += tbOrderItem.getNum();
            tbOrderItems.add(tbOrderItem);
            map.put(String.valueOf(tbOrderItem.getSkuId()),tbOrderItem.getNum());
        }
        tbOrder.setTotalNum(num);
        tbOrder.setTotalMoney(totalMoney);
        tbOrder.setPayMoney(totalPayMoney);
        tbOrder.setPreMoney(totalMoney-totalPayMoney);
        //其他数据完善
        tbOrder.setCreateTime(new Date());
        tbOrder.setUpdateTime(tbOrder.getCreateTime());
        tbOrder.setBuyerRate(OrderEnum.NO.getCode());        //0:未评价，1：已评价
        tbOrder.setSourceType(OrderEnum.ORDER_SOURCE_WEB.getCode());       //来源，1：WEB
        tbOrder.setOrderStatus(OrderEnum.ORDER_STATE_NO_COMPLETE.getCode());      //0:未完成,1:已完成，2：已退货
        tbOrder.setPayStatus(OrderEnum.PAY_STATE_NO.getCode());        //0:未支付，1：已支付，2：支付失败
        tbOrder.setConsignStatus(OrderEnum.CONSIGN_STATE_NO.getCode());    //0:未发货，1：已发货，2：已收货
        tbOrder.setId(String.valueOf(idWorker.nextId()));

        //int count = this.tbOrderDao.insert(tbOrder);
        //将订单放到redis中
        redisTemplate.opsForHash().put("ORDER",tbOrder.getId(),tbOrder);
        for(TbOrderItem orderItem:tbOrderItems){
            orderItem.setId(String.valueOf(idWorker.nextId()));
            orderItem.setIsReturn(OrderItemEnum.NO_RETURN_GOODS.getCode());
            orderItem.setOrderId(tbOrder.getId());
            tbOrderItemDao.insert(orderItem);
            //将订单明细放到redis中
            //redisTemplate.opsForList().rightPush(tbOrder.getId(),orderItem);
            //清除购物车
            redisTemplate.opsForHash().delete("cart_" + tbOrder.getUsername(),orderItem.getSkuId());
        }

        //删除商品库存
        skuFeign.decrCount(map);

        //发送延时消息
        rabbitTemplate.convertAndSend("order.listener.exchange", (Object) tbOrder.getId(), new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setExpiration("10000");
                return message;
            }
        });
        return tbOrder;
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
        TbOrder order = (TbOrder) redisTemplate.opsForHash().get("ORDER",orderId);
        order.setUpdateTime(new Date());
        order.setPayTime(payTime);
        order.setTransactionId(transactionId);  //交易流水号
        order.setPayStatus(payState);    //支付状态
        tbOrderDao.insert(order);
        //List<TbOrderItem> list = redisTemplate.opsForList().range(order.getId(), 0, -1);
        //2.删除Redis中的订单记录
        redisTemplate.boundHashOps("Order").delete(orderId);
    }

    /**
     * 修改数据
     *
     * @param tbOrder 实例对象
     * @return 实例对象
     */
    @Override
    public TbOrder update(TbOrder tbOrder) {
        this.tbOrderDao.update(tbOrder);
        return tbOrder;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.tbOrderDao.deleteById(id) > 0;
    }
}
