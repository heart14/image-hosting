package com.example.heart.imagehosting.sdk.smms.request.album;

import com.example.heart.imagehosting.sdk.smms.request.AbstractSmmsApiBaseRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: SmmsApiAlbumEditRequest
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/13 17:56
 * @Version: v1.0
 */
public class SmmsApiAlbumEditRequest extends AbstractSmmsApiBaseRequest {

    private static final long serialVersionUID = 8293328990677492540L;

    private String albumId;

    private String add;

    private String remove;

    public SmmsApiAlbumEditRequest() {
    }

    public SmmsApiAlbumEditRequest(String albumId, String add, String remove) {
        this.albumId = albumId;
        this.add = add;
        this.remove = remove;
    }

    @Override
    public String apiUri() {
        return "/albums/:album_id/item".replace(":album_id", albumId);
    }

    @Override
    public String apiMethod() {
        return "get";
    }

    @Override
    public Map<String, Object> apiParams() {

        Map<String, Object> map = new HashMap<>(2);
        map.put("add", add);
        map.put("remove", remove);
        return map;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getRemove() {
        return remove;
    }

    public void setRemove(String remove) {
        this.remove = remove;
    }

    @Override
    public String toString() {
        return "SmmsApiAlbumEditRequest{" +
                "albumId='" + albumId + '\'' +
                ", add='" + add + '\'' +
                ", remove='" + remove + '\'' +
                '}';
    }
}
