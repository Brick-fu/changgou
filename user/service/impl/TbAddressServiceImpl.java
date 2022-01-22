package com.changgou.user.service.impl;

import com.changgou.user.entity.TbAddress;
import com.changgou.user.dao.TbAddressDao;
import com.changgou.user.service.TbAddressService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TbAddress)表服务实现类
 *
 * @author makejava
 * @since 2021-12-28 23:43:30
 */
@Service("tbAddressService")
public class TbAddressServiceImpl implements TbAddressService {
    @Resource
    private TbAddressDao tbAddressDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbAddress queryById(Integer id) {
        return this.tbAddressDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbAddress 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbAddress> queryByPage(TbAddress tbAddress, PageRequest pageRequest) {
        long total = this.tbAddressDao.count(tbAddress);
        return new PageImpl<>(this.tbAddressDao.queryAllByLimit(tbAddress, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbAddress 实例对象
     * @return 实例对象
     */
    @Override
    public TbAddress insert(TbAddress tbAddress) {
        this.tbAddressDao.insert(tbAddress);
        return tbAddress;
    }

    /**
     * 修改数据
     *
     * @param tbAddress 实例对象
     * @return 实例对象
     */
    @Override
    public TbAddress update(TbAddress tbAddress) {
        this.tbAddressDao.update(tbAddress);
        return this.queryById(tbAddress.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbAddressDao.deleteById(id) > 0;
    }
}
