package com.changgou.order.service;

import com.changgou.order.pojo.Preferential;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Preferential)表服务接口
 *
 * @author makejava
 * @since 2022-03-19 14:10:03
 */
public interface PreferentialService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Preferential queryById(Integer id);

    /**
     * 分页查询
     *
     * @param preferential 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Preferential> queryByPage(Preferential preferential, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param preferential 实例对象
     * @return 实例对象
     */
    Preferential insert(Preferential preferential);

    /**
     * 修改数据
     *
     * @param preferential 实例对象
     * @return 实例对象
     */
    Preferential update(Preferential preferential);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
