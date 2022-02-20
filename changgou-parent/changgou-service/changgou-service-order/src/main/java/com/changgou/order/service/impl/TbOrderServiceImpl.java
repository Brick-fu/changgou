package com.changgou.order.service.impl;

import com.changgou.order.pojo.TbOrder;
import com.changgou.order.dao.TbOrderDao;
import com.changgou.order.service.TbOrderService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TbOrder)表服务实现类
 *
 * @author makejava
 * @since 2022-02-14 23:09:12
 */
@Service("tbOrderService")
public class TbOrderServiceImpl implements TbOrderService {
    @Resource
    private TbOrderDao tbOrderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbOrder queryById(String id) {
        return this.tbOrderDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbOrder> queryByPage(TbOrder tbOrder, PageRequest pageRequest) {
        long total = this.tbOrderDao.count(tbOrder);
        return new PageImpl<>(this.tbOrderDao.queryAllByLimit(tbOrder, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbOrder 实例对象
     * @return 实例对象
     */
    @Override
    public TbOrder insert(TbOrder tbOrder) {
        this.tbOrderDao.insert(tbOrder);
        return tbOrder;
    }

    /**
     * 修改数据
     *
     * @param tbOrder 实例对象
     * @return 实例对象
     */
    @Override
    public TbOrder update(TbOrder tbOrder) {
        this.tbOrderDao.update(tbOrder);
        return this.queryById(tbOrder.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.tbOrderDao.deleteById(id) > 0;
    }
}
