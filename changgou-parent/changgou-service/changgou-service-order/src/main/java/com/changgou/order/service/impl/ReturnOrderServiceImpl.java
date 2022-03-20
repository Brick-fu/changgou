package com.changgou.order.service.impl;

import com.changgou.order.pojo.ReturnOrder;
import com.changgou.order.dao.ReturnOrderDao;
import com.changgou.order.service.ReturnOrderService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (ReturnOrder)表服务实现类
 *
 * @author makejava
 * @since 2022-03-19 14:10:06
 */
@Service("returnOrderService")
public class ReturnOrderServiceImpl implements ReturnOrderService {
    @Resource
    private ReturnOrderDao returnOrderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ReturnOrder queryById(Long id) {
        return this.returnOrderDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param returnOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<ReturnOrder> queryByPage(ReturnOrder returnOrder, PageRequest pageRequest) {
        long total = this.returnOrderDao.count(returnOrder);
        return new PageImpl<>(this.returnOrderDao.queryAllByLimit(returnOrder, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param returnOrder 实例对象
     * @return 实例对象
     */
    @Override
    public ReturnOrder insert(ReturnOrder returnOrder) {
        this.returnOrderDao.insert(returnOrder);
        return returnOrder;
    }

    /**
     * 修改数据
     *
     * @param returnOrder 实例对象
     * @return 实例对象
     */
    @Override
    public ReturnOrder update(ReturnOrder returnOrder) {
        this.returnOrderDao.update(returnOrder);
        return this.queryById(returnOrder.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.returnOrderDao.deleteById(id) > 0;
    }
}
