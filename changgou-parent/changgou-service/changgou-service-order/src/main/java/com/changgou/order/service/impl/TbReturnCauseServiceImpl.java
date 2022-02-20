package com.changgou.order.service.impl;

import com.changgou.order.pojo.TbReturnCause;
import com.changgou.order.dao.TbReturnCauseDao;
import com.changgou.order.service.TbReturnCauseService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TbReturnCause)表服务实现类
 *
 * @author makejava
 * @since 2022-02-14 23:09:13
 */
@Service("tbReturnCauseService")
public class TbReturnCauseServiceImpl implements TbReturnCauseService {
    @Resource
    private TbReturnCauseDao tbReturnCauseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbReturnCause queryById(Integer id) {
        return this.tbReturnCauseDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbReturnCause 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbReturnCause> queryByPage(TbReturnCause tbReturnCause, PageRequest pageRequest) {
        long total = this.tbReturnCauseDao.count(tbReturnCause);
        return new PageImpl<>(this.tbReturnCauseDao.queryAllByLimit(tbReturnCause, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbReturnCause 实例对象
     * @return 实例对象
     */
    @Override
    public TbReturnCause insert(TbReturnCause tbReturnCause) {
        this.tbReturnCauseDao.insert(tbReturnCause);
        return tbReturnCause;
    }

    /**
     * 修改数据
     *
     * @param tbReturnCause 实例对象
     * @return 实例对象
     */
    @Override
    public TbReturnCause update(TbReturnCause tbReturnCause) {
        this.tbReturnCauseDao.update(tbReturnCause);
        return this.queryById(tbReturnCause.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbReturnCauseDao.deleteById(id) > 0;
    }
}
