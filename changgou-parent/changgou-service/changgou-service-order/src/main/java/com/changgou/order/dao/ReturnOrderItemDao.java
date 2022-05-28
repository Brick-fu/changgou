package com.changgou.order.dao;

import com.changgou.order.pojo.ReturnOrderItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ReturnOrderItem)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-19 14:10:06
 */
@Repository
public interface ReturnOrderItemDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ReturnOrderItem queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param returnOrderItem 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<ReturnOrderItem> queryAllByLimit(ReturnOrderItem returnOrderItem, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param returnOrderItem 查询条件
     * @return 总行数
     */
    long count(ReturnOrderItem returnOrderItem);

    /**
     * 新增数据
     *
     * @param returnOrderItem 实例对象
     * @return 影响行数
     */
    int insert(ReturnOrderItem returnOrderItem);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ReturnOrderItem> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ReturnOrderItem> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ReturnOrderItem> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ReturnOrderItem> entities);

    /**
     * 修改数据
     *
     * @param returnOrderItem 实例对象
     * @return 影响行数
     */
    int update(ReturnOrderItem returnOrderItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

