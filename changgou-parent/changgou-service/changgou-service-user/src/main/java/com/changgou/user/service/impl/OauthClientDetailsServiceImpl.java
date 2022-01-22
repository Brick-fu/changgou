package com.changgou.user.service.impl;

import com.changgou.user.pojo.OauthClientDetails;
import com.changgou.user.dao.OauthClientDetailsDao;
import com.changgou.user.service.OauthClientDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (OauthClientDetails)表服务实现类
 *
 * @author makejava
 * @since 2021-12-28 23:41:55
 */
@Service("oauthClientDetailsService")
public class OauthClientDetailsServiceImpl implements OauthClientDetailsService {
    @Resource
    private OauthClientDetailsDao oauthClientDetailsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param clientId 主键
     * @return 实例对象
     */
    @Override
    public OauthClientDetails queryById(String clientId) {
        return this.oauthClientDetailsDao.queryById(clientId);
    }

    /**
     * 分页查询
     *
     * @param oauthClientDetails 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<OauthClientDetails> queryByPage(OauthClientDetails oauthClientDetails, PageRequest pageRequest) {
        long total = this.oauthClientDetailsDao.count(oauthClientDetails);
        return new PageImpl<>(this.oauthClientDetailsDao.queryAllByLimit(oauthClientDetails, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param oauthClientDetails 实例对象
     * @return 实例对象
     */
    @Override
    public OauthClientDetails insert(OauthClientDetails oauthClientDetails) {
        this.oauthClientDetailsDao.insert(oauthClientDetails);
        return oauthClientDetails;
    }

    /**
     * 修改数据
     *
     * @param oauthClientDetails 实例对象
     * @return 实例对象
     */
    @Override
    public OauthClientDetails update(OauthClientDetails oauthClientDetails) {
        this.oauthClientDetailsDao.update(oauthClientDetails);
        return this.queryById(oauthClientDetails.getClientId());
    }

    /**
     * 通过主键删除数据
     *
     * @param clientId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String clientId) {
        return this.oauthClientDetailsDao.deleteById(clientId) > 0;
    }
}
