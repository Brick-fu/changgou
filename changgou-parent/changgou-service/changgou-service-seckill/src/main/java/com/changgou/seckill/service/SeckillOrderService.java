package com.changgou.seckill.service;

import com.changgou.seckill.pojo.SeckillOrder;
import com.changgou.seckill.pojo.SeckillStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (SeckillOrder)表服务接口
 *
 * @author makejava
 * @since 2022-03-19 12:02:52
 */
public interface SeckillOrderService {

    /***
     * 抢单状态查询
     * @param username
     */
    SeckillStatus queryStatus(String username);

    /***
     * 添加秒杀订单
     * @param id:商品ID
     * @param time:商品秒杀开始时间
     * @param username:用户登录名
     * @return
     */
    Boolean add(Long id, String time, String username);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SeckillOrder queryById(Long id);

    /**
     * 分页查询
     *
     * @param seckillOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SeckillOrder> queryByPage(SeckillOrder seckillOrder, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param seckillOrder 实例对象
     * @return 实例对象
     */
    SeckillOrder insert(SeckillOrder seckillOrder);

    /**
     * 修改数据
     *
     * @param seckillOrder 实例对象
     * @return 实例对象
     */
    SeckillOrder update(SeckillOrder seckillOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
