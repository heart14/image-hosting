package com.example.heart.imagehosting.common;

/**
 * @ClassName: ErrorCodeEnums
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 17:27
 * @Version: v1.0
 */
public enum SysErrorCode {

    /**
     * 系统异常
     */
    SystemException(1002, "系统异常"),

    /**
     * 未知异常
     */
    UnknownException(1003, "未知异常"),

    /**
     * 请求方式错误
     */
    RequestMethodException(1004, "请求方式错误[GET|POST]"),

    /**
     * 请求参数错误
     */
    RequestParamException(1005, "请求参数错误[SYNTAX]"),

    /**
     * 请求参数错误
     */
    UnknownParamException(1006, "请求参数错误[UNKNOWN]"),

    /**
     * 请求参数错误
     */
    InvalidParamException(1007, "请求参数错误[INVALID]"),

    /**
     * 服务异常
     */
    ServiceException(1008, "服务异常"),

    /**
     * 数据库操作异常
     */
    DBException(1009, "数据库异常"),

    /**
     * HTTP请求异常
     */
    HttpException(1010, "HTTP请求异常"),

    /**
     * 成功
     */
    SUCCESS(1000, "成功");

    private Integer code;

    private String msg;

    SysErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public SysErrorCode setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public SysErrorCode setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
