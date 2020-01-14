package com.example.heart.imagehosting.service.impl;

import com.example.heart.imagehosting.exception.AppBizException;
import com.example.heart.imagehosting.sdk.smms.entity.SmmsUploadResponseDTO;
import com.example.heart.imagehosting.sdk.smms.response.SmmsBaseResponse;
import com.example.heart.imagehosting.sdk.smms.service.SmmsApiImageService;
import com.example.heart.imagehosting.service.SmmsImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @ClassName: SmmsImageServiceImpl
 * @Description: TODO
 * @Author: lwf14
 * @Date: 2020/1/13 21:58
 * @Version: v1.0
 */
@Service
public class SmmsImageServiceImpl implements SmmsImageService {

    private static final Logger logger = LoggerFactory.getLogger(SmmsImageServiceImpl.class);

    @Autowired
    private SmmsApiImageService smmsApiImageService;

    @Override
    public SmmsUploadResponseDTO smmsUploadImage(File smfile) throws AppBizException {
        SmmsBaseResponse smmsBaseResponse = smmsApiImageService.uploadImage(smfile);
        logger.info("图片上传 :{}", smmsBaseResponse);
        return new SmmsUploadResponseDTO(smmsBaseResponse);
    }
}
