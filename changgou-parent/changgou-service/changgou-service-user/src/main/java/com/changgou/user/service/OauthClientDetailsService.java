package com.changgou.user.service;

import com.changgou.user.pojo.OauthClientDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (OauthClientDetails)表服务接口
 *
 * @author makejava
 * @since 2021-12-28 23:41:55
 */
public interface OauthClientDetailsService {

    /**
     * 通过ID查询单条数据
     *
     * @param clientId 主键
     * @return 实例对象
     */
    OauthClientDetails queryById(String clientId);

    /**
     * 分页查询
     *
     * @param oauthClientDetails 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<OauthClientDetails> queryByPage(OauthClientDetails oauthClientDetails, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param oauthClientDetails 实例对象
     * @return 实例对象
     */
    OauthClientDetails insert(OauthClientDetails oauthClientDetails);

    /**
     * 修改数据
     *
     * @param oauthClientDetails 实例对象
     * @return 实例对象
     */
    OauthClientDetails update(OauthClientDetails oauthClientDetails);

    /**
     * 通过主键删除数据
     *
     * @param clientId 主键
     * @return 是否成功
     */
    boolean deleteById(String clientId);

}
