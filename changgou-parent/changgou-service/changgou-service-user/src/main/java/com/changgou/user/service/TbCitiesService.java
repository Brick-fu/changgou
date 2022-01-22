package com.changgou.user.service;

import com.changgou.user.pojo.TbCities;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 行政区域地州市信息表(TbCities)表服务接口
 *
 * @author makejava
 * @since 2021-12-28 23:44:05
 */
public interface TbCitiesService {

    /**
     * 通过ID查询单条数据
     *
     * @param cityid 主键
     * @return 实例对象
     */
    TbCities queryById(String cityid);

    /**
     * 分页查询
     *
     * @param tbCities 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbCities> queryByPage(TbCities tbCities, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbCities 实例对象
     * @return 实例对象
     */
    TbCities insert(TbCities tbCities);

    /**
     * 修改数据
     *
     * @param tbCities 实例对象
     * @return 实例对象
     */
    TbCities update(TbCities tbCities);

    /**
     * 通过主键删除数据
     *
     * @param cityid 主键
     * @return 是否成功
     */
    boolean deleteById(String cityid);

}
