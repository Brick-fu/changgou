package com.changgou.order.dao;

import com.changgou.order.pojo.TbReturnCause;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TbReturnCause)表数据库访问层
 *
 * @author makejava
 * @since 2022-02-14 23:09:13
 */
public interface TbReturnCauseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbReturnCause queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param tbReturnCause 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TbReturnCause> queryAllByLimit(TbReturnCause tbReturnCause, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tbReturnCause 查询条件
     * @return 总行数
     */
    long count(TbReturnCause tbReturnCause);

    /**
     * 新增数据
     *
     * @param tbReturnCause 实例对象
     * @return 影响行数
     */
    int insert(TbReturnCause tbReturnCause);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbReturnCause> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbReturnCause> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbReturnCause> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbReturnCause> entities);

    /**
     * 修改数据
     *
     * @param tbReturnCause 实例对象
     * @return 影响行数
     */
    int update(TbReturnCause tbReturnCause);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

