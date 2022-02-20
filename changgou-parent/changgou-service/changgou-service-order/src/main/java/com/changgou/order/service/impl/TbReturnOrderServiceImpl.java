package com.changgou.order.service.impl;

import com.changgou.order.pojo.TbReturnOrder;
import com.changgou.order.dao.TbReturnOrderDao;
import com.changgou.order.service.TbReturnOrderService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TbReturnOrder)表服务实现类
 *
 * @author makejava
 * @since 2022-02-14 23:09:13
 */
@Service("tbReturnOrderService")
public class TbReturnOrderServiceImpl implements TbReturnOrderService {
    @Resource
    private TbReturnOrderDao tbReturnOrderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbReturnOrder queryById(Long id) {
        return this.tbReturnOrderDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbReturnOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbReturnOrder> queryByPage(TbReturnOrder tbReturnOrder, PageRequest pageRequest) {
        long total = this.tbReturnOrderDao.count(tbReturnOrder);
        return new PageImpl<>(this.tbReturnOrderDao.queryAllByLimit(tbReturnOrder, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbReturnOrder 实例对象
     * @return 实例对象
     */
    @Override
    public TbReturnOrder insert(TbReturnOrder tbReturnOrder) {
        this.tbReturnOrderDao.insert(tbReturnOrder);
        return tbReturnOrder;
    }

    /**
     * 修改数据
     *
     * @param tbReturnOrder 实例对象
     * @return 实例对象
     */
    @Override
    public TbReturnOrder update(TbReturnOrder tbReturnOrder) {
        this.tbReturnOrderDao.update(tbReturnOrder);
        return this.queryById(tbReturnOrder.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbReturnOrderDao.deleteById(id) > 0;
    }
}
