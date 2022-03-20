package com.changgou.seckill.service.impl;

import com.changgou.common.enums.GoodsEnum;
import com.changgou.common.enums.OrderEnum;
import com.changgou.common.enums.StatusCodeEnum;
import com.changgou.common.exception.BizException;
import com.changgou.common.utils.IdWorker;
import com.changgou.seckill.pojo.SeckillGoods;
import com.changgou.seckill.dao.SeckillGoodsDao;
import com.changgou.seckill.pojo.SeckillOrder;
import com.changgou.seckill.service.SeckillGoodsService;
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
import java.util.List;

/**
 * (SeckillGoods)表服务实现类
 *
 * @author makejava
 * @since 2022-03-19 14:00:27
 */
@Service("seckillGoodsService")
public class SeckillGoodsServiceImpl implements SeckillGoodsService {
    @Resource
    private SeckillGoodsDao seckillGoodsDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IdWorker idWorker;

    private final Logger logger = LoggerFactory.getLogger(SeckillGoodsServiceImpl.class);

    /****
     * 根据商品ID查询商品详情
     * @param time:时间区间
     * @param id:商品ID
     * @return
     */
    @Override
    public SeckillGoods detail(String time, Long id) {
        logger.info("SeckillGoodsServiceImpl.detail,{},{}",time,id);
        return (SeckillGoods) redisTemplate.boundHashOps("SeckillGoods_" + time).get(id);
    }

    /***
     * Redis中根据Key获取秒杀商品列表
     * @param key
     * @return
     */
    @Override
    public List<SeckillGoods> list(String key) {
        logger.info("SeckillGoodsServiceImpl.detail,{}",key);
        return redisTemplate.boundHashOps("SeckillGoods_" + key).values();
    }

    @Override
    public List<SeckillGoods> querySeckillGoods(SeckillGoods seckillGoods) {
        logger.info("SeckillGoodsServiceImpl.querySeckillGoods,{}",seckillGoods);
        return seckillGoodsDao.querySeckillGoods(seckillGoods);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SeckillGoods queryById(Long id) {
        return this.seckillGoodsDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param seckillGoods 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SeckillGoods> queryByPage(SeckillGoods seckillGoods, PageRequest pageRequest) {
        logger.info("SeckillGoodsServiceImpl.queryByPage,{},{}",seckillGoods,pageRequest);
        long total = this.seckillGoodsDao.count(seckillGoods);
        return new PageImpl<>(this.seckillGoodsDao.queryAllByLimit(seckillGoods, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param seckillGoods 实例对象
     * @return 实例对象
     */
    @Override
    public SeckillGoods insert(SeckillGoods seckillGoods) {
        this.seckillGoodsDao.insert(seckillGoods);
        return seckillGoods;
    }

    /**
     * 修改数据
     *
     * @param seckillGoods 实例对象
     * @return 实例对象
     */
    @Override
    public SeckillGoods update(SeckillGoods seckillGoods) {
        this.seckillGoodsDao.update(seckillGoods);
        return this.queryById(seckillGoods.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.seckillGoodsDao.deleteById(id) > 0;
    }
}
