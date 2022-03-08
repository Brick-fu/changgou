package com.changgou.common.entity;

import com.changgou.common.enums.StatusCodeEnum;
import org.slf4j.MDC;

import java.io.Serializable;

/**
 * 描述
 *
 * @version 1.0
 * @package com.changgou.common.entity *
 * @since 1.0
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 7031498825152043638L;

    private boolean flag;//是否成功
    private String code;//返回码
    private String message;//返回消息
    private String traceId = MDC.get("traceId");
    private T data;//返回数据
    private String path;

    public Result(boolean flag, String code, String message, T data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(boolean flag, String code, String message, String traceId, T data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.traceId = traceId;
        this.data = data;
    }

    public Result(boolean flag, String code, String message, String traceId, T data, String path) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.traceId = traceId;
        this.data = data;
        this.path = path;
    }

    public Result(boolean flag, String code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result() {
        this.flag = true;
        this.code = StatusCodeEnum.SUCCESS.getCode();
        this.message = "操作成功!";
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTraceId() {
        return traceId;
    }

    public Result<T> setTraceId(String traceId) {
        this.traceId = traceId;
        return this;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
