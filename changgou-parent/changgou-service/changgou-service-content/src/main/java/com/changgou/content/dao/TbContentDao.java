package com.changgou.content.dao;

import com.changgou.content.pojo.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (TbContent)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-22 11:23:56
 */
@Repository
public interface TbContentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbContent queryById(Long id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbContent 实例对象
     * @return 对象列表
     */
    List<TbContent> queryAll(TbContent tbContent);

    /**
     * 新增数据
     *
     * @param tbContent 实例对象
     * @return 影响行数
     */
    int insert(TbContent tbContent);

    /**
     * 修改数据
     *
     * @param tbContent 实例对象
     * @return 影响行数
     */
    int update(TbContent tbContent);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

