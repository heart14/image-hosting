package com.example.heart.imagehosting.exception;

import com.example.heart.imagehosting.common.SysErrorCode;
import com.example.heart.imagehosting.domain.SysResponse;
import com.example.heart.imagehosting.utils.SysResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: SysExceptionHandler
 * @Description: 系统全局异常处理器
 * @Author: jayhe
 * @Date: 2019/10/29 17:31
 * @Version: v1.0
 */
@RestControllerAdvice
public class SysExceptionHandler {

    public static final Logger logger = LoggerFactory.getLogger(SysExceptionHandler.class);

    @ExceptionHandler({Exception.class})
    public SysResponse exceptionHandle(Exception e) {
        logger.error("未知异常 :{}", e.getMessage(), e);
        return SysResponseUtils.fail(SysErrorCode.UnknownException.getCode(), SysErrorCode.UnknownException.getMsg());
    }

    @ExceptionHandler({AppBizException.class})
    public SysResponse appBizExceptionHandler(AppBizException appBizException) {

        logger.error("系统异常 :{}", appBizException.getMessage());
        return SysResponseUtils.fail(appBizException.getCode(), appBizException.getMessage());
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public SysResponse httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e) {

        logger.error("HTTP REQUEST METHOD 异常 :{}", e.getMessage());
        return SysResponseUtils.fail(SysErrorCode.RequestMethodException.getCode(), SysErrorCode.RequestMethodException.getMsg());
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public SysResponse httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
        //请求入参异常，比如JSON字符串格式错误
        logger.error("HTTP REQUEST PARAMETER 异常 :{}", e.getMessage());
        return SysResponseUtils.fail(SysErrorCode.RequestParamException.getCode(), SysErrorCode.RequestParamException.getMsg());
    }
}
