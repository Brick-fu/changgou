package com.changgou.user.service;

import com.changgou.user.pojo.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (TbAddress)表服务接口
 *
 * @author makejava
 * @since 2021-12-28 23:43:30
 */
public interface AddressService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Address queryById(Integer id);

    /**
     * 分页查询
     *
     * @param address 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Address> queryByPage(Address address, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    Address insert(Address address);

    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    Address update(Address address);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /*
     * @Desc 通过用户登录名获取地址
     * @Date 下午6:12 2022/2/20
     * @Author brick
     **/
    List<Address> getUserAddress(String username);

}