package com.changgou.user.pojo;

import java.io.Serializable;

/**
 * 行政区域地州市信息表(Cities)实体类
 *
 * @author makejava
 * @since 2022-03-19 14:44:51
 */
public class Cities implements Serializable {
    private static final long serialVersionUID = 175478503242514303L;
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

