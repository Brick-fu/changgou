package com.changgou.common.enums;

public enum OrderEnum {
    //订单来源
    ORDER_SOURCE_WEB("1","web"),
    ORDER_SOURCE_APP("2","app"),
    ORDER_SOURCE_WX_OFFICIAI_ACCT("3","微信公众号"),
    ORDER_SOURCE_WX_APPLET("4","web"),
    ORDER_SOURCE_H5("5","H5手机页面"),

    //订单状态
    ORDER_STATE_NO_COMPLETE("0","未完成"),
    ORDER_STATE_COMPLETE("1","已完成"),
    ORDER_STATE_RETURE_GOODS("2","已退货"),


    //支付状态,0:未支付，1：已支付，2：支付失败
    PAY_STATE_NO("0","未支付"),
    PAY_STATE_YES("1","已支付"),
    PAY_STATE_FAIL("2","支付失败"),

    //发货状态,0:未发货，1：已发货，2：已收货
    CONSIGN_STATE_NO("0","未发货"),
    CONSIGN__STATE_YES("1","已发货"),
    CONSIGN__STATE_OVER("2","已收货"),

    //支付类型，1、在线支付、0 货到付款
    ONLINE_PAY("1","在线支付"),
    COD("0","货到付款"),

    //支付类型，1、在线支付、0 货到付款
    YES("1","是/已评价"),
    NO("0","否/未评价"),
    ;


    private String code;
    private String desc;

    OrderEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
