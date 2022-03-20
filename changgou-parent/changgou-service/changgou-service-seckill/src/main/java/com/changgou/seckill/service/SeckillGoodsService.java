package com.changgou.seckill.service;

import com.changgou.seckill.pojo.SeckillGoods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (SeckillGoods)表服务接口
 *
 * @author makejava
 * @since 2022-03-19 14:00:27
 */
public interface SeckillGoodsService {

    /****
     * 根据ID查询商品详情
     * @param time:时间区间
     * @param id:商品ID
     */
    SeckillGoods detail(String time,Long id);

    /***
     * 获取指定时间对应的秒杀商品列表
     * @param key
     */
    List<SeckillGoods> list(String key);

    /*
     * @Desc 查询秒杀商品
     * @Date 下午8:12 2022/3/19
     * @Author brick
     **/
    List<SeckillGoods> querySeckillGoods(SeckillGoods seckillGoods);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SeckillGoods queryById(Long id);

    /**
     * 分页查询
     *
     * @param seckillGoods 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SeckillGoods> queryByPage(SeckillGoods seckillGoods, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param seckillGoods 实例对象
     * @return 实例对象
     */
    SeckillGoods insert(SeckillGoods seckillGoods);

    /**
     * 修改数据
     *
     * @param seckillGoods 实例对象
     * @return 实例对象
     */
    SeckillGoods update(SeckillGoods seckillGoods);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
