package com.example.heart.imagehosting.common;

/**
 * @ClassName: ErrorCodeEnums
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 17:27
 * @Version: v1.0
 */
public enum ErrorCodeEnums {

    /**
     * 成功，ErrorCode :0000
     */
    SUCCESS(64640, "成功"),

    /**
     * 系统异常，ErrorCode :64641
     */
    SystemException(64641, "系统异常"),

    /**
     * 未知异常，ErrorCode :64642
     */
    UnknownException(64642, "未知异常"),

    /**
     * 服务异常，ErrorCode :64643
     */
    ServiceException(64643, "服务异常"),

    /**
     * 数据库操作异常，ErrorCode :64644
     */
    DBException(64644, "数据库操作异常");

    private Integer code;

    private String msg;

    ErrorCodeEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public ErrorCodeEnums setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ErrorCodeEnums setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
