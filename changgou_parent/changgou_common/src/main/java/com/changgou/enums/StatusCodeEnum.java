package com.changgou.enums;

public enum StatusCodeEnum {
    OK(20000,"成功"),
    ERROR(20001,"失败"),
    LOGINERROR(20002,"用户名或密码错误"),
    ACCESSERROR(20003,"权限不足"),
    REMOTEERROR(20004,"远程调用失败"),
    REPERROR(20005,"重复操作"),
    NOTFOUNDERROR(20006,"没有对应的抢购数据");

    private Integer code;
    private String message;

    StatusCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
