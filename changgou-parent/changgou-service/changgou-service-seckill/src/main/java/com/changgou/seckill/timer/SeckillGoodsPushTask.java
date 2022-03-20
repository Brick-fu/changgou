package com.changgou.seckill.timer;

import com.changgou.common.enums.GoodsEnum;
import com.changgou.common.utils.DateUtil;
import com.changgou.seckill.pojo.SeckillGoods;
import com.changgou.seckill.service.SeckillGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Set;

//@Component
public class SeckillGoodsPushTask {

    private final Logger logger = LoggerFactory.getLogger(SeckillGoodsPushTask.class);

    @Autowired
    private SeckillGoodsService seckillGoodsService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Scheduled(cron = "0/30 * * * * *")
    public void loadGoodsPushRedis(){
        List<Date> dateMenus = DateUtil.getDateMenus();
        for (Date date:dateMenus) {
            String extName = DateUtil.formatDateTo10(date);
            logger.info("SeckillGoodsPushTask.loadGoodsPushRedis,task-{}",DateUtil.formatDateTo10(date));
            SeckillGoods seckillGoods = new SeckillGoods();
            seckillGoods.setStatus(GoodsEnum.AUDITED.getCode());
            seckillGoods.setStartTime(date);
            seckillGoods.setEndTime(DateUtil.addDateHour(date,2));
            //获取redis已存在的商品
            Set keys = redisTemplate.opsForHash().keys("SeckillGoods_" + extName);
            seckillGoods.setIds(keys);
            List<SeckillGoods> seckillGoodsList = seckillGoodsService.querySeckillGoods(seckillGoods);
            for (SeckillGoods goods : seckillGoodsList) {
                //将秒杀商品存入redis
                redisTemplate.opsForHash().put("SeckillGoods_" + extName,goods.getId(),goods);
                //设置秒杀商品2小时过期
                redisTemplate.expireAt("SeckillGoods_" + extName,DateUtil.addDateHour(date,2));
                //设置自增计数器
                redisTemplate.opsForHash().increment("SeckillGoodsCount",goods.getId(),goods.getStockCount());
            }
        }
    }
}