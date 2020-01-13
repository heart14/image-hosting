package com.example.heart.imagehosting.sdk.smms.request.album;

import com.example.heart.imagehosting.sdk.smms.request.AbstractSmmsApiBaseRequest;

import java.util.Map;

/**
 * @ClassName: SmmsApiAlbumDeletionRequest
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/13 18:01
 * @Version: v1.0
 */
public class SmmsApiAlbumDeletionRequest extends AbstractSmmsApiBaseRequest {

    private static final long serialVersionUID = 3418715960164588742L;

    private String albumId;

    public SmmsApiAlbumDeletionRequest() {
    }

    public SmmsApiAlbumDeletionRequest(String albumId) {
        this.albumId = albumId;
    }

    @Override
    public String apiUri() {
        return "/albums/:album_id/delete".replace(":album_id", albumId);
    }

    @Override
    public String apiMethod() {
        return "get";
    }

    @Override
    public Map<String, Object> apiParams() {
        return null;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    @Override
    public String toString() {
        return "SmmsApiAlbumDeletionRequest{" +
                "albumId='" + albumId + '\'' +
                '}';
    }
}
