package com.changgou.order.service.impl;

import com.changgou.order.pojo.Preferential;
import com.changgou.order.dao.PreferentialDao;
import com.changgou.order.service.PreferentialService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Preferential)表服务实现类
 *
 * @author makejava
 * @since 2022-03-19 14:10:03
 */
@Service("preferentialService")
public class PreferentialServiceImpl implements PreferentialService {
    @Resource
    private PreferentialDao preferentialDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Preferential queryById(Integer id) {
        return this.preferentialDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param preferential 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Preferential> queryByPage(Preferential preferential, PageRequest pageRequest) {
        long total = this.preferentialDao.count(preferential);
        return new PageImpl<>(this.preferentialDao.queryAllByLimit(preferential, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param preferential 实例对象
     * @return 实例对象
     */
    @Override
    public Preferential insert(Preferential preferential) {
        this.preferentialDao.insert(preferential);
        return preferential;
    }

    /**
     * 修改数据
     *
     * @param preferential 实例对象
     * @return 实例对象
     */
    @Override
    public Preferential update(Preferential preferential) {
        this.preferentialDao.update(preferential);
        return this.queryById(preferential.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.preferentialDao.deleteById(id) > 0;
    }
}
