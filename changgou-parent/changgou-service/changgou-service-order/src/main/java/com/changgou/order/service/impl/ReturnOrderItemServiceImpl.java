package com.changgou.order.service.impl;

import com.changgou.order.pojo.ReturnOrderItem;
import com.changgou.order.dao.ReturnOrderItemDao;
import com.changgou.order.service.ReturnOrderItemService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (ReturnOrderItem)表服务实现类
 *
 * @author makejava
 * @since 2022-03-19 14:10:08
 */
@Service("returnOrderItemService")
public class ReturnOrderItemServiceImpl implements ReturnOrderItemService {
    @Resource
    private ReturnOrderItemDao returnOrderItemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ReturnOrderItem queryById(Long id) {
        return this.returnOrderItemDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param returnOrderItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<ReturnOrderItem> queryByPage(ReturnOrderItem returnOrderItem, PageRequest pageRequest) {
        long total = this.returnOrderItemDao.count(returnOrderItem);
        return new PageImpl<>(this.returnOrderItemDao.queryAllByLimit(returnOrderItem, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param returnOrderItem 实例对象
     * @return 实例对象
     */
    @Override
    public ReturnOrderItem insert(ReturnOrderItem returnOrderItem) {
        this.returnOrderItemDao.insert(returnOrderItem);
        return returnOrderItem;
    }

    /**
     * 修改数据
     *
     * @param returnOrderItem 实例对象
     * @return 实例对象
     */
    @Override
    public ReturnOrderItem update(ReturnOrderItem returnOrderItem) {
        this.returnOrderItemDao.update(returnOrderItem);
        return this.queryById(returnOrderItem.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.returnOrderItemDao.deleteById(id) > 0;
    }
}
