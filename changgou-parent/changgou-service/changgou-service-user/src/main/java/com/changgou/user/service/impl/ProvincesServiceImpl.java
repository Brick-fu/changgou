package com.changgou.user.service.impl;

import com.changgou.user.pojo.Provinces;
import com.changgou.user.dao.ProvincesDao;
import com.changgou.user.service.ProvincesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 省份信息表(Provinces)表服务实现类
 *
 * @author makejava
 * @since 2022-03-19 14:44:51
 */
@Service("provincesService")
public class ProvincesServiceImpl implements ProvincesService {
    @Resource
    private ProvincesDao provincesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param provinceid 主键
     * @return 实例对象
     */
    @Override
    public Provinces queryById(String provinceid) {
        return this.provincesDao.queryById(provinceid);
    }

    /**
     * 分页查询
     *
     * @param provinces 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Provinces> queryByPage(Provinces provinces, PageRequest pageRequest) {
        long total = this.provincesDao.count(provinces);
        return new PageImpl<>(this.provincesDao.queryAllByLimit(provinces, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param provinces 实例对象
     * @return 实例对象
     */
    @Override
    public Provinces insert(Provinces provinces) {
        this.provincesDao.insert(provinces);
        return provinces;
    }

    /**
     * 修改数据
     *
     * @param provinces 实例对象
     * @return 实例对象
     */
    @Override
    public Provinces update(Provinces provinces) {
        this.provincesDao.update(provinces);
        return this.queryById(provinces.getProvinceid());
    }

    /**
     * 通过主键删除数据
     *
     * @param provinceid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String provinceid) {
        return this.provincesDao.deleteById(provinceid) > 0;
    }
}
