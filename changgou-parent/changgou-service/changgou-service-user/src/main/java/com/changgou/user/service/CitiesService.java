package com.changgou.user.service;

import com.changgou.user.pojo.Cities;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 行政区域地州市信息表(Cities)表服务接口
 *
 * @author makejava
 * @since 2022-03-19 14:44:51
 */
public interface CitiesService {

    /**
     * 通过ID查询单条数据
     *
     * @param cityid 主键
     * @return 实例对象
     */
    Cities queryById(String cityid);

    /**
     * 分页查询
     *
     * @param cities 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Cities> queryByPage(Cities cities, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param cities 实例对象
     * @return 实例对象
     */
    Cities insert(Cities cities);

    /**
     * 修改数据
     *
     * @param cities 实例对象
     * @return 实例对象
     */
    Cities update(Cities cities);

    /**
     * 通过主键删除数据
     *
     * @param cityid 主键
     * @return 是否成功
     */
    boolean deleteById(String cityid);

}
