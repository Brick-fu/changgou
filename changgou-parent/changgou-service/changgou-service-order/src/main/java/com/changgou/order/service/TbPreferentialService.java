package com.changgou.order.service;

import com.changgou.order.pojo.TbPreferential;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TbPreferential)表服务接口
 *
 * @author makejava
 * @since 2022-02-14 23:09:12
 */
public interface TbPreferentialService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbPreferential queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tbPreferential 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbPreferential> queryByPage(TbPreferential tbPreferential, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbPreferential 实例对象
     * @return 实例对象
     */
    TbPreferential insert(TbPreferential tbPreferential);

    /**
     * 修改数据
     *
     * @param tbPreferential 实例对象
     * @return 实例对象
     */
    TbPreferential update(TbPreferential tbPreferential);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
