package com.changgou.order.service;

import com.changgou.order.pojo.TbReturnCause;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TbReturnCause)表服务接口
 *
 * @author makejava
 * @since 2022-02-14 23:09:13
 */
public interface TbReturnCauseService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbReturnCause queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tbReturnCause 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbReturnCause> queryByPage(TbReturnCause tbReturnCause, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbReturnCause 实例对象
     * @return 实例对象
     */
    TbReturnCause insert(TbReturnCause tbReturnCause);

    /**
     * 修改数据
     *
     * @param tbReturnCause 实例对象
     * @return 实例对象
     */
    TbReturnCause update(TbReturnCause tbReturnCause);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
