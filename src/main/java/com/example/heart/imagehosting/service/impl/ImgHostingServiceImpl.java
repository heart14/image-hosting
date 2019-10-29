package com.example.heart.imagehosting.service.impl;

import com.example.heart.imagehosting.dao.ImgHostingDao;
import com.example.heart.imagehosting.entity.ImgHosting;
import com.example.heart.imagehosting.service.ImgHostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ImgHostingServiceImpl
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 15:30
 * @Version: v1.0
 */
@Service
public class ImgHostingServiceImpl implements ImgHostingService {

    @Autowired
    private ImgHostingDao imgHostingDao;

    @Override
    public ImgHosting saveImgHosting(ImgHosting imgHosting) {
        return imgHostingDao.save(imgHosting);
    }

    @Override
    public void removeImgHostingById(String id) {
        imgHostingDao.deleteById(id);
    }

    @Override
    public ImgHosting editImgHosting(ImgHosting imgHosting) {
        return imgHostingDao.save(imgHosting);
    }

    @Override
    public ImgHosting findImgHostingById(String id) {
        return imgHostingDao.findById(id).isPresent() ? imgHostingDao.findById(id).get() : null;
    }

    @Override
    public List<ImgHosting> findAllImgHosting() {
        return null;
    }
}
