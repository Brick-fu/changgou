package com.changgou.user.pojo;

import java.io.Serializable;

/**
 * 省份信息表(TbProvinces)实体类
 *
 * @author makejava
 * @since 2021-12-28 23:44:05
 */
public class TbProvinces implements Serializable {
    private static final long serialVersionUID = 648427857439613948L;
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

