package com.example.heart.imagehosting.dao;

import com.example.heart.imagehosting.entity.ImgHosting;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @ClassName: ImgHostingDao
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 15:27
 * @Version: v1.0
 */
public interface ImgHostingDao extends PagingAndSortingRepository<ImgHosting, String> {
}
