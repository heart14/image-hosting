package com.example.heart.imagehosting.exception;

/**
 * @ClassName: AppBizException
 * @Description: 自定义异常类
 * @Author: jayhe
 * @Date: 2019/11/6 10:01
 * @Version: v1.0
 */
public class AppBizException extends RuntimeException {

    private static final long serialVersionUID = -3150856162515609057L;

    private Integer code;

    public AppBizException(Integer code) {
        this.code = code;
    }

    public AppBizException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public AppBizException setCode(Integer code) {
        this.code = code;
        return this;
    }
}
