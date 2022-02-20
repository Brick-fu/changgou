package com.changgou.order.service;

import com.changgou.order.pojo.TbCategoryReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TbCategoryReport)表服务接口
 *
 * @author makejava
 * @since 2022-02-14 23:09:09
 */
public interface TbCategoryReportService {

    /**
     * 通过ID查询单条数据
     *
     * @param categoryId1 主键
     * @return 实例对象
     */
    TbCategoryReport queryById(Integer categoryId1);

    /**
     * 分页查询
     *
     * @param tbCategoryReport 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbCategoryReport> queryByPage(TbCategoryReport tbCategoryReport, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbCategoryReport 实例对象
     * @return 实例对象
     */
    TbCategoryReport insert(TbCategoryReport tbCategoryReport);

    /**
     * 修改数据
     *
     * @param tbCategoryReport 实例对象
     * @return 实例对象
     */
    TbCategoryReport update(TbCategoryReport tbCategoryReport);

    /**
     * 通过主键删除数据
     *
     * @param categoryId1 主键
     * @return 是否成功
     */
    boolean deleteById(Integer categoryId1);

}
