package com.changgou.exception;

import com.changgou.enums.StatusCodeEnum;

public class BizException extends RuntimeException{

    private static final long serialVersionUID = -3079380714643478081L;

    private String errorCode;
    private String errorMsg;

    public BizException() {
        super();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public BizException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(StatusCodeEnum statusCodeEnum) {
        super(statusCodeEnum.getMessage());
        this.errorCode = statusCodeEnum.getCode();
        this.errorMsg = statusCodeEnum.getMessage();
    }

    public BizException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public BizException(StatusCodeEnum statusCodeEnum, Throwable cause) {
        super(statusCodeEnum.getMessage(), cause);
        this.errorCode = statusCodeEnum.getCode();
        this.errorMsg = statusCodeEnum.getMessage();
    }
}
