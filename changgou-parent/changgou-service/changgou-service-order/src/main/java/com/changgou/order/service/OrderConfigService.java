package com.changgou.order.service;

import com.changgou.order.pojo.OrderConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (OrderConfig)表服务接口
 *
 * @author makejava
 * @since 2022-03-19 14:09:57
 */
public interface OrderConfigService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderConfig queryById(Integer id);

    /**
     * 分页查询
     *
     * @param orderConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<OrderConfig> queryByPage(OrderConfig orderConfig, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param orderConfig 实例对象
     * @return 实例对象
     */
    OrderConfig insert(OrderConfig orderConfig);

    /**
     * 修改数据
     *
     * @param orderConfig 实例对象
     * @return 实例对象
     */
    OrderConfig update(OrderConfig orderConfig);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
