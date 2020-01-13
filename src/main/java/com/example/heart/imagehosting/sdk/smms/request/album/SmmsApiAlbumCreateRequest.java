package com.example.heart.imagehosting.sdk.smms.request.album;

import com.example.heart.imagehosting.sdk.smms.request.AbstractSmmsApiBaseRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: SmmsApiAlbumCreateRequest
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/13 18:04
 * @Version: v1.0
 */
public class SmmsApiAlbumCreateRequest extends AbstractSmmsApiBaseRequest {

    private static final long serialVersionUID = 683407005985663586L;

    private String albumName;

    private String albumDesc;

    public SmmsApiAlbumCreateRequest() {
    }

    public SmmsApiAlbumCreateRequest(String albumName, String albumDesc) {
        this.albumName = albumName;
        this.albumDesc = albumDesc;
    }

    @Override
    public String apiUri() {
        return "/albums";
    }

    @Override
    public String apiMethod() {
        return "post";
    }

    @Override
    public Map<String, Object> apiParams() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("album_name", albumName);
        map.put("album_description", albumDesc);
        return map;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumDesc() {
        return albumDesc;
    }

    public void setAlbumDesc(String albumDesc) {
        this.albumDesc = albumDesc;
    }

    @Override
    public String toString() {
        return "SmmsApiAlbumCreateRequest{" +
                "albumName='" + albumName + '\'' +
                ", albumDesc='" + albumDesc + '\'' +
                '}';
    }
}
