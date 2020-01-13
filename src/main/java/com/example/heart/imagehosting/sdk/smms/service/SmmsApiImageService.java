package com.example.heart.imagehosting.sdk.smms.service;

import com.example.heart.imagehosting.sdk.smms.response.SmmsBaseResponse;

import java.io.File;

/**
 * @ClassName: SmmsApiImageService
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/13 17:30
 * @Version: v1.0
 */
public interface SmmsApiImageService {

    /**
     * 清除基于IP的临时上传历史记录
     *
     * @return
     */
    SmmsBaseResponse clearIpBasedHistory();

    /**
     * 基于IP的临时上传历史
     *
     * @return
     */
    SmmsBaseResponse ipBasedHistory();

    /**
     * 图片删除
     *
     * @param hash
     * @return
     */
    SmmsBaseResponse imageDeletion(String hash);

    /**
     * 图片上传历史
     *
     * @return
     */
    SmmsBaseResponse uploadHistory();

    /**
     * 图片上传
     *
     * @param smfile
     * @return
     */
    SmmsBaseResponse uploadImage(File smfile);
}
