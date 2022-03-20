package com.changgou.user.service.impl;

import com.changgou.user.pojo.User;
import com.changgou.user.dao.UserDao;
import com.changgou.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 用户表(TbUser)表服务实现类
 *
 * @author makejava
 * @since 2021-12-28 23:44:05
 */
@Service("tbUserService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public int addUserPoints(String username, Integer point) {
        logger.info("TbUserServiceImpl.addUserPoints,{}",point);
        return userDao.addUserPoints(username,point);
    }

    /**
     * 通过ID查询单条数据
     * @param username 主键
     * @return 实例对象
     */
    @Override
    public User queryById(String username) {
        return this.userDao.queryById(username);
    }

    /**
     * 分页查询
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
        long total = this.userDao.count(user);
        return new PageImpl<>(this.userDao.queryAllByLimit(user, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getUsername());
    }

    /**
     * 通过主键删除数据
     * @param username 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String username) {
        return this.userDao.deleteById(username) > 0;
    }
}
