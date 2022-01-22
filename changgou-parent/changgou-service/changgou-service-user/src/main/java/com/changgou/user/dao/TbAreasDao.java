package com.changgou.user.dao;

import com.changgou.user.pojo.TbAreas;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 行政区域县区信息表(TbAreas)表数据库访问层
 *
 * @author makejava
 * @since 2021-12-28 23:44:05
 */
@Mapper
public interface TbAreasDao {

    /**
     * 通过ID查询单条数据
     *
     * @param areaid 主键
     * @return 实例对象
     */
    TbAreas queryById(String areaid);

    /**
     * 查询指定行数据
     *
     * @param tbAreas 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TbAreas> queryAllByLimit(TbAreas tbAreas, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tbAreas 查询条件
     * @return 总行数
     */
    long count(TbAreas tbAreas);

    /**
     * 新增数据
     *
     * @param tbAreas 实例对象
     * @return 影响行数
     */
    int insert(TbAreas tbAreas);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbAreas> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbAreas> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbAreas> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbAreas> entities);

    /**
     * 修改数据
     *
     * @param tbAreas 实例对象
     * @return 影响行数
     */
    int update(TbAreas tbAreas);

    /**
     * 通过主键删除数据
     *
     * @param areaid 主键
     * @return 影响行数
     */
    int deleteById(String areaid);

}

