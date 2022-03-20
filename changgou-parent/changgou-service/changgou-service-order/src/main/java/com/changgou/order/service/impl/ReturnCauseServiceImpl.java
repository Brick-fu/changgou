package com.changgou.order.service.impl;

import com.changgou.order.pojo.ReturnCause;
import com.changgou.order.dao.ReturnCauseDao;
import com.changgou.order.service.ReturnCauseService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (ReturnCause)表服务实现类
 *
 * @author makejava
 * @since 2022-03-19 14:10:05
 */
@Service("returnCauseService")
public class ReturnCauseServiceImpl implements ReturnCauseService {
    @Resource
    private ReturnCauseDao returnCauseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ReturnCause queryById(Integer id) {
        return this.returnCauseDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param returnCause 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<ReturnCause> queryByPage(ReturnCause returnCause, PageRequest pageRequest) {
        long total = this.returnCauseDao.count(returnCause);
        return new PageImpl<>(this.returnCauseDao.queryAllByLimit(returnCause, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param returnCause 实例对象
     * @return 实例对象
     */
    @Override
    public ReturnCause insert(ReturnCause returnCause) {
        this.returnCauseDao.insert(returnCause);
        return returnCause;
    }

    /**
     * 修改数据
     *
     * @param returnCause 实例对象
     * @return 实例对象
     */
    @Override
    public ReturnCause update(ReturnCause returnCause) {
        this.returnCauseDao.update(returnCause);
        return this.queryById(returnCause.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.returnCauseDao.deleteById(id) > 0;
    }
}
