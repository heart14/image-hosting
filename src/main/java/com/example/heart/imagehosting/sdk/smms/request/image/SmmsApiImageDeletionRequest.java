package com.example.heart.imagehosting.sdk.smms.request.image;

import com.example.heart.imagehosting.sdk.smms.request.AbstractSmmsApiBaseRequest;

import java.util.Map;

/**
 * @ClassName: SmmsApiImageDeletionRequest
 * @Description: TODO
 * @Author: lwf14
 * @Date: 2020/1/13 21:06
 * @Version: v1.0
 */
public class SmmsApiImageDeletionRequest extends AbstractSmmsApiBaseRequest {

    private static final long serialVersionUID = 151013499421653491L;

    private String hash;

    public SmmsApiImageDeletionRequest() {
    }

    public SmmsApiImageDeletionRequest(String hash) {
        this.hash = hash;
    }

    @Override
    public String apiUri() {
        return "/delete/:hash".replace(":hash", hash);
    }

    @Override
    public String apiMethod() {
        return "get";
    }

    @Override
    public Map<String, Object> apiParams() {
        return null;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "SmmsApiImageDeletionRequest{" +
                "hash='" + hash + '\'' +
                '}';
    }
}
