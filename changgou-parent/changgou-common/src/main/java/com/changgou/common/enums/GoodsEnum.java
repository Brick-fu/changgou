package com.changgou.common.enums;

public enum GoodsEnum {
    GOODS_STATE_NORMAL("1","正常"),
    GOODS_STATE_XJ("2","下架"),
    GOODS_STATE_DELETE("3","删除"),
    MARKETABLE_YES("1","已上架"),
    MARKETABLE_NO("0","已下架"),
    DELETE_YES("1","已删除"),
    DELETE_NO("0","未删除"),
    NOT_AUDITED("0","未审核"),
    AUDITED("1","已审核"),
    AUDITED_NO_PASS("2","审核不通过"),
    ;

    private String code;
    private String name;

    GoodsEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
