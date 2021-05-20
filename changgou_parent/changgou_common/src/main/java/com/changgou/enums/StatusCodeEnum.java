package com.changgou.enums;

public enum StatusCodeEnum {
    /*系统服务码*/
    SUCCESS("000000","成功！"),
    ERROR("000500","服务器内部错误！"),
    LOGINERROR("100002","用户名或密码错误"),
    ACCESSERROR("100003","权限不足"),
    REMOTEERROR("100004","远程调用失败"),
    REPERROR("100005","重复操作"),
    NOTFOUNDERROR("100006","没有对应的抢购数据");


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
