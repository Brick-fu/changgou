package com.changgou.order.service;

import com.changgou.order.pojo.TbOrderLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TbOrderLog)表服务接口
 *
 * @author makejava
 * @since 2022-02-14 23:09:12
 */
public interface TbOrderLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbOrderLog queryById(String id);

    /**
     * 分页查询
     *
     * @param tbOrderLog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbOrderLog> queryByPage(TbOrderLog tbOrderLog, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbOrderLog 实例对象
     * @return 实例对象
     */
    TbOrderLog insert(TbOrderLog tbOrderLog);

    /**
     * 修改数据
     *
     * @param tbOrderLog 实例对象
     * @return 实例对象
     */
    TbOrderLog update(TbOrderLog tbOrderLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
