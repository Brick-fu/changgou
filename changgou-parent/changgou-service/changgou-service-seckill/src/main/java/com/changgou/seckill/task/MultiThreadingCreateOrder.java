package com.changgou.seckill.task;

import com.changgou.common.enums.OrderEnum;
import com.changgou.common.enums.SeckillEnum;
import com.changgou.common.enums.StatusCodeEnum;
import com.changgou.common.exception.BizException;
import com.changgou.common.utils.IdWorker;
import com.changgou.seckill.dao.SeckillGoodsDao;
import com.changgou.seckill.pojo.SeckillGoods;
import com.changgou.seckill.pojo.SeckillOrder;
import com.changgou.seckill.pojo.SeckillStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class MultiThreadingCreateOrder {

    @Resource
    private SeckillGoodsDao seckillGoodsDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IdWorker idWorker;

    private final Logger logger = LoggerFactory.getLogger(MultiThreadingCreateOrder.class);

    /***
     * 多线程下单操作
     */
    @Async("taskExecutor")
    public void createOrder(){
        SeckillStatus seckillStatus = (SeckillStatus) redisTemplate.opsForList().leftPop("SeckillOrderQueue");
        try {
            logger.info("MultiThreadingCreateOrder.createOrder,准备执行....");
            Thread.sleep(20000);
            logger.info("MultiThreadingCreateOrder.createOrder,开始执行....");

            if(seckillStatus != null){
                String time = seckillStatus.getTime();
                String username = seckillStatus.getUsername();
                Long id = seckillStatus.getGoodsId();

                SeckillGoods seckillGoods = (SeckillGoods) redisTemplate.opsForHash().get("SeckillGoods_" + time, id);

                if(seckillGoods == null || seckillGoods.getStockCount() <= 0){
                    throw new BizException(StatusCodeEnum.SECKILL_GOODS_STOCK_COUONT_SHORTAGE);
                }
                SeckillOrder seckillOrder = new SeckillOrder();
                seckillOrder.setId(Long.valueOf(idWorker.nextId()));
                seckillOrder.setUserId(username);
                Date date = new Date();
                seckillOrder.setCreateTime(date);
                seckillOrder.setStatus(OrderEnum.PAY_STATE_NO.getCode());
                seckillOrder.setSeckillId(seckillGoods.getId());
                seckillOrder.setMoney(seckillGoods.getCostPrice());

                redisTemplate.opsForHash().put("SeckillOrder",username,seckillOrder);

                //递减库存
                Long stockCount = redisTemplate.opsForHash().increment("SeckillGoodsCount", id, -1);
                seckillGoods.setStockCount(stockCount.intValue());
                //判断当前库存是否存在
                if(stockCount <= 0){
                    //当库存为零后，更新数据库数据
                    seckillGoodsDao.update(seckillGoods);
                    //删除redis中商品
                    redisTemplate.opsForHash().delete("SeckillGoods_" + time, id);
                    //删除rdis中库存
                    redisTemplate.opsForHash().delete("SeckillGoodsCount",id);
                }else{
                    //或者更新redis中商品库存
                    redisTemplate.opsForHash().put("SeckillGoods_" + time, id, seckillGoods);
                }
                seckillStatus.setOrderId(seckillOrder.getId());
                seckillStatus.setMoney(seckillOrder.getMoney().floatValue());
                seckillStatus.setStatus(SeckillEnum.SECKILL_WAITING_FOR_PAYMENT.getCode());
                redisTemplate.boundHashOps("UserQueueStatus").put(username,seckillStatus);
            }

        } catch (InterruptedException e) {
            logger.error("商品下单失败！",e);
        }
    }

}
