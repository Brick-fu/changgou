package com.changgou.order.service;

import com.changgou.order.pojo.TbReturnOrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TbReturnOrderItem)表服务接口
 *
 * @author makejava
 * @since 2022-02-14 23:09:13
 */
public interface TbReturnOrderItemService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbReturnOrderItem queryById(Long id);

    /**
     * 分页查询
     *
     * @param tbReturnOrderItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbReturnOrderItem> queryByPage(TbReturnOrderItem tbReturnOrderItem, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbReturnOrderItem 实例对象
     * @return 实例对象
     */
    TbReturnOrderItem insert(TbReturnOrderItem tbReturnOrderItem);

    /**
     * 修改数据
     *
     * @param tbReturnOrderItem 实例对象
     * @return 实例对象
     */
    TbReturnOrderItem update(TbReturnOrderItem tbReturnOrderItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
