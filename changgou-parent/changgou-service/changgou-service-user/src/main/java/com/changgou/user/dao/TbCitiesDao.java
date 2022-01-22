package com.changgou.user.dao;

import com.changgou.user.pojo.TbCities;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 行政区域地州市信息表(TbCities)表数据库访问层
 *
 * @author makejava
 * @since 2021-12-28 23:44:05
 */
@Mapper
public interface TbCitiesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param cityid 主键
     * @return 实例对象
     */
    TbCities queryById(String cityid);

    /**
     * 查询指定行数据
     *
     * @param tbCities 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TbCities> queryAllByLimit(TbCities tbCities, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tbCities 查询条件
     * @return 总行数
     */
    long count(TbCities tbCities);

    /**
     * 新增数据
     *
     * @param tbCities 实例对象
     * @return 影响行数
     */
    int insert(TbCities tbCities);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbCities> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbCities> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbCities> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbCities> entities);

    /**
     * 修改数据
     *
     * @param tbCities 实例对象
     * @return 影响行数
     */
    int update(TbCities tbCities);

    /**
     * 通过主键删除数据
     *
     * @param cityid 主键
     * @return 影响行数
     */
    int deleteById(String cityid);

}

