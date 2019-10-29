package com.example.heart.imagehosting.service.impl;

import com.example.heart.imagehosting.dao.UserInfoDao;
import com.example.heart.imagehosting.entity.UserInfo;
import com.example.heart.imagehosting.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: UserInfoServiceImpl
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 15:26
 * @Version: v1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo saveUserInfo(UserInfo userInfo) {
        return userInfoDao.save(userInfo);
    }

    @Override
    public void removeUserInfoById(String userId) {
        userInfoDao.deleteById(userId);
    }

    @Override
    public UserInfo editUserInfo(UserInfo userInfo) {
        return userInfoDao.save(userInfo);
    }

    @Override
    public UserInfo findUserInfoById(String userId) {
        return userInfoDao.findById(userId).isPresent() ? userInfoDao.findById(userId).get() : null;
    }

    @Override
    public List<UserInfo> findAllUserInfo() {
        return null;
    }
}
