package com.changgou.user.pojo;

import java.io.Serializable;

/**
 * 行政区域地州市信息表(TbCities)实体类
 *
 * @author makejava
 * @since 2021-12-28 23:44:05
 */
public class TbCities implements Serializable {
    private static final long serialVersionUID = 918720230876786062L;
    /**
     * 城市ID
     */
    private String cityid;
    /**
     * 城市名称
     */
    private String city;
    /**
     * 省份ID
     */
    private String provinceid;


    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }

}

