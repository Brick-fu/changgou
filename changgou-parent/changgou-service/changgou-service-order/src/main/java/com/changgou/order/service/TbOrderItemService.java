package com.changgou.order.service;

import com.changgou.order.pojo.TbOrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TbOrderItem)表服务接口
 *
 * @author makejava
 * @since 2022-02-14 23:09:12
 */
public interface TbOrderItemService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbOrderItem queryById(String id);

    /**
     * 分页查询
     *
     * @param tbOrderItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbOrderItem> queryByPage(TbOrderItem tbOrderItem, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbOrderItem 实例对象
     * @return 实例对象
     */
    TbOrderItem insert(TbOrderItem tbOrderItem);

    /**
     * 修改数据
     *
     * @param tbOrderItem 实例对象
     * @return 实例对象
     */
    TbOrderItem update(TbOrderItem tbOrderItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
