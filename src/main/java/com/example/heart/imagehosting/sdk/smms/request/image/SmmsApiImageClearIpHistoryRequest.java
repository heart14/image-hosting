package com.example.heart.imagehosting.sdk.smms.request.image;

import com.example.heart.imagehosting.sdk.smms.request.AbstractSmmsApiBaseRequest;

import java.util.Map;

/**
 * @ClassName: SmmsApiImageClearIpHistoryRequest
 * @Description: 清除基于IP的临时上传历史记录
 * @Author: lwf14
 * @Date: 2020/1/13 20:59
 * @Version: v1.0
 */
public class SmmsApiImageClearIpHistoryRequest extends AbstractSmmsApiBaseRequest {

    private static final long serialVersionUID = 4982390888925298370L;

    public SmmsApiImageClearIpHistoryRequest() {
    }

    @Override
    public String apiUri() {
        return "/clear";
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
