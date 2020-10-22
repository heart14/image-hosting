package com.example.heart.imagehosting.service;

import com.example.heart.imagehosting.entity.UserInfo;

import java.util.List;

/**
 * @ClassName: UserInfoService
 * @Description: 用户信息服务类
 * @Author: jayhe
 * @Date: 2019/10/29 15:20
 * @Version: v1.0
 */
public interface UserInfoService {

    /**
     * 增
     *
     * @param userInfo
     * @return
     */
    UserInfo saveUserInfo(UserInfo userInfo);

    /**
     * 删
     *
     * @param userId
     */
    void removeUserInfoById(long userId);

    /**
     * 改
     *
     * @param userInfo
     * @return
     */
    UserInfo editUserInfo(UserInfo userInfo);

    /**
     * 查
     *
     * @param userId
     * @return
     */
    UserInfo findUserInfoById(long userId);

    /**
     * 查
     *
     * @return
     */
    List<UserInfo> findAllUserInfo();
}
