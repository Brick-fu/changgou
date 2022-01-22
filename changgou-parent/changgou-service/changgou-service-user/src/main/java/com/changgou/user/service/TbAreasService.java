package com.changgou.user.service;

import com.changgou.user.pojo.TbAreas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 行政区域县区信息表(TbAreas)表服务接口
 *
 * @author makejava
 * @since 2021-12-28 23:44:05
 */
public interface TbAreasService {

    /**
     * 通过ID查询单条数据
     *
     * @param areaid 主键
     * @return 实例对象
     */
    TbAreas queryById(String areaid);

    /**
     * 分页查询
     *
     * @param tbAreas 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbAreas> queryByPage(TbAreas tbAreas, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbAreas 实例对象
     * @return 实例对象
     */
    TbAreas insert(TbAreas tbAreas);

    /**
     * 修改数据
     *
     * @param tbAreas 实例对象
     * @return 实例对象
     */
    TbAreas update(TbAreas tbAreas);

    /**
     * 通过主键删除数据
     *
     * @param areaid 主键
     * @return 是否成功
     */
    boolean deleteById(String areaid);

}
