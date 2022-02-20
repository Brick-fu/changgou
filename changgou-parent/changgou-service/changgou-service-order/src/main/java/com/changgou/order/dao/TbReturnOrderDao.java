package com.changgou.order.dao;

import com.changgou.order.pojo.TbReturnOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TbReturnOrder)表数据库访问层
 *
 * @author makejava
 * @since 2022-02-14 23:09:13
 */
public interface TbReturnOrderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbReturnOrder queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param tbReturnOrder 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TbReturnOrder> queryAllByLimit(TbReturnOrder tbReturnOrder, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tbReturnOrder 查询条件
     * @return 总行数
     */
    long count(TbReturnOrder tbReturnOrder);

    /**
     * 新增数据
     *
     * @param tbReturnOrder 实例对象
     * @return 影响行数
     */
    int insert(TbReturnOrder tbReturnOrder);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbReturnOrder> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbReturnOrder> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbReturnOrder> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbReturnOrder> entities);

    /**
     * 修改数据
     *
     * @param tbReturnOrder 实例对象
     * @return 影响行数
     */
    int update(TbReturnOrder tbReturnOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

