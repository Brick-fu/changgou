package com.changgou.user.service.impl;

import com.changgou.user.entity.TbAreas;
import com.changgou.user.dao.TbAreasDao;
import com.changgou.user.service.TbAreasService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 行政区域县区信息表(TbAreas)表服务实现类
 *
 * @author makejava
 * @since 2021-12-28 23:44:05
 */
@Service("tbAreasService")
public class TbAreasServiceImpl implements TbAreasService {
    @Resource
    private TbAreasDao tbAreasDao;

    /**
     * 通过ID查询单条数据
     *
     * @param areaid 主键
     * @return 实例对象
     */
    @Override
    public TbAreas queryById(String areaid) {
        return this.tbAreasDao.queryById(areaid);
    }

    /**
     * 分页查询
     *
     * @param tbAreas 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbAreas> queryByPage(TbAreas tbAreas, PageRequest pageRequest) {
        long total = this.tbAreasDao.count(tbAreas);
        return new PageImpl<>(this.tbAreasDao.queryAllByLimit(tbAreas, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbAreas 实例对象
     * @return 实例对象
     */
    @Override
    public TbAreas insert(TbAreas tbAreas) {
        this.tbAreasDao.insert(tbAreas);
        return tbAreas;
    }

    /**
     * 修改数据
     *
     * @param tbAreas 实例对象
     * @return 实例对象
     */
    @Override
    public TbAreas update(TbAreas tbAreas) {
        this.tbAreasDao.update(tbAreas);
        return this.queryById(tbAreas.getAreaid());
    }

    /**
     * 通过主键删除数据
     *
     * @param areaid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String areaid) {
        return this.tbAreasDao.deleteById(areaid) > 0;
    }
}
