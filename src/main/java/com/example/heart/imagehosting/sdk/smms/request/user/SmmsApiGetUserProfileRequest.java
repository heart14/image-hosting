package com.example.heart.imagehosting.sdk.smms.request.user;

import com.example.heart.imagehosting.sdk.smms.request.AbstractSmmsApiBaseRequest;

import java.util.Map;

/**
 * @ClassName: SmmsApiGetUserProfileRequest
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/13 17:05
 * @Version: v1.0
 */
public class SmmsApiGetUserProfileRequest extends AbstractSmmsApiBaseRequest {

    private static final long serialVersionUID = 5893470682167401397L;

    public SmmsApiGetUserProfileRequest() {
    }

    @Override
    public String apiUri() {
        return "/profile";
    }

    @Override
    public String apiMethod() {
        return "post";
    }

    @Override
    public Map<String, Object> apiParams() {
        return null;
    }

}
