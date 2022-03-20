package com.changgou.user.service;

import com.changgou.user.pojo.Provinces;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 省份信息表(Provinces)表服务接口
 *
 * @author makejava
 * @since 2022-03-19 14:44:51
 */
public interface ProvincesService {

    /**
     * 通过ID查询单条数据
     *
     * @param provinceid 主键
     * @return 实例对象
     */
    Provinces queryById(String provinceid);

    /**
     * 分页查询
     *
     * @param provinces 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Provinces> queryByPage(Provinces provinces, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param provinces 实例对象
     * @return 实例对象
     */
    Provinces insert(Provinces provinces);

    /**
     * 修改数据
     *
     * @param provinces 实例对象
     * @return 实例对象
     */
    Provinces update(Provinces provinces);

    /**
     * 通过主键删除数据
     *
     * @param provinceid 主键
     * @return 是否成功
     */
    boolean deleteById(String provinceid);

}
