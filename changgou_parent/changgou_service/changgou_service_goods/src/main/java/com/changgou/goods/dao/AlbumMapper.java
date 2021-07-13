package com.changgou.goods.dao;

import com.changgou.goods.pojo.Album;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumMapper {
    /***
     * Album多条件分页查询
     * @param album
     * @return
     */
    List<Album> findPage(Album album);

    /***
     * 删除Album
     * @param id
     */
    void delete(Long id);

    /***
     * 修改Album数据
     * @param album
     */
    void update(Album album);

    /***
     * 新增Album
     * @param album
     */
    void add(Album album);

    /**
     * 根据ID查询Album
     * @param id
     * @return
     */
    Album findById(Long id);

    /***
     * 查询所有Album
     * @return
     */
    List<Album> findList();
}
