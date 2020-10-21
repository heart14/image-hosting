package com.example.heart.imagehosting.sdk.smms.request.album;

import com.example.heart.imagehosting.sdk.smms.request.AbstractSmmsApiBaseRequest;

import java.util.Map;

/**
 * @ClassName: SmmsApiAlbumItemsQueryRequest
 * @Description: 查询相册内所有图片
 * @Author: jayhe
 * @Date: 2020/1/13 18:12
 * @Version: v1.0
 */
public class SmmsApiAlbumItemsQueryRequest extends AbstractSmmsApiBaseRequest {

    private static final long serialVersionUID = 4565933790140142168L;

    private String albumId;

    public SmmsApiAlbumItemsQueryRequest() {
    }

    public SmmsApiAlbumItemsQueryRequest(String albumId) {
        this.albumId = albumId;
    }

    @Override
    public String apiUri() {
        return "/albums/:album_id".replace(":album_id", albumId);
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
        return "SmmsApiAlbumItemsQueryRequest{" +
                "albumId='" + albumId + '\'' +
                '}';
    }
}
