package com.changgou.user.service;

import com.changgou.user.pojo.Areas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 行政区域县区信息表(Areas)表服务接口
 *
 * @author makejava
 * @since 2022-03-19 14:44:49
 */
public interface AreasService {

    /**
     * 通过ID查询单条数据
     *
     * @param areaid 主键
     * @return 实例对象
     */
    Areas queryById(String areaid);

    /**
     * 分页查询
     *
     * @param areas 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Areas> queryByPage(Areas areas, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param areas 实例对象
     * @return 实例对象
     */
    Areas insert(Areas areas);

    /**
     * 修改数据
     *
     * @param areas 实例对象
     * @return 实例对象
     */
    Areas update(Areas areas);

    /**
     * 通过主键删除数据
     *
     * @param areaid 主键
     * @return 是否成功
     */
    boolean deleteById(String areaid);

}
