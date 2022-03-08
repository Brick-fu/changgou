package com.changgou.user.service;

import com.changgou.user.pojo.TbUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 用户表(TbUser)表服务接口
 *
 * @author makejava
 * @since 2021-12-28 23:44:05
 */
public interface TbUserService {

    /***
     * 添加用户积分
     * @param username
     * @param point
     * @return
     */
    int addUserPoints(String username,Integer point);

    /**
     * 通过ID查询单条数据
     *
     * @param username 主键
     * @return 实例对象
     */
    TbUser queryById(String username);

    /**
     * 分页查询
     *
     * @param tbUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbUser> queryByPage(TbUser tbUser, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    TbUser insert(TbUser tbUser);

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    TbUser update(TbUser tbUser);

    /**
     * 通过主键删除数据
     *
     * @param username 主键
     * @return 是否成功
     */
    boolean deleteById(String username);

}
