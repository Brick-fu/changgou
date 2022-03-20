package com.changgou.seckill.service.impl;

import com.changgou.common.enums.OrderEnum;
import com.changgou.common.enums.SeckillEnum;
import com.changgou.common.enums.StatusCodeEnum;
import com.changgou.common.exception.BizException;
import com.changgou.common.utils.IdWorker;
import com.changgou.seckill.dao.SeckillGoodsDao;
import com.changgou.seckill.pojo.SeckillGoods;
import com.changgou.seckill.pojo.SeckillOrder;
import com.changgou.seckill.dao.SeckillOrderDao;
import com.changgou.seckill.pojo.SeckillStatus;
import com.changgou.seckill.service.SeckillOrderService;
import com.changgou.seckill.task.MultiThreadingCreateOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.Date;

/**
 * (SeckillOrder)表服务实现类
 *
 * @author makejava
 * @since 2022-03-19 12:02:53
 */
@Service("seckillOrderService")
public class SeckillOrderServiceImpl implements SeckillOrderService {
    @Resource
    private SeckillOrderDao seckillOrderDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private MultiThreadingCreateOrder multiThreadingCreateOrder;

    private final Logger logger = LoggerFactory.getLogger(SeckillGoodsServiceImpl.class);

    /***
     * 抢单状态查询
     * @param username
     * @return
     */
    @Override
    public SeckillStatus queryStatus(String username) {
        logger.info("SeckillOrderServiceImpl.queryStatus,{}", username);
        return (SeckillStatus) redisTemplate.boundHashOps("UserQueueStatus").get(username);
    }

    /*
     * @Desc 添加抢购订单
     * @Date 下午5:25 2022/3/20
     * @Author brick
     **/
    @Override
    public Boolean add(Long id, String time, String username) {
        logger.info("SeckillOrderServiceImpl.add,time={},id={}，username={}",time, id, username);

        Long count = redisTemplate.opsForHash().increment("UserQueueCount", username, 1);
        logger.info("SeckillOrderServiceImpl.add,count={}",count);
        if(count > 1){
            throw new BizException(StatusCodeEnum.NOT_DOUBLE_ORDERING);
        }
        //获取自增计数器(库存)值
        Integer stockCount = (Integer) redisTemplate.opsForHash().get("SeckillGoodsCount", id);
        if(stockCount == null || stockCount <= 0){
            clearUserQueueInfo(username);
            throw new BizException(StatusCodeEnum.SECKILL_GOODS_STOCK_COUONT_SHORTAGE);
        }

        //加入下单队列
        SeckillStatus seckillStatus = new SeckillStatus(username,new Date(), SeckillEnum.QUEUING.getCode(),id,time);
        //放入redis队列中
        redisTemplate.opsForList().rightPush("SeckillOrderQueue",seckillStatus);
        //将抢单状态存入到Redis中
        redisTemplate.boundHashOps("UserQueueStatus").put(username,seckillStatus);
        //异步下单
        multiThreadingCreateOrder.createOrder();
        return true;
    }

    //清理用户队列信息
    public void clearUserQueueInfo(String username){
        redisTemplate.opsForHash().delete("UserQueueCount",username);
        redisTemplate.opsForHash().delete("UserQueueStatus",username);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SeckillOrder queryById(Long id) {
        return this.seckillOrderDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param seckillOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SeckillOrder> queryByPage(SeckillOrder seckillOrder, PageRequest pageRequest) {
        long total = this.seckillOrderDao.count(seckillOrder);
        return new PageImpl<>(this.seckillOrderDao.queryAllByLimit(seckillOrder, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param seckillOrder 实例对象
     * @return 实例对象
     */
    @Override
    public SeckillOrder insert(SeckillOrder seckillOrder) {
        this.seckillOrderDao.insert(seckillOrder);
        return seckillOrder;
    }

    /**
     * 修改数据
     *
     * @param seckillOrder 实例对象
     * @return 实例对象
     */
    @Override
    public SeckillOrder update(SeckillOrder seckillOrder) {
        this.seckillOrderDao.update(seckillOrder);
        return this.queryById(seckillOrder.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.seckillOrderDao.deleteById(id) > 0;
    }
}
