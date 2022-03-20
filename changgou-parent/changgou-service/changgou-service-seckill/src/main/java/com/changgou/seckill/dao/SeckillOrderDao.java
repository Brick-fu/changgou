package com.changgou.seckill.dao;

import com.changgou.seckill.pojo.SeckillOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (SeckillOrder)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-19 12:02:49
 */
@Repository
public interface SeckillOrderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SeckillOrder queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param seckillOrder 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<SeckillOrder> queryAllByLimit(SeckillOrder seckillOrder, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param seckillOrder 查询条件
     * @return 总行数
     */
    long count(SeckillOrder seckillOrder);

    /**
     * 新增数据
     *
     * @param seckillOrder 实例对象
     * @return 影响行数
     */
    int insert(SeckillOrder seckillOrder);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SeckillOrder> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SeckillOrder> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SeckillOrder> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SeckillOrder> entities);

    /**
     * 修改数据
     *
     * @param seckillOrder 实例对象
     * @return 影响行数
     */
    int update(SeckillOrder seckillOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

