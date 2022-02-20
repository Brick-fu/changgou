package com.changgou.order.service.impl;

import com.changgou.order.pojo.TbOrderLog;
import com.changgou.order.dao.TbOrderLogDao;
import com.changgou.order.service.TbOrderLogService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TbOrderLog)表服务实现类
 *
 * @author makejava
 * @since 2022-02-14 23:09:12
 */
@Service("tbOrderLogService")
public class TbOrderLogServiceImpl implements TbOrderLogService {
    @Resource
    private TbOrderLogDao tbOrderLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbOrderLog queryById(String id) {
        return this.tbOrderLogDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbOrderLog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbOrderLog> queryByPage(TbOrderLog tbOrderLog, PageRequest pageRequest) {
        long total = this.tbOrderLogDao.count(tbOrderLog);
        return new PageImpl<>(this.tbOrderLogDao.queryAllByLimit(tbOrderLog, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbOrderLog 实例对象
     * @return 实例对象
     */
    @Override
    public TbOrderLog insert(TbOrderLog tbOrderLog) {
        this.tbOrderLogDao.insert(tbOrderLog);
        return tbOrderLog;
    }

    /**
     * 修改数据
     *
     * @param tbOrderLog 实例对象
     * @return 实例对象
     */
    @Override
    public TbOrderLog update(TbOrderLog tbOrderLog) {
        this.tbOrderLogDao.update(tbOrderLog);
        return this.queryById(tbOrderLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.tbOrderLogDao.deleteById(id) > 0;
    }
}
