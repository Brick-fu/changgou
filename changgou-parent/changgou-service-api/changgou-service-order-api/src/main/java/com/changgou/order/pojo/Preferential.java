package com.changgou.order.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Preferential)实体类
 *
 * @author makejava
 * @since 2022-03-19 14:10:02
 */
public class Preferential implements Serializable {
    private static final long serialVersionUID = -91556318285585030L;
    /**
     * ID
     */
    private Integer id;
    /**
     * 消费金额
     */
    private Integer buyMoney;
    /**
     * 优惠金额
     */
    private Integer preMoney;
    /**
     * 品类ID
     */
    private Long categoryId;
    /**
     * 活动开始日期
     */
    private Date startTime;
    /**
     * 活动截至日期
     */
    private Date endTime;
    /**
     * 状态
     */
    private String state;
    /**
     * 类型1不翻倍 2翻倍
     */
    private String type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuyMoney() {
        return buyMoney;
    }

    public void setBuyMoney(Integer buyMoney) {
        this.buyMoney = buyMoney;
    }

    public Integer getPreMoney() {
        return preMoney;
    }

    public void setPreMoney(Integer preMoney) {
        this.preMoney = preMoney;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

