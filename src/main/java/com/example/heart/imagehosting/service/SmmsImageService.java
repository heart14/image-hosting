package com.example.heart.imagehosting.service;

import com.example.heart.imagehosting.exception.AppBizException;
import com.example.heart.imagehosting.sdk.smms.entity.SmmsUploadResponseDTO;

import java.io.File;

/**
 * @ClassName: SmmsImageService
 * @Description: TODO
 * @Author: lwf14
 * @Date: 2020/1/13 21:56
 * @Version: v1.0
 */
public interface SmmsImageService {

    SmmsUploadResponseDTO smmsUploadImage(File smfile) throws AppBizException;
}
