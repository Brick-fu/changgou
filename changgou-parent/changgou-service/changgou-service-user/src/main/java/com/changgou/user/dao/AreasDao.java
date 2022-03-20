package com.changgou.user.dao;

import com.changgou.user.pojo.Areas;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 行政区域县区信息表(Areas)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-19 14:44:47
 */
public interface AreasDao {

    /**
     * 通过ID查询单条数据
     *
     * @param areaid 主键
     * @return 实例对象
     */
    Areas queryById(String areaid);

    /**
     * 查询指定行数据
     *
     * @param areas 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Areas> queryAllByLimit(Areas areas, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param areas 查询条件
     * @return 总行数
     */
    long count(Areas areas);

    /**
     * 新增数据
     *
     * @param areas 实例对象
     * @return 影响行数
     */
    int insert(Areas areas);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Areas> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Areas> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Areas> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Areas> entities);

    /**
     * 修改数据
     *
     * @param areas 实例对象
     * @return 影响行数
     */
    int update(Areas areas);

    /**
     * 通过主键删除数据
     *
     * @param areaid 主键
     * @return 影响行数
     */
    int deleteById(String areaid);

}

