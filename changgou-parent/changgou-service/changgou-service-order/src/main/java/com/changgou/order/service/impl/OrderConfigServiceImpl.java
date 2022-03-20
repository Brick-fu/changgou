package com.changgou.order.service.impl;

import com.changgou.order.pojo.OrderConfig;
import com.changgou.order.dao.OrderConfigDao;
import com.changgou.order.service.OrderConfigService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (OrderConfig)表服务实现类
 *
 * @author makejava
 * @since 2022-03-19 14:09:57
 */
@Service("orderConfigService")
public class OrderConfigServiceImpl implements OrderConfigService {
    @Resource
    private OrderConfigDao orderConfigDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OrderConfig queryById(Integer id) {
        return this.orderConfigDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param orderConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<OrderConfig> queryByPage(OrderConfig orderConfig, PageRequest pageRequest) {
        long total = this.orderConfigDao.count(orderConfig);
        return new PageImpl<>(this.orderConfigDao.queryAllByLimit(orderConfig, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param orderConfig 实例对象
     * @return 实例对象
     */
    @Override
    public OrderConfig insert(OrderConfig orderConfig) {
        this.orderConfigDao.insert(orderConfig);
        return orderConfig;
    }

    /**
     * 修改数据
     *
     * @param orderConfig 实例对象
     * @return 实例对象
     */
    @Override
    public OrderConfig update(OrderConfig orderConfig) {
        this.orderConfigDao.update(orderConfig);
        return this.queryById(orderConfig.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.orderConfigDao.deleteById(id) > 0;
    }
}
