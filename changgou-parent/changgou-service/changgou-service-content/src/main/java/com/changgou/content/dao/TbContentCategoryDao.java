package com.changgou.content.dao;

import com.changgou.content.pojo.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 内容分类(TbContentCategory)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-22 11:24:40
 */
@Repository
public interface TbContentCategoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbContentCategory queryById(Long id);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbContentCategory 实例对象
     * @return 对象列表
     */
    List<TbContentCategory> queryAll(TbContentCategory tbContentCategory);

    /**
     * 新增数据
     *
     * @param tbContentCategory 实例对象
     * @return 影响行数
     */
    int insert(TbContentCategory tbContentCategory);

    /**
     * 修改数据
     *
     * @param tbContentCategory 实例对象
     * @return 影响行数
     */
    int update(TbContentCategory tbContentCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

