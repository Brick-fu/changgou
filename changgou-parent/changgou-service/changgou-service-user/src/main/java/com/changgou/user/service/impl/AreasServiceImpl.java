package com.changgou.user.service.impl;

import com.changgou.user.pojo.Areas;
import com.changgou.user.dao.AreasDao;
import com.changgou.user.service.AreasService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 行政区域县区信息表(Areas)表服务实现类
 *
 * @author makejava
 * @since 2022-03-19 14:44:50
 */
@Service("areasService")
public class AreasServiceImpl implements AreasService {
    @Resource
    private AreasDao areasDao;

    /**
     * 通过ID查询单条数据
     *
     * @param areaid 主键
     * @return 实例对象
     */
    @Override
    public Areas queryById(String areaid) {
        return this.areasDao.queryById(areaid);
    }

    /**
     * 分页查询
     *
     * @param areas 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Areas> queryByPage(Areas areas, PageRequest pageRequest) {
        long total = this.areasDao.count(areas);
        return new PageImpl<>(this.areasDao.queryAllByLimit(areas, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param areas 实例对象
     * @return 实例对象
     */
    @Override
    public Areas insert(Areas areas) {
        this.areasDao.insert(areas);
        return areas;
    }

    /**
     * 修改数据
     *
     * @param areas 实例对象
     * @return 实例对象
     */
    @Override
    public Areas update(Areas areas) {
        this.areasDao.update(areas);
        return this.queryById(areas.getAreaid());
    }

    /**
     * 通过主键删除数据
     *
     * @param areaid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String areaid) {
        return this.areasDao.deleteById(areaid) > 0;
    }
}
