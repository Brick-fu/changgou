package com.changgou.order.service;

import com.changgou.order.pojo.TbOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.Map;

/**
 * (TbOrder)表服务接口
 *
 * @author makejava
 * @since 2022-02-14 23:09:12
 */
public interface TbOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbOrder queryById(String id);

    /**
     * 分页查询
     *
     * @param tbOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbOrder> queryByPage(TbOrder tbOrder, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbOrder 实例对象
     * @return 实例对象
     */
    TbOrder insert(TbOrder tbOrder);
    
    /*
     * @Desc 保存订单信息
     * @Date 下午10:48 2022/3/5
     * @Author brick
     **/
    TbOrder saveOrder(TbOrder tbOrder);

    /***
     * 根据订单ID修改订单状态
     * @param map
     */
    void updateStatus(Map<String,String> map);

    /**
     * 修改数据
     *
     * @param tbOrder 实例对象
     * @return 实例对象
     */
    TbOrder update(TbOrder tbOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
