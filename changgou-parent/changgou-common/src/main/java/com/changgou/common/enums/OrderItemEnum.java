package com.changgou.common.enums;

public enum OrderItemEnum {

    NO_RETURN_GOODS("0","未退货"),
    YES_RETURN_GOODS("1","已退货"),


    //支付类型，1、在线支付、0 货到付款
    YES("1","是"),
    NO("0","否"),
    ;


    private String code;
    private String desc;

    OrderItemEnum(String code, String desc) {
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
