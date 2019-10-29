package com.example.heart.imagehosting.exception;

/**
 * @ClassName: SysResponse
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 17:36
 * @Version: v1.0
 */
public class SysResponse<T> {

    private Integer errCode;

    private String errMessage;

    private T data;

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SysResponse{" +
                "errCode=" + errCode +
                ", errMessage='" + errMessage + '\'' +
                ", data=" + data +
                '}';
    }
}
