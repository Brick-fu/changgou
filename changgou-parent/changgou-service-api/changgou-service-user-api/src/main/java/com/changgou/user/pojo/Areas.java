package com.changgou.user.pojo;

import java.io.Serializable;

/**
 * 行政区域县区信息表(Areas)实体类
 *
 * @author makejava
 * @since 2022-03-19 14:44:48
 */
public class Areas implements Serializable {
    private static final long serialVersionUID = 594148915838398555L;
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

