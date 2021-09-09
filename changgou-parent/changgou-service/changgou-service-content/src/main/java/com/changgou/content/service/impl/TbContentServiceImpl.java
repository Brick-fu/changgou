package com.changgou.content.service.impl;

import com.changgou.content.dao.TbContentDao;
import com.changgou.content.pojo.TbContent;
import com.changgou.content.service.TbContentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * (TbContent)表服务实现类
 *
 * @author makejava
 * @since 2021-08-22 11:24:05
 */
@Service("tbContentService")
public class TbContentServiceImpl implements TbContentService {
    @Resource
    private TbContentDao tbContentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbContent queryById(Long id) {
        return this.tbContentDao.queryById(id);
    }


    @Override
    public List<TbContent> findByCategory(Long categoryId) {
        TbContent content = new TbContent();
        content.setCategoryId(categoryId);
        content.setStatus("1");
        return tbContentDao.queryAll(content);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbContent> queryAllByLimit(TbContent tbContent, int offset, int limit) {
        return this.tbContentDao.queryAll(tbContent);
    }

    /**
     * 新增数据
     *
     * @param tbContent 实例对象
     * @return 实例对象
     */
    @Override
    public TbContent insert(TbContent tbContent) {
        this.tbContentDao.insert(tbContent);
        return tbContent;
    }

    /**
     * 修改数据
     *
     * @param tbContent 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean update(TbContent tbContent) {
        return this.tbContentDao.update(tbContent) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbContentDao.deleteById(id) > 0;
    }
}
