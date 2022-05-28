package com.changgou.order.dao;

import com.changgou.order.pojo.OrderConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (OrderConfig)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-19 14:09:55
 */
@Repository
public interface OrderConfigDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderConfig queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param orderConfig 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<OrderConfig> queryAllByLimit(OrderConfig orderConfig, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param orderConfig 查询条件
     * @return 总行数
     */
    long count(OrderConfig orderConfig);

    /**
     * 新增数据
     *
     * @param orderConfig 实例对象
     * @return 影响行数
     */
    int insert(OrderConfig orderConfig);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderConfig> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<OrderConfig> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderConfig> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<OrderConfig> entities);

    /**
     * 修改数据
     *
     * @param orderConfig 实例对象
     * @return 影响行数
     */
    int update(OrderConfig orderConfig);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

