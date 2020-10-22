package com.example.heart.imagehosting.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.heart.imagehosting.common.SysErrorCode;
import com.example.heart.imagehosting.domain.SysResponse;
import com.example.heart.imagehosting.exception.AppBizException;
import com.example.heart.imagehosting.sdk.smms.entity.SmmsUploadResponseDTO;
import com.example.heart.imagehosting.service.ImageService;
import com.example.heart.imagehosting.utils.SysResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName: ImageController
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 15:45
 * @Version: v1.0
 */
@RestController
@RequestMapping("/image")
public class ImageController {

    public static final Logger logger = LoggerFactory.getLogger(ImageController.class);

    @Value("${IMG_STORE_PATH}")
    String imgPath;

    @Value("${UPLOAD_API_URL}")
    String uploadApiUrl;

    @Value("${HISTORY_API_URL}")
    String historyApiUrl;

    @Value("${CLEAR_API_URL}")
    String clearApiUrl;

    private final ImageService imageService;


    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    /**
     * 图片上传
     *
     * @param multipartFiles
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public SysResponse imgUpload(@RequestParam("multipartFiles") MultipartFile[] multipartFiles) {
        logger.info("开始进行图片上传");
        if (multipartFiles == null || multipartFiles.length == 0) {
            logger.error("图片不存在");
            return SysResponseUtils.fail(SysErrorCode.UnknownParamException.getCode(), SysErrorCode.UnknownParamException.getMsg());
        }
        return SysResponseUtils.success();
    }

}
