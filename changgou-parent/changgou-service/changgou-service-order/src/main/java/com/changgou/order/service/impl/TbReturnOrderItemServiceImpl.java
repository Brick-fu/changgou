package com.changgou.order.service.impl;

import com.changgou.order.pojo.TbReturnOrderItem;
import com.changgou.order.dao.TbReturnOrderItemDao;
import com.changgou.order.service.TbReturnOrderItemService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TbReturnOrderItem)表服务实现类
 *
 * @author makejava
 * @since 2022-02-14 23:09:13
 */
@Service("tbReturnOrderItemService")
public class TbReturnOrderItemServiceImpl implements TbReturnOrderItemService {
    @Resource
    private TbReturnOrderItemDao tbReturnOrderItemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbReturnOrderItem queryById(Long id) {
        return this.tbReturnOrderItemDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbReturnOrderItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbReturnOrderItem> queryByPage(TbReturnOrderItem tbReturnOrderItem, PageRequest pageRequest) {
        long total = this.tbReturnOrderItemDao.count(tbReturnOrderItem);
        return new PageImpl<>(this.tbReturnOrderItemDao.queryAllByLimit(tbReturnOrderItem, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbReturnOrderItem 实例对象
     * @return 实例对象
     */
    @Override
    public TbReturnOrderItem insert(TbReturnOrderItem tbReturnOrderItem) {
        this.tbReturnOrderItemDao.insert(tbReturnOrderItem);
        return tbReturnOrderItem;
    }

    /**
     * 修改数据
     *
     * @param tbReturnOrderItem 实例对象
     * @return 实例对象
     */
    @Override
    public TbReturnOrderItem update(TbReturnOrderItem tbReturnOrderItem) {
        this.tbReturnOrderItemDao.update(tbReturnOrderItem);
        return this.queryById(tbReturnOrderItem.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbReturnOrderItemDao.deleteById(id) > 0;
    }
}
