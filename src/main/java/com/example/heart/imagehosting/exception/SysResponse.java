package com.example.heart.imagehosting.exception;

/**
 * @ClassName: SysResponse
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 17:36
 * @Version: v1.0
 */
public class SysResponse {

    private Integer state;

    private Integer errCode;

    private String errMessage;

    private Object data;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SysResponse{" +
                "state=" + state +
                ", errCode=" + errCode +
                ", errMessage='" + errMessage + '\'' +
                ", data=" + data +
                '}';
    }
}
