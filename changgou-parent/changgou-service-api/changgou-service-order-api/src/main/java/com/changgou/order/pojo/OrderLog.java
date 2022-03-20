package com.changgou.order.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (OrderLog)实体类
 *
 * @author makejava
 * @since 2022-03-19 14:09:59
 */
public class OrderLog implements Serializable {
    private static final long serialVersionUID = 707482422324889320L;
    /**
     * ID
     */
    private String id;
    /**
     * 操作员
     */
    private String operater;
    /**
     * 操作时间
     */
    private Date operateTime;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 订单状态,0未完成，1已完成，2，已退货
     */
    private String orderStatus;
    /**
     * 付款状态  0:未支付，1：已支付，2：支付失败
     */
    private String payStatus;
    /**
     * 发货状态
     */
    private String consignStatus;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 支付金额
     */
    private Integer money;
    
    private String username;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperater() {
        return operater;
    }

    public void setOperater(String operater) {
        this.operater = operater;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getConsignStatus() {
        return consignStatus;
    }

    public void setConsignStatus(String consignStatus) {
        this.consignStatus = consignStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

