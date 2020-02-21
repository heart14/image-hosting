package com.example.heart.imagehosting.service.impl;

import com.example.heart.imagehosting.dao.UserInfoDao;
import com.example.heart.imagehosting.entity.UserInfo;
import com.example.heart.imagehosting.service.UserInfoService;
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

    private final UserInfoDao userInfoDao;

    public UserInfoServiceImpl(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    @Override
    public UserInfo saveUserInfo(UserInfo userInfo) {
        return userInfoDao.save(userInfo);
    }

    @Override
    public void removeUserInfoById(long userId) {
        userInfoDao.deleteById(userId);
    }

    @Override
    public UserInfo editUserInfo(UserInfo userInfo) {
        return userInfoDao.save(userInfo);
    }

    @Override
    public UserInfo findUserInfoById(long userId) {
        return userInfoDao.findById(userId).orElse(null);
    }

    @Override
    public List<UserInfo> findAllUserInfo() {
        return null;
    }
}
