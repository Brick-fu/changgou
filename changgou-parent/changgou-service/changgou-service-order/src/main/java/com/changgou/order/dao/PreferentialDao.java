package com.changgou.order.dao;

import com.changgou.order.pojo.Preferential;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Preferential)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-19 14:10:02
 */
public interface PreferentialDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Preferential queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param preferential 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Preferential> queryAllByLimit(Preferential preferential, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param preferential 查询条件
     * @return 总行数
     */
    long count(Preferential preferential);

    /**
     * 新增数据
     *
     * @param preferential 实例对象
     * @return 影响行数
     */
    int insert(Preferential preferential);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Preferential> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Preferential> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Preferential> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Preferential> entities);

    /**
     * 修改数据
     *
     * @param preferential 实例对象
     * @return 影响行数
     */
    int update(Preferential preferential);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

