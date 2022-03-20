package com.changgou.order.pojo;

import java.io.Serializable;

/**
 * (OrderConfig)实体类
 *
 * @author makejava
 * @since 2022-03-19 14:09:56
 */
public class OrderConfig implements Serializable {
    private static final long serialVersionUID = 347815030402988857L;
    /**
     * ID
     */
    private Integer id;
    /**
     * 正常订单超时时间（分）
     */
    private Integer orderTimeout;
    /**
     * 秒杀订单超时时间（分）
     */
    private Integer seckillTimeout;
    /**
     * 自动收货（天）
     */
    private Integer takeTimeout;
    /**
     * 售后期限
     */
    private Integer serviceTimeout;
    /**
     * 自动五星好评
     */
    private Integer commentTimeout;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderTimeout() {
        return orderTimeout;
    }

    public void setOrderTimeout(Integer orderTimeout) {
        this.orderTimeout = orderTimeout;
    }

    public Integer getSeckillTimeout() {
        return seckillTimeout;
    }

    public void setSeckillTimeout(Integer seckillTimeout) {
        this.seckillTimeout = seckillTimeout;
    }

    public Integer getTakeTimeout() {
        return takeTimeout;
    }

    public void setTakeTimeout(Integer takeTimeout) {
        this.takeTimeout = takeTimeout;
    }

    public Integer getServiceTimeout() {
        return serviceTimeout;
    }

    public void setServiceTimeout(Integer serviceTimeout) {
        this.serviceTimeout = serviceTimeout;
    }

    public Integer getCommentTimeout() {
        return commentTimeout;
    }

    public void setCommentTimeout(Integer commentTimeout) {
        this.commentTimeout = commentTimeout;
    }

}

