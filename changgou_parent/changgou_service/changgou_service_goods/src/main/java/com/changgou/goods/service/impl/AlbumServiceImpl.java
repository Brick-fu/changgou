package com.changgou.goods.service.impl;

import com.changgou.goods.dao.AlbumMapper;
import com.changgou.goods.pojo.Album;
import com.changgou.goods.service.AlbumService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    @Override
    public PageInfo<Album> findPage(Album album, int page, int size) {
        PageHelper.startPage(page,size);
        List<Album> albums = albumMapper.findPage(album);
        return new PageInfo<>(albums);
    }

    @Override
    public PageInfo<Album> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        List<Album> albums = albumMapper.findList();
        return new PageInfo<>(albums);
    }

    @Override
    public List<Album> findList(Album album) {
        return albumMapper.findPage(album);
    }

    @Override
    public void delete(Long id) {
        albumMapper.delete(id);
    }

    @Override
    public void update(Album album) {
        albumMapper.update(album);
    }

    @Override
    public void add(Album album) {
        albumMapper.add(album);
    }

    @Override
    public Album findById(Long id) {
        return albumMapper.findById(id);
    }

    @Override
    public List<Album> findAll() {
        return albumMapper.findList();
    }
}
