package com.changgou.user.service;

import com.changgou.user.pojo.TbAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TbAddress)表服务接口
 *
 * @author makejava
 * @since 2021-12-28 23:43:30
 */
public interface TbAddressService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbAddress queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tbAddress 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbAddress> queryByPage(TbAddress tbAddress, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbAddress 实例对象
     * @return 实例对象
     */
    TbAddress insert(TbAddress tbAddress);

    /**
     * 修改数据
     *
     * @param tbAddress 实例对象
     * @return 实例对象
     */
    TbAddress update(TbAddress tbAddress);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
