package com.changgou.user.pojo;

import java.io.Serializable;

/**
 * 省份信息表(Provinces)实体类
 *
 * @author makejava
 * @since 2022-03-19 14:44:51
 */
public class Provinces implements Serializable {
    private static final long serialVersionUID = -34068143014135101L;
    /**
     * 省份ID
     */
    private String provinceid;
    /**
     * 省份名称
     */
    private String province;


    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

}

