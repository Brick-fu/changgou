package com.changgou.canal.handler;

import com.alibaba.fastjson.JSON;
import com.changgou.content.feign.ContentFeign;
import com.changgou.content.pojo.TbContent;
import com.changgou.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;

import java.util.List;

@Component
@CanalTable(value = "tb_content")
public class TbContentHandler implements EntryHandler<TbContent> {

    private Logger logger = LoggerFactory.getLogger(TbContentHandler.class);
    @Autowired
    private ContentFeign contentFeign;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void insert(TbContent tbContent) {
        logger.info("insert message  {}", tbContent);
        saveRedis(tbContent);
    }

    @Override
    public void update(TbContent before, TbContent after) {
        logger.info("update before {} ", before);
        logger.info("update after {}", after);
        saveRedis(after);
    }

    @Override
    public void delete(TbContent tbContent) {
        logger.info("delete  {}", tbContent);
        saveRedis(tbContent);
    }
    
    private void saveRedis(TbContent tbContent){
        //2.调用feign 获取该分类下的所有的广告集合
        Result<List<TbContent>> result = contentFeign.findByCategory(tbContent.getCategoryId());
        List<TbContent> contents = result.getData();
        //3.使用redisTemplate存储到redis中
        stringRedisTemplate.boundValueOps("content_" + tbContent.getCategoryId()).set(JSON.toJSONString(contents));
    }
}
