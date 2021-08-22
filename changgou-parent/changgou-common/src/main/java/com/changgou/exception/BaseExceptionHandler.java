package com.changgou.exception;

import com.changgou.entity.Result;
import com.changgou.enums.StatusCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class BaseExceptionHandler {

    Logger logger = LoggerFactory.getLogger(BaseExceptionHandler.class);

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public Result<Void> bizExceptionHandler(HttpServletRequest request, BizException e){
        logger.error("发生业务异常！",e);
        Result<Void> result = new Result<>(false, e.getErrorCode(), e.getErrorMsg());
        result.setPath(request.getRequestURI());
        return result;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<Void> exceptionHandler(HttpServletRequest request, Exception e){
        logger.error("发生系统异常！",e);
        Result<Void> result = new Result<>(false, StatusCodeEnum.ERROR.getCode(), StatusCodeEnum.ERROR.getMessage());
        result.setPath(request.getRequestURI());
        return result;
    }
}
