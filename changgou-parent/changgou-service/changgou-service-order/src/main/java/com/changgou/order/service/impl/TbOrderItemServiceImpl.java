package com.changgou.order.service.impl;

import com.changgou.order.pojo.TbOrderItem;
import com.changgou.order.dao.TbOrderItemDao;
import com.changgou.order.service.TbOrderItemService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TbOrderItem)表服务实现类
 *
 * @author makejava
 * @since 2022-02-14 23:09:12
 */
@Service("tbOrderItemService")
public class TbOrderItemServiceImpl implements TbOrderItemService {
    @Resource
    private TbOrderItemDao tbOrderItemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbOrderItem queryById(String id) {
        return this.tbOrderItemDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbOrderItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbOrderItem> queryByPage(TbOrderItem tbOrderItem, PageRequest pageRequest) {
        long total = this.tbOrderItemDao.count(tbOrderItem);
        return new PageImpl<>(this.tbOrderItemDao.queryAllByLimit(tbOrderItem, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbOrderItem 实例对象
     * @return 实例对象
     */
    @Override
    public TbOrderItem insert(TbOrderItem tbOrderItem) {
        this.tbOrderItemDao.insert(tbOrderItem);
        return tbOrderItem;
    }

    /**
     * 修改数据
     *
     * @param tbOrderItem 实例对象
     * @return 实例对象
     */
    @Override
    public TbOrderItem update(TbOrderItem tbOrderItem) {
        this.tbOrderItemDao.update(tbOrderItem);
        return this.queryById(tbOrderItem.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.tbOrderItemDao.deleteById(id) > 0;
    }
}
