package com.changgou.seckill.dao;

import com.changgou.seckill.pojo.SeckillGoods;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (SeckillGoods)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-19 14:00:27
 */
@Repository
public interface SeckillGoodsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SeckillGoods queryById(Long id);

    /*
     * @Desc 查询秒杀商品
     * @Date 下午8:12 2022/3/19
     * @Author brick
     **/
    List<SeckillGoods> querySeckillGoods(SeckillGoods seckillGoods);

    /**
     * 查询指定行数据
     *
     * @param seckillGoods 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<SeckillGoods> queryAllByLimit(@Param("seckillGoods") SeckillGoods seckillGoods, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param seckillGoods 查询条件
     * @return 总行数
     */
    long count(SeckillGoods seckillGoods);

    /**
     * 新增数据
     *
     * @param seckillGoods 实例对象
     * @return 影响行数
     */
    int insert(SeckillGoods seckillGoods);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SeckillGoods> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SeckillGoods> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SeckillGoods> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SeckillGoods> entities);

    /**
     * 修改数据
     *
     * @param seckillGoods 实例对象
     * @return 影响行数
     */
    int update(SeckillGoods seckillGoods);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

