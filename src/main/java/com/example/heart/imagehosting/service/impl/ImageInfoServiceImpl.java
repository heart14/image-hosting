package com.example.heart.imagehosting.service.impl;

import com.example.heart.imagehosting.dao.ImageInfoDao;
import com.example.heart.imagehosting.entity.ImageInfo;
import com.example.heart.imagehosting.service.ImageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ImageInfoServiceImpl
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 15:30
 * @Version: v1.0
 */
@Service
public class ImageInfoServiceImpl implements ImageInfoService {

    @Autowired
    private ImageInfoDao imageInfoDao;

    @Override
    public ImageInfo saveImageInfo(ImageInfo imageInfo) {
        return imageInfoDao.save(imageInfo);
    }

    @Override
    public void removeImageInfoById(String id) {
        imageInfoDao.deleteById(id);
    }

    @Override
    public ImageInfo editImageInfo(ImageInfo imageInfo) {
        return imageInfoDao.save(imageInfo);
    }

    @Override
    public ImageInfo findImageInfoById(String id) {
        return imageInfoDao.findImageInfoById(id);
    }

    @Override
    public List<ImageInfo> findAllImageInfo() {
        return imageInfoDao.findAllByStatusAndUserId(1, "heartzz1");

    }
}