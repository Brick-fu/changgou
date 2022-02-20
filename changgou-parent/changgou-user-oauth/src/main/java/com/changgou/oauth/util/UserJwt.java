package com.changgou.oauth.util;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;


public class UserJwt extends User {
    private static final long serialVersionUID = -4571630215895660032L;
    private String id;    //用户ID
    private String name;  //用户昵称
    private String phone;
    private String email;
    private Date created;
    private String sex; //性别，1男，0女
    private Integer userLevel; //会员等级
    private Integer points; //积分

    private Integer experienceValue; //经验值
    private Date birthday;
    private Date lastLoginTime; //最后登录时间

    public UserJwt(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserJwt(String username, String password, Collection<? extends GrantedAuthority> authorities, String name, String phone, String email, Date created, String sex, Integer userLevel, Integer points, Integer experienceValue, Date birthday, Date lastLoginTime) {
        super(username, password, authorities);
        this.id = username;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.created = created;
        this.sex = sex;
        this.userLevel = userLevel;
        this.points = points;
        this.experienceValue = experienceValue;
        this.birthday = birthday;
        this.lastLoginTime = lastLoginTime;
    }

    public void  toMap(LinkedHashMap<String,Object> response){
        response.put("id", this.getId());
        response.put("nickName", this.getName());
        response.put("phone",this.getPhone());
        response.put("email",this.getEmail());
        response.put("created",this.getCreated());
        response.put("sex",this.getSex());
        response.put("userLevel",this.userLevel);
        response.put("points",this.points);
        response.put("experienceValue",this.experienceValue);
        response.put("birthday",this.birthday);
        response.put("lastLoginTime",this.lastLoginTime);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getExperienceValue() {
        return experienceValue;
    }

    public void setExperienceValue(Integer experienceValue) {
        this.experienceValue = experienceValue;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "UserJwt{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", created=" + created +
                ", sex='" + sex + '\'' +
                ", userLevel=" + userLevel +
                ", points=" + points +
                ", experienceValue=" + experienceValue +
                ", birthday='" + birthday + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}
