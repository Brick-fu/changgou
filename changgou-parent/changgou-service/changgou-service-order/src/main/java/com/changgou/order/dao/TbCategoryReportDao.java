package com.changgou.order.dao;

import com.changgou.order.pojo.TbCategoryReport;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (TbCategoryReport)表数据库访问层
 *
 * @author makejava
 * @since 2022-02-14 23:09:04
 */
public interface TbCategoryReportDao {

    /**
     * 通过ID查询单条数据
     *
     * @param categoryId1 主键
     * @return 实例对象
     */
    TbCategoryReport queryById(Integer categoryId1);

    /**
     * 查询指定行数据
     *
     * @param tbCategoryReport 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TbCategoryReport> queryAllByLimit(TbCategoryReport tbCategoryReport, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tbCategoryReport 查询条件
     * @return 总行数
     */
    long count(TbCategoryReport tbCategoryReport);

    /**
     * 新增数据
     *
     * @param tbCategoryReport 实例对象
     * @return 影响行数
     */
    int insert(TbCategoryReport tbCategoryReport);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbCategoryReport> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbCategoryReport> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbCategoryReport> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbCategoryReport> entities);

    /**
     * 修改数据
     *
     * @param tbCategoryReport 实例对象
     * @return 影响行数
     */
    int update(TbCategoryReport tbCategoryReport);

    /**
     * 通过主键删除数据
     *
     * @param categoryId1 主键
     * @return 影响行数
     */
    int deleteById(Integer categoryId1);

}

