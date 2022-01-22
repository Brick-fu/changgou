package com.changgou.user.service.impl;

import com.changgou.user.entity.TbCities;
import com.changgou.user.dao.TbCitiesDao;
import com.changgou.user.service.TbCitiesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 行政区域地州市信息表(TbCities)表服务实现类
 *
 * @author makejava
 * @since 2021-12-28 23:44:05
 */
@Service("tbCitiesService")
public class TbCitiesServiceImpl implements TbCitiesService {
    @Resource
    private TbCitiesDao tbCitiesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cityid 主键
     * @return 实例对象
     */
    @Override
    public TbCities queryById(String cityid) {
        return this.tbCitiesDao.queryById(cityid);
    }

    /**
     * 分页查询
     *
     * @param tbCities 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbCities> queryByPage(TbCities tbCities, PageRequest pageRequest) {
        long total = this.tbCitiesDao.count(tbCities);
        return new PageImpl<>(this.tbCitiesDao.queryAllByLimit(tbCities, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbCities 实例对象
     * @return 实例对象
     */
    @Override
    public TbCities insert(TbCities tbCities) {
        this.tbCitiesDao.insert(tbCities);
        return tbCities;
    }

    /**
     * 修改数据
     *
     * @param tbCities 实例对象
     * @return 实例对象
     */
    @Override
    public TbCities update(TbCities tbCities) {
        this.tbCitiesDao.update(tbCities);
        return this.queryById(tbCities.getCityid());
    }

    /**
     * 通过主键删除数据
     *
     * @param cityid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String cityid) {
        return this.tbCitiesDao.deleteById(cityid) > 0;
    }
}
