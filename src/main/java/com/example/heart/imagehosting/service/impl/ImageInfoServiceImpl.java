package com.example.heart.imagehosting.service.impl;

import com.example.heart.imagehosting.dao.ImageInfoDao;
import com.example.heart.imagehosting.entity.ImageInfo;
import com.example.heart.imagehosting.service.ImageInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
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

    private final ImageInfoDao imageInfoDao;

    public ImageInfoServiceImpl(ImageInfoDao imageInfoDao) {
        this.imageInfoDao = imageInfoDao;
    }

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

    @Override
    public Page<ImageInfo> findImageInfoPage(String imageName, Integer status, String userId, Pageable pageable) {

        Specification<ImageInfo> specification = (Specification<ImageInfo>) (root, criteriaQuery, criteriaBuilder) -> {

            List<Predicate> list = new ArrayList<>();
            if (!StringUtils.isBlank(imageName)) {
                list.add(criteriaBuilder.like(root.get("filename").as(String.class), "%" + imageName + "%"));
            }
            if (status != null) {
                list.add(criteriaBuilder.equal(root.get("status").as(Integer.class), status));
            }
            if (!StringUtils.isBlank(userId)) {
                list.add(criteriaBuilder.equal(root.get("userId").as(String.class), userId));
            }
            return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
        };

        return imageInfoDao.findAll(specification, pageable);
    }

    @Override
    public Page<ImageInfo> findAllImageInfoPage(Pageable pageable) {
        return imageInfoDao.findAll(pageable);
    }
}
