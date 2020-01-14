package com.example.heart.imagehosting.service.impl;

import com.example.heart.imagehosting.entity.ImageInfo;
import com.example.heart.imagehosting.exception.AppBizException;
import com.example.heart.imagehosting.sdk.smms.entity.SmmsUploadResponseDTO;
import com.example.heart.imagehosting.service.ImageInfoService;
import com.example.heart.imagehosting.service.ImageService;
import com.example.heart.imagehosting.service.SmmsImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @ClassName: ImageServiceImpl
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/14 10:11
 * @Version: v1.0
 */
@Service
public class ImageServiceImpl implements ImageService {

    private static final Logger logger = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Autowired
    private ImageInfoService imageInfoService;

    @Autowired
    private SmmsImageService smmsImageService;

    @Override
    public SmmsUploadResponseDTO uploadImage(File file, String userId) throws AppBizException {
        logger.info("图片上传");
        SmmsUploadResponseDTO smmsUploadResponseDTO = smmsImageService.smmsUploadImage(file);
        if (smmsUploadResponseDTO.getSuccess()) {
            ImageInfo imageInfo = new ImageInfo(smmsUploadResponseDTO);
            imageInfo.setUserId(userId);
            imageInfoService.saveImageInfo(imageInfo);
            logger.info("图片上传成功！图片信息保存完成！");
        } else {
            logger.info("图片上传失败！");
        }
        return smmsUploadResponseDTO;
    }
}
