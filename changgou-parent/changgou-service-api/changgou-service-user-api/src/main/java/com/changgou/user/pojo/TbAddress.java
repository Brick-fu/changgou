package com.changgou.user.pojo;

import java.io.Serializable;

/**
 * (TbAddress)实体类
 *
 * @author makejava
 * @since 2021-12-28 23:43:30
 */
public class TbAddress implements Serializable {
    private static final long serialVersionUID = -62104257315409783L;
    
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 省
     */
    private String provinceid;
    /**
     * 市
     */
    private String cityid;
    /**
     * 县/区
     */
    private String areaid;
    /**
     * 电话
     */
    private String phone;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 是否是默认 1默认 0否
     */
    private String isDefault;
    /**
     * 别名
     */
    private String alias;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

}

