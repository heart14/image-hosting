package com.example.heart.imagehosting.sdk.smms.service.impl;

import com.example.heart.imagehosting.sdk.smms.request.album.*;
import com.example.heart.imagehosting.sdk.smms.response.SmmsBaseResponse;
import com.example.heart.imagehosting.sdk.smms.service.SmmsApiAlbumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: SmmsApiAlbumServiceImpl
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/13 17:32
 * @Version: v1.0
 */
@Service
public class SmmsApiAlbumServiceImpl implements SmmsApiAlbumService {

    private static final Logger logger = LoggerFactory.getLogger(SmmsApiAlbumServiceImpl.class);


    @Override
    public SmmsBaseResponse editAlbumItem(String albumId, String add, String remove) {
        logger.info("SMMS SDK :从相册中添加/移除图片[albumId = {},add = {},remove = {}]", albumId, add, remove);
        return new SmmsApiAlbumEditRequest(albumId, add, remove).doRequest();
    }

    @Override
    public SmmsBaseResponse deleteAlbum(String albumId) {
        logger.info("SMMS SDK :删除相册[albumId = {}]", albumId);
        return new SmmsApiAlbumDeletionRequest(albumId).doRequest();
    }

    @Override
    public SmmsBaseResponse createAlbum(String albumName, String albumDescription) {
        logger.info("SMMS SDK :创建相册[albumName = {},albumDesc = {}]", albumName, albumDescription);
        return new SmmsApiAlbumCreateRequest(albumName, albumDescription).doRequest();
    }

    @Override
    public SmmsBaseResponse getAllAlbumItems(String albumId) {
        logger.info("SMMS SDK :获取某相册下所有图片[albumId = {}]", albumId);
        return new SmmsApiAlbumItemsQueryRequest(albumId).doRequest();
    }

    @Override
    public SmmsBaseResponse getAllAlbum() {
        logger.info("SMMS SDK :获取所有相册");
        return new SmmsApiAlbumQueryRequest().doRequest();
    }
}
