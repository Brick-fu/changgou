package com.changgou.user.dao;

import com.changgou.user.pojo.Cities;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 行政区域地州市信息表(Cities)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-19 14:44:51
 */
public interface CitiesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param cityid 主键
     * @return 实例对象
     */
    Cities queryById(String cityid);

    /**
     * 查询指定行数据
     *
     * @param cities 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Cities> queryAllByLimit(Cities cities, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param cities 查询条件
     * @return 总行数
     */
    long count(Cities cities);

    /**
     * 新增数据
     *
     * @param cities 实例对象
     * @return 影响行数
     */
    int insert(Cities cities);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Cities> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Cities> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Cities> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Cities> entities);

    /**
     * 修改数据
     *
     * @param cities 实例对象
     * @return 影响行数
     */
    int update(Cities cities);

    /**
     * 通过主键删除数据
     *
     * @param cityid 主键
     * @return 影响行数
     */
    int deleteById(String cityid);

}

