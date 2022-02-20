package com.changgou.order.dao;

import com.changgou.order.pojo.TbOrderConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TbOrderConfig)表数据库访问层
 *
 * @author makejava
 * @since 2022-02-14 23:09:12
 */
public interface TbOrderConfigDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbOrderConfig queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param tbOrderConfig 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TbOrderConfig> queryAllByLimit(TbOrderConfig tbOrderConfig, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tbOrderConfig 查询条件
     * @return 总行数
     */
    long count(TbOrderConfig tbOrderConfig);

    /**
     * 新增数据
     *
     * @param tbOrderConfig 实例对象
     * @return 影响行数
     */
    int insert(TbOrderConfig tbOrderConfig);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbOrderConfig> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbOrderConfig> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbOrderConfig> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbOrderConfig> entities);

    /**
     * 修改数据
     *
     * @param tbOrderConfig 实例对象
     * @return 影响行数
     */
    int update(TbOrderConfig tbOrderConfig);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

