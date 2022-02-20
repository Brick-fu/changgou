package com.changgou.order.service;

import com.changgou.order.pojo.TbOrderConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TbOrderConfig)表服务接口
 *
 * @author makejava
 * @since 2022-02-14 23:09:12
 */
public interface TbOrderConfigService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbOrderConfig queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tbOrderConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbOrderConfig> queryByPage(TbOrderConfig tbOrderConfig, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbOrderConfig 实例对象
     * @return 实例对象
     */
    TbOrderConfig insert(TbOrderConfig tbOrderConfig);

    /**
     * 修改数据
     *
     * @param tbOrderConfig 实例对象
     * @return 实例对象
     */
    TbOrderConfig update(TbOrderConfig tbOrderConfig);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
