package com.changgou.order.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;

/**
 * (TbOrderItem)实体类
 *
 * @author makejava
 * @since 2022-02-14 23:09:12
 */
public class TbOrderItem implements Serializable {
    private static final long serialVersionUID = 320817858916126569L;
    /**
     * ID
     */
    private String id;
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
     * SPU_ID
     */
    private Long spuId;
    /**
     * SKU_ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long skuId;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 单价
     */
    private Integer price;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 总金额
     */
    private Integer money;
    /**
     * 实付金额
     */
    private Integer payMoney;
    /**
     * 图片地址
     */
    private String image;
    /**
     * 重量
     */
    private Integer weight;
    /**
     * 运费
     */
    private Integer postFee;
    /**
     * 是否退货,0:未退货，1：已退货
     */
    private String isReturn;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getPostFee() {
        return postFee;
    }

    public void setPostFee(Integer postFee) {
        this.postFee = postFee;
    }

    public String getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(String isReturn) {
        this.isReturn = isReturn;
    }

}

