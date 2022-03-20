package com.changgou.order.pojo;

import java.io.Serializable;

/**
 * (ReturnOrderItem)实体类
 *
 * @author makejava
 * @since 2022-03-19 14:10:06
 */
public class ReturnOrderItem implements Serializable {
    private static final long serialVersionUID = 246473824020259419L;
    /**
     * ID
     */
    private Long id;
    /**
     * 分类ID
     */
    private Long categoryId;
    /**
     * SPU_ID
     */
    private Long spuId;
    /**
     * SKU_ID
     */
    private Long skuId;
    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 订单明细ID
     */
    private Long orderItemId;
    /**
     * 退货订单ID
     */
    private Long returnOrderId;
    /**
     * 标题
     */
    private String title;
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
     * 支付金额
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getReturnOrderId() {
        return returnOrderId;
    }

    public void setReturnOrderId(Long returnOrderId) {
        this.returnOrderId = returnOrderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

}

