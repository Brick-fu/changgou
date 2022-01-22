package com.changgou.user.service.impl;

import com.changgou.user.entity.UndoLog;
import com.changgou.user.dao.UndoLogDao;
import com.changgou.user.service.UndoLogService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (UndoLog)表服务实现类
 *
 * @author makejava
 * @since 2021-12-28 23:44:06
 */
@Service("undoLogService")
public class UndoLogServiceImpl implements UndoLogService {
    @Resource
    private UndoLogDao undoLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UndoLog queryById(Long id) {
        return this.undoLogDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param undoLog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<UndoLog> queryByPage(UndoLog undoLog, PageRequest pageRequest) {
        long total = this.undoLogDao.count(undoLog);
        return new PageImpl<>(this.undoLogDao.queryAllByLimit(undoLog, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param undoLog 实例对象
     * @return 实例对象
     */
    @Override
    public UndoLog insert(UndoLog undoLog) {
        this.undoLogDao.insert(undoLog);
        return undoLog;
    }

    /**
     * 修改数据
     *
     * @param undoLog 实例对象
     * @return 实例对象
     */
    @Override
    public UndoLog update(UndoLog undoLog) {
        this.undoLogDao.update(undoLog);
        return this.queryById(undoLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.undoLogDao.deleteById(id) > 0;
    }
}
