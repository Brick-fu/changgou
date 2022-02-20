package com.changgou.order.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (TbCategoryReport)实体类
 *
 * @author makejava
 * @since 2022-02-14 23:09:06
 */
public class TbCategoryReport implements Serializable {
    private static final long serialVersionUID = 480122316840927629L;
    /**
     * 1级分类
     */
    private Integer categoryId1;
    /**
     * 2级分类
     */
    private Integer categoryId2;
    /**
     * 3级分类
     */
    private Integer categoryId3;
    /**
     * 统计日期
     */
    private Date countDate;
    /**
     * 销售数量
     */
    private Integer num;
    /**
     * 销售额
     */
    private Integer money;


    public Integer getCategoryId1() {
        return categoryId1;
    }

    public void setCategoryId1(Integer categoryId1) {
        this.categoryId1 = categoryId1;
    }

    public Integer getCategoryId2() {
        return categoryId2;
    }

    public void setCategoryId2(Integer categoryId2) {
        this.categoryId2 = categoryId2;
    }

    public Integer getCategoryId3() {
        return categoryId3;
    }

    public void setCategoryId3(Integer categoryId3) {
        this.categoryId3 = categoryId3;
    }

    public Date getCountDate() {
        return countDate;
    }

    public void setCountDate(Date countDate) {
        this.countDate = countDate;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

}

