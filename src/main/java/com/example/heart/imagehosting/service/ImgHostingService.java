package com.example.heart.imagehosting.service;

import com.example.heart.imagehosting.entity.ImgHosting;

import java.util.List;

/**
 * @ClassName: ImgHostingService
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 15:20
 * @Version: v1.0
 */
public interface ImgHostingService {

    /**
     * 增
     *
     * @param imgHosting
     * @return
     */
    ImgHosting saveImgHosting(ImgHosting imgHosting);

    /**
     * 删
     *
     * @param id
     */
    void removeImgHostingById(String id);

    /**
     * 改
     *
     * @param imgHosting
     * @return
     */
    ImgHosting editImgHosting(ImgHosting imgHosting);

    /**
     * 查
     *
     * @param id
     * @return
     */
    ImgHosting findImgHostingById(String id);

    /**
     * 查
     *
     * @return
     */
    List<ImgHosting> findAllImgHosting();
}
