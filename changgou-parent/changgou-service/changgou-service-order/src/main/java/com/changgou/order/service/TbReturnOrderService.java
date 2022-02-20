package com.changgou.order.service;

import com.changgou.order.pojo.TbReturnOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TbReturnOrder)表服务接口
 *
 * @author makejava
 * @since 2022-02-14 23:09:13
 */
public interface TbReturnOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbReturnOrder queryById(Long id);

    /**
     * 分页查询
     *
     * @param tbReturnOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbReturnOrder> queryByPage(TbReturnOrder tbReturnOrder, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbReturnOrder 实例对象
     * @return 实例对象
     */
    TbReturnOrder insert(TbReturnOrder tbReturnOrder);

    /**
     * 修改数据
     *
     * @param tbReturnOrder 实例对象
     * @return 实例对象
     */
    TbReturnOrder update(TbReturnOrder tbReturnOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
