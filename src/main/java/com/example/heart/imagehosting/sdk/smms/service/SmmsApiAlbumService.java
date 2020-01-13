package com.example.heart.imagehosting.sdk.smms.service;

import com.example.heart.imagehosting.sdk.smms.response.SmmsBaseResponse;

/**
 * @ClassName: SmmsApiAlbumService
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/13 17:31
 * @Version: v1.0
 */
public interface SmmsApiAlbumService {

    /**
     * 从相册中添加/移除图片
     *
     * @param albumId
     * @param add
     * @param remove
     * @return
     */
    SmmsBaseResponse editAlbumItem(String albumId, String add, String remove);

    /**
     * 删除相册
     *
     * @param albumId
     * @return
     */
    SmmsBaseResponse deleteAlbum(String albumId);

    /**
     * 新建相册
     *
     * @param albumName
     * @param albumDescription
     * @return
     */
    SmmsBaseResponse createAlbum(String albumName, String albumDescription);

    /**
     * 获取相册内所有图片
     *
     * @param albumId
     * @return
     */
    SmmsBaseResponse getAllAlbumItems(String albumId);

    /**
     * 获取所有相册
     *
     * @return
     */
    SmmsBaseResponse getAllAlbum();
}
