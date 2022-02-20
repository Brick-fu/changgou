package com.changgou.order.service.impl;

import com.changgou.order.pojo.TbCategoryReport;
import com.changgou.order.dao.TbCategoryReportDao;
import com.changgou.order.service.TbCategoryReportService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TbCategoryReport)表服务实现类
 *
 * @author makejava
 * @since 2022-02-14 23:09:10
 */
@Service("tbCategoryReportService")
public class TbCategoryReportServiceImpl implements TbCategoryReportService {
    @Resource
    private TbCategoryReportDao tbCategoryReportDao;

    /**
     * 通过ID查询单条数据
     *
     * @param categoryId1 主键
     * @return 实例对象
     */
    @Override
    public TbCategoryReport queryById(Integer categoryId1) {
        return this.tbCategoryReportDao.queryById(categoryId1);
    }

    /**
     * 分页查询
     *
     * @param tbCategoryReport 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbCategoryReport> queryByPage(TbCategoryReport tbCategoryReport, PageRequest pageRequest) {
        long total = this.tbCategoryReportDao.count(tbCategoryReport);
        return new PageImpl<>(this.tbCategoryReportDao.queryAllByLimit(tbCategoryReport, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbCategoryReport 实例对象
     * @return 实例对象
     */
    @Override
    public TbCategoryReport insert(TbCategoryReport tbCategoryReport) {
        this.tbCategoryReportDao.insert(tbCategoryReport);
        return tbCategoryReport;
    }

    /**
     * 修改数据
     *
     * @param tbCategoryReport 实例对象
     * @return 实例对象
     */
    @Override
    public TbCategoryReport update(TbCategoryReport tbCategoryReport) {
        this.tbCategoryReportDao.update(tbCategoryReport);
        return this.queryById(tbCategoryReport.getCategoryId1());
    }

    /**
     * 通过主键删除数据
     *
     * @param categoryId1 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer categoryId1) {
        return this.tbCategoryReportDao.deleteById(categoryId1) > 0;
    }
}
