package com.changgou.order.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (ReturnOrder)实体类
 *
 * @author makejava
 * @since 2022-03-19 14:10:05
 */
public class ReturnOrder implements Serializable {
    private static final long serialVersionUID = -91540689127226768L;
    /**
     * 服务单号
     */
    private Long id;
    /**
     * 订单号
     */
    private Long orderId;
    /**
     * 申请时间
     */
    private Date applyTime;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户账号
     */
    private String userAccount;
    /**
     * 联系人
     */
    private String linkman;
    /**
     * 联系人手机
     */
    private String linkmanMobile;
    /**
     * 类型
     */
    private String type;
    /**
     * 退款金额
     */
    private Integer returnMoney;
    /**
     * 是否退运费
     */
    private String isReturnFreight;
    /**
     * 申请状态
     */
    private String status;
    /**
     * 处理时间
     */
    private Date disposeTime;
    /**
     * 退货退款原因
     */
    private Integer returnCause;
    /**
     * 凭证图片
     */
    private String evidence;
    /**
     * 问题描述
     */
    private String description;
    /**
     * 处理备注
     */
    private String remark;
    /**
     * 管理员id
     */
    private Integer adminId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getLinkmanMobile() {
        return linkmanMobile;
    }

    public void setLinkmanMobile(String linkmanMobile) {
        this.linkmanMobile = linkmanMobile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(Integer returnMoney) {
        this.returnMoney = returnMoney;
    }

    public String getIsReturnFreight() {
        return isReturnFreight;
    }

    public void setIsReturnFreight(String isReturnFreight) {
        this.isReturnFreight = isReturnFreight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDisposeTime() {
        return disposeTime;
    }

    public void setDisposeTime(Date disposeTime) {
        this.disposeTime = disposeTime;
    }

    public Integer getReturnCause() {
        return returnCause;
    }

    public void setReturnCause(Integer returnCause) {
        this.returnCause = returnCause;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

}

