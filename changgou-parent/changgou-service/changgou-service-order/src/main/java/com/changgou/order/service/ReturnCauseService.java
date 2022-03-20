package com.changgou.order.service;

import com.changgou.order.pojo.ReturnCause;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (ReturnCause)表服务接口
 *
 * @author makejava
 * @since 2022-03-19 14:10:05
 */
public interface ReturnCauseService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ReturnCause queryById(Integer id);

    /**
     * 分页查询
     *
     * @param returnCause 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<ReturnCause> queryByPage(ReturnCause returnCause, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param returnCause 实例对象
     * @return 实例对象
     */
    ReturnCause insert(ReturnCause returnCause);

    /**
     * 修改数据
     *
     * @param returnCause 实例对象
     * @return 实例对象
     */
    ReturnCause update(ReturnCause returnCause);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
