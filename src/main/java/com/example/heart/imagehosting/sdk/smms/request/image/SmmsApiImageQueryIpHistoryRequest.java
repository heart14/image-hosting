package com.example.heart.imagehosting.sdk.smms.request.image;

import com.example.heart.imagehosting.sdk.smms.request.AbstractSmmsApiBaseRequest;

import java.util.Map;

/**
 * @ClassName: SmmsApiImageQueryIpHistoryRequest
 * @Description: 查询基于IP的临时上传历史
 * @Author: lwf14
 * @Date: 2020/1/13 21:04
 * @Version: v1.0
 */
public class SmmsApiImageQueryIpHistoryRequest extends AbstractSmmsApiBaseRequest {

    private static final long serialVersionUID = 5196506629166248983L;

    public SmmsApiImageQueryIpHistoryRequest() {
    }

    @Override
    public String apiUri() {
        return "/history";
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
