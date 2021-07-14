package com.changgou.goods.service.impl;

import com.changgou.goods.dao.AlbumMapper;
import com.changgou.goods.pojo.Album;
import com.changgou.goods.service.AlbumService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    private static final Logger logger = LoggerFactory.getLogger(AlbumServiceImpl.class);

    @Autowired
    private AlbumMapper albumMapper;

    @Override
    public PageInfo<Album> findPage(Album album, int page, int size) {
        logger.info("AlbumServiceImpl.findPage,{},{},{}",album.toString(),page,size);
        PageHelper.startPage(page,size);
        List<Album> albums = albumMapper.findPage(album);
        return new PageInfo<>(albums);
    }

    @Override
    public PageInfo<Album> findPage(int page, int size) {
        logger.info("AlbumServiceImpl.findPage,{},{}",page,size);
        PageHelper.startPage(page,size);
        List<Album> albums = albumMapper.findList();
        return new PageInfo<>(albums);
    }

    @Override
    public List<Album> findList(Album album) {
        logger.info("AlbumServiceImpl.findList,{}",album.toString());
        return albumMapper.findPage(album);
    }

    @Override
    public void delete(Long id) {
        logger.info("AlbumServiceImpl.delete,{}",id);
        albumMapper.delete(id);
    }

    @Override
    public void update(Album album) {
        logger.info("AlbumServiceImpl.update,{}",album.toString());
        albumMapper.update(album);
    }

    @Override
    public void add(Album album) {
        logger.info("AlbumServiceImpl.add,{}",album.toString());
        albumMapper.add(album);
    }

    @Override
    public Album findById(Long id) {
        logger.info("AlbumServiceImpl.findById,{}",id);
        return albumMapper.findById(id);
    }

    @Override
    public List<Album> findAll() {
        logger.info("AlbumServiceImpl.findAll");
        return albumMapper.findList();
    }
}
