package com.example.heart.imagehosting.service;

import com.example.heart.imagehosting.entity.ImageInfo;

import java.util.List;

/**
 * @ClassName: ImageInfoService
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 15:20
 * @Version: v1.0
 */
public interface ImageInfoService {

    /**
     * 增
     *
     * @param imageInfo
     * @return
     */
    ImageInfo saveImageInfo(ImageInfo imageInfo);

    /**
     * 删
     *
     * @param id
     */
    void removeImageInfoById(String id);

    /**
     * 改
     *
     * @param imageInfo
     * @return
     */
    ImageInfo editImageInfo(ImageInfo imageInfo);

    /**
     * 查
     *
     * @param id
     * @return
     */
    ImageInfo findImageInfoById(String id);

    /**
     * 查
     *
     * @return
     */
    List<ImageInfo> findAllImageInfo();
}
