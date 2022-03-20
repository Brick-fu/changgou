package com.changgou.user.service.impl;

import com.changgou.user.pojo.Cities;
import com.changgou.user.dao.CitiesDao;
import com.changgou.user.service.CitiesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 行政区域地州市信息表(Cities)表服务实现类
 *
 * @author makejava
 * @since 2022-03-19 14:44:51
 */
@Service("citiesService")
public class CitiesServiceImpl implements CitiesService {
    @Resource
    private CitiesDao citiesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cityid 主键
     * @return 实例对象
     */
    @Override
    public Cities queryById(String cityid) {
        return this.citiesDao.queryById(cityid);
    }

    /**
     * 分页查询
     *
     * @param cities 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Cities> queryByPage(Cities cities, PageRequest pageRequest) {
        long total = this.citiesDao.count(cities);
        return new PageImpl<>(this.citiesDao.queryAllByLimit(cities, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param cities 实例对象
     * @return 实例对象
     */
    @Override
    public Cities insert(Cities cities) {
        this.citiesDao.insert(cities);
        return cities;
    }

    /**
     * 修改数据
     *
     * @param cities 实例对象
     * @return 实例对象
     */
    @Override
    public Cities update(Cities cities) {
        this.citiesDao.update(cities);
        return this.queryById(cities.getCityid());
    }

    /**
     * 通过主键删除数据
     *
     * @param cityid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String cityid) {
        return this.citiesDao.deleteById(cityid) > 0;
    }
}
