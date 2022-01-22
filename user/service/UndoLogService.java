package com.changgou.user.service;

import com.changgou.user.entity.UndoLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (UndoLog)表服务接口
 *
 * @author makejava
 * @since 2021-12-28 23:44:06
 */
public interface UndoLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UndoLog queryById(Long id);

    /**
     * 分页查询
     *
     * @param undoLog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<UndoLog> queryByPage(UndoLog undoLog, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param undoLog 实例对象
     * @return 实例对象
     */
    UndoLog insert(UndoLog undoLog);

    /**
     * 修改数据
     *
     * @param undoLog 实例对象
     * @return 实例对象
     */
    UndoLog update(UndoLog undoLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
