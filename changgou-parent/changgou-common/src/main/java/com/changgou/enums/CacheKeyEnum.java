package com.changgou.enums;

public enum CacheKeyEnum {
    CATEGORY("CATEGORY","商品分类"),
    BRAND("BRAND","品牌缓存"),
    SPEC("SPEC","规格")
    ;

    private String code;
    private String name;

    CacheKeyEnum(String code, String name) {
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
