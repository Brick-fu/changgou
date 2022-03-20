package com.changgou.order.service;

import com.changgou.order.pojo.ReturnOrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (ReturnOrderItem)表服务接口
 *
 * @author makejava
 * @since 2022-03-19 14:10:08
 */
public interface ReturnOrderItemService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ReturnOrderItem queryById(Long id);

    /**
     * 分页查询
     *
     * @param returnOrderItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<ReturnOrderItem> queryByPage(ReturnOrderItem returnOrderItem, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param returnOrderItem 实例对象
     * @return 实例对象
     */
    ReturnOrderItem insert(ReturnOrderItem returnOrderItem);

    /**
     * 修改数据
     *
     * @param returnOrderItem 实例对象
     * @return 实例对象
     */
    ReturnOrderItem update(ReturnOrderItem returnOrderItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
