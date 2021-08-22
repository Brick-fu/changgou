package com.changgou.enums;

public enum StatusCodeEnum {
    /*系统服务码*/
    SUCCESS("000000","成功！"),
    ERROR("000500","服务器内部错误！"),
    LOGINERROR("100002","用户名或密码错误"),
    ACCESSERROR("100003","权限不足"),
    REMOTEERROR("100004","远程调用失败"),
    REPERROR("100005","重复操作"),
    NOTFOUNDERROR("100006","没有对应的抢购数据"),
    /*文件上传服务码*/
    MINIOCLINT_CREATE_FAIL("200001","minioClient创建失败"),
    /*商品中心服务码*/
    GOODS_DELETED("300001","该商品已经删除！"),
    AUDITED_NO_PASS_TIP("300002","未通过审核的商品不能上架！"),
    GOODS_MUST_PUT_ON_SHELVES("300003","必须先下架再删除！"),
    GOODS_NOT_DELETE("300004","此商品未删除！"),
    GOODS_CANNOT_DELETE("300005","此商品不能删除！"),

    ;



    private String code;
    private String message;

    StatusCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
