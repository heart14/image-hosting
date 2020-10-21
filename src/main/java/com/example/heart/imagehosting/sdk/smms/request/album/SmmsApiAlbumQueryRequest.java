package com.example.heart.imagehosting.sdk.smms.request.album;

import com.example.heart.imagehosting.sdk.smms.request.AbstractSmmsApiBaseRequest;

import java.util.Map;

/**
 * @ClassName: SmmsApiAlbumQueryRequest
 * @Description: 获取所有相册
 * @Author: jayhe
 * @Date: 2020/1/13 18:15
 * @Version: v1.0
 */
public class SmmsApiAlbumQueryRequest extends AbstractSmmsApiBaseRequest {

    private static final long serialVersionUID = 4565933790140142168L;

    public SmmsApiAlbumQueryRequest() {
    }

    @Override
    public String apiUri() {
        return "/albums";
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
