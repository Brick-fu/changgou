package com.changgou.order.service.impl;

import com.changgou.order.pojo.OrderLog;
import com.changgou.order.dao.OrderLogDao;
import com.changgou.order.service.OrderLogService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (OrderLog)表服务实现类
 *
 * @author makejava
 * @since 2022-03-19 14:10:02
 */
@Service("orderLogService")
public class OrderLogServiceImpl implements OrderLogService {
    @Resource
    private OrderLogDao orderLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OrderLog queryById(String id) {
        return this.orderLogDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param orderLog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<OrderLog> queryByPage(OrderLog orderLog, PageRequest pageRequest) {
        long total = this.orderLogDao.count(orderLog);
        return new PageImpl<>(this.orderLogDao.queryAllByLimit(orderLog, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param orderLog 实例对象
     * @return 实例对象
     */
    @Override
    public OrderLog insert(OrderLog orderLog) {
        this.orderLogDao.insert(orderLog);
        return orderLog;
    }

    /**
     * 修改数据
     *
     * @param orderLog 实例对象
     * @return 实例对象
     */
    @Override
    public OrderLog update(OrderLog orderLog) {
        this.orderLogDao.update(orderLog);
        return this.queryById(orderLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.orderLogDao.deleteById(id) > 0;
    }
}
