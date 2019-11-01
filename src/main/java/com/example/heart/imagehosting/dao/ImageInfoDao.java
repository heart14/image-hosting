package com.example.heart.imagehosting.dao;

import com.example.heart.imagehosting.entity.ImageInfo;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @ClassName: ImageInfoDao
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 15:27
 * @Version: v1.0
 */
public interface ImageInfoDao extends PagingAndSortingRepository<ImageInfo, String> {

    /**
     * 根据图片id 查询图片
     *
     * @param id
     * @return
     */
    ImageInfo findImageInfoById(String id);

    /**
     * 根据userId 和 status查询图片
     *
     * @param status
     * @param userId
     * @return
     */
    List<ImageInfo> findAllByStatusAndUserId(Integer status, String userId);
}
