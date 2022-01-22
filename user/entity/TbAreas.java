package com.changgou.user.entity;

import java.io.Serializable;

/**
 * 行政区域县区信息表(TbAreas)实体类
 *
 * @author makejava
 * @since 2021-12-28 23:44:05
 */
public class TbAreas implements Serializable {
    private static final long serialVersionUID = 799586620957312674L;
    /**
     * 区域ID
     */
    private String areaid;
    /**
     * 区域名称
     */
    private String area;
    /**
     * 城市ID
     */
    private String cityid;


    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

}

