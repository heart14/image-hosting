package com.example.heart.imagehosting.sdk.smms.request.image;

import com.example.heart.imagehosting.sdk.smms.request.AbstractSmmsApiBaseRequest;

import java.util.Map;

/**
 * @ClassName: SmmsApiImageQueryUploadHistoryRequest
 * @Description: TODO
 * @Author: lwf14
 * @Date: 2020/1/13 21:08
 * @Version: v1.0
 */
public class SmmsApiImageQueryUploadHistoryRequest extends AbstractSmmsApiBaseRequest {

    private static final long serialVersionUID = 6993312377616851602L;

    public SmmsApiImageQueryUploadHistoryRequest() {
    }

    @Override
    public String apiUri() {
        return "/upload_history";
    }

    @Override
    public String apiMethod() {
        return "get";
    }

    @Override
    public Map<String, Object> apiParams() {
        return null;
    }
}
