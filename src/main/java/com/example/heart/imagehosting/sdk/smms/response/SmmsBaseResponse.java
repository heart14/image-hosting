package com.example.heart.imagehosting.sdk.smms.response;

/**
 * @ClassName: SmmsBaseResponse
 * @Description: sm.ms v2 api基础响应实体类
 * @Author: jayhe
 * @Date: 2020/1/8 17:34
 * @Version: v1.0
 */
public class SmmsBaseResponse {

    private boolean success;

    private String code;

    private String message;

    private String data;

    private String RequestId;

    public SmmsBaseResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRequestId() {
        return RequestId;
    }

    public void setRequestId(String requestId) {
        RequestId = requestId;
    }

    @Override
    public String toString() {
        return "SmmsBaseResponse{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", RequestId='" + RequestId + '\'' +
                '}';
    }
}
