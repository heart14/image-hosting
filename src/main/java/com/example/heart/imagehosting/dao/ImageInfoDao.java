package com.example.heart.imagehosting.dao;

import com.example.heart.imagehosting.entity.ImageInfo;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @ClassName: ImageInfoDao
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 15:27
 * @Version: v1.0
 */
public interface ImageInfoDao extends PagingAndSortingRepository<ImageInfo, String> {
}
