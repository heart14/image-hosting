package com.example.heart.imagehosting.sdk.smms.service.impl;

import com.example.heart.imagehosting.sdk.smms.request.image.*;
import com.example.heart.imagehosting.sdk.smms.response.SmmsBaseResponse;
import com.example.heart.imagehosting.sdk.smms.service.SmmsApiImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @ClassName: SmmsApiImageServiceImpl
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/13 17:32
 * @Version: v1.0
 */
@Service
public class SmmsApiImageServiceImpl implements SmmsApiImageService {

    private static final Logger logger = LoggerFactory.getLogger(SmmsApiImageServiceImpl.class);

    @Override
    public SmmsBaseResponse clearIpBasedHistory() {
        logger.info("SMMS SDK :清除当前IP上传历史");
        SmmsApiImageClearIpHistoryRequest smmsApiImageClearIpHistoryRequest = new SmmsApiImageClearIpHistoryRequest();
        return smmsApiImageClearIpHistoryRequest.doRequest();
    }

    @Override
    public SmmsBaseResponse ipBasedHistory() {
        logger.info("SMMS SDK :查询当前IP上传历史");
        SmmsApiImageQueryIpHistoryRequest smmsApiImageQueryIpHistoryRequest = new SmmsApiImageQueryIpHistoryRequest();
        return smmsApiImageQueryIpHistoryRequest.doRequest();
    }

    @Override
    public SmmsBaseResponse imageDeletion(String hash) {
        logger.info("SMMS SDK :删除图片[hash = {}]", hash);
        SmmsApiImageDeletionRequest smmsApiImageDeletionRequest = new SmmsApiImageDeletionRequest(hash);
        return smmsApiImageDeletionRequest.doRequest();
    }

    @Override
    public SmmsBaseResponse uploadHistory() {
        logger.info("SMMS SDK :查询当前用户上传历史");
        SmmsApiImageQueryUploadHistoryRequest smmsApiImageQueryUploadHistoryRequest = new SmmsApiImageQueryUploadHistoryRequest();
        return smmsApiImageQueryUploadHistoryRequest.doRequest();
    }

    @Override
    public SmmsBaseResponse uploadImage(File smfile) {
        logger.info("SMMS SDK :上传文件[smfile = {}]", smfile);
        SmmsApiImageUploadRequest smmsApiImageUploadRequest = new SmmsApiImageUploadRequest(smfile);
        return smmsApiImageUploadRequest.doRequest();
    }
}
