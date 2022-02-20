package com.changgou.order.service.impl;

import com.changgou.order.pojo.TbPreferential;
import com.changgou.order.dao.TbPreferentialDao;
import com.changgou.order.service.TbPreferentialService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TbPreferential)表服务实现类
 *
 * @author makejava
 * @since 2022-02-14 23:09:12
 */
@Service("tbPreferentialService")
public class TbPreferentialServiceImpl implements TbPreferentialService {
    @Resource
    private TbPreferentialDao tbPreferentialDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbPreferential queryById(Integer id) {
        return this.tbPreferentialDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbPreferential 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbPreferential> queryByPage(TbPreferential tbPreferential, PageRequest pageRequest) {
        long total = this.tbPreferentialDao.count(tbPreferential);
        return new PageImpl<>(this.tbPreferentialDao.queryAllByLimit(tbPreferential, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbPreferential 实例对象
     * @return 实例对象
     */
    @Override
    public TbPreferential insert(TbPreferential tbPreferential) {
        this.tbPreferentialDao.insert(tbPreferential);
        return tbPreferential;
    }

    /**
     * 修改数据
     *
     * @param tbPreferential 实例对象
     * @return 实例对象
     */
    @Override
    public TbPreferential update(TbPreferential tbPreferential) {
        this.tbPreferentialDao.update(tbPreferential);
        return this.queryById(tbPreferential.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbPreferentialDao.deleteById(id) > 0;
    }
}
