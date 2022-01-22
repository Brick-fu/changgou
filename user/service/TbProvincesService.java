package com.changgou.user.service;

import com.changgou.user.entity.TbProvinces;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 省份信息表(TbProvinces)表服务接口
 *
 * @author makejava
 * @since 2021-12-28 23:44:05
 */
public interface TbProvincesService {

    /**
     * 通过ID查询单条数据
     *
     * @param provinceid 主键
     * @return 实例对象
     */
    TbProvinces queryById(String provinceid);

    /**
     * 分页查询
     *
     * @param tbProvinces 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbProvinces> queryByPage(TbProvinces tbProvinces, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbProvinces 实例对象
     * @return 实例对象
     */
    TbProvinces insert(TbProvinces tbProvinces);

    /**
     * 修改数据
     *
     * @param tbProvinces 实例对象
     * @return 实例对象
     */
    TbProvinces update(TbProvinces tbProvinces);

    /**
     * 通过主键删除数据
     *
     * @param provinceid 主键
     * @return 是否成功
     */
    boolean deleteById(String provinceid);

}
