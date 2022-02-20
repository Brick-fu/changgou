package com.changgou.order.pojo;

import java.io.Serializable;

/**
 * (TbReturnCause)实体类
 *
 * @author makejava
 * @since 2022-02-14 23:09:13
 */
public class TbReturnCause implements Serializable {
    private static final long serialVersionUID = -88688179925830133L;
    /**
     * ID
     */
    private Integer id;
    /**
     * 原因
     */
    private String cause;
    /**
     * 排序
     */
    private Integer seq;
    /**
     * 是否启用
     */
    private String status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

