package com.changgou.user.service.impl;

import com.changgou.user.entity.TbProvinces;
import com.changgou.user.dao.TbProvincesDao;
import com.changgou.user.service.TbProvincesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 省份信息表(TbProvinces)表服务实现类
 *
 * @author makejava
 * @since 2021-12-28 23:44:05
 */
@Service("tbProvincesService")
public class TbProvincesServiceImpl implements TbProvincesService {
    @Resource
    private TbProvincesDao tbProvincesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param provinceid 主键
     * @return 实例对象
     */
    @Override
    public TbProvinces queryById(String provinceid) {
        return this.tbProvincesDao.queryById(provinceid);
    }

    /**
     * 分页查询
     *
     * @param tbProvinces 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbProvinces> queryByPage(TbProvinces tbProvinces, PageRequest pageRequest) {
        long total = this.tbProvincesDao.count(tbProvinces);
        return new PageImpl<>(this.tbProvincesDao.queryAllByLimit(tbProvinces, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbProvinces 实例对象
     * @return 实例对象
     */
    @Override
    public TbProvinces insert(TbProvinces tbProvinces) {
        this.tbProvincesDao.insert(tbProvinces);
        return tbProvinces;
    }

    /**
     * 修改数据
     *
     * @param tbProvinces 实例对象
     * @return 实例对象
     */
    @Override
    public TbProvinces update(TbProvinces tbProvinces) {
        this.tbProvincesDao.update(tbProvinces);
        return this.queryById(tbProvinces.getProvinceid());
    }

    /**
     * 通过主键删除数据
     *
     * @param provinceid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String provinceid) {
        return this.tbProvincesDao.deleteById(provinceid) > 0;
    }
}
