package com.changgou.order.service.impl;

import com.changgou.order.pojo.TbOrderConfig;
import com.changgou.order.dao.TbOrderConfigDao;
import com.changgou.order.service.TbOrderConfigService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TbOrderConfig)表服务实现类
 *
 * @author makejava
 * @since 2022-02-14 23:09:12
 */
@Service("tbOrderConfigService")
public class TbOrderConfigServiceImpl implements TbOrderConfigService {
    @Resource
    private TbOrderConfigDao tbOrderConfigDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbOrderConfig queryById(Integer id) {
        return this.tbOrderConfigDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbOrderConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbOrderConfig> queryByPage(TbOrderConfig tbOrderConfig, PageRequest pageRequest) {
        long total = this.tbOrderConfigDao.count(tbOrderConfig);
        return new PageImpl<>(this.tbOrderConfigDao.queryAllByLimit(tbOrderConfig, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbOrderConfig 实例对象
     * @return 实例对象
     */
    @Override
    public TbOrderConfig insert(TbOrderConfig tbOrderConfig) {
        this.tbOrderConfigDao.insert(tbOrderConfig);
        return tbOrderConfig;
    }

    /**
     * 修改数据
     *
     * @param tbOrderConfig 实例对象
     * @return 实例对象
     */
    @Override
    public TbOrderConfig update(TbOrderConfig tbOrderConfig) {
        this.tbOrderConfigDao.update(tbOrderConfig);
        return this.queryById(tbOrderConfig.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbOrderConfigDao.deleteById(id) > 0;
    }
}
