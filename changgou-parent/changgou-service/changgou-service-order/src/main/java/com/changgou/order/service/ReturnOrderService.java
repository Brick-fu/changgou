package com.changgou.order.service;

import com.changgou.order.pojo.ReturnOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (ReturnOrder)表服务接口
 *
 * @author makejava
 * @since 2022-03-19 14:10:06
 */
public interface ReturnOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ReturnOrder queryById(Long id);

    /**
     * 分页查询
     *
     * @param returnOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<ReturnOrder> queryByPage(ReturnOrder returnOrder, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param returnOrder 实例对象
     * @return 实例对象
     */
    ReturnOrder insert(ReturnOrder returnOrder);

    /**
     * 修改数据
     *
     * @param returnOrder 实例对象
     * @return 实例对象
     */
    ReturnOrder update(ReturnOrder returnOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
