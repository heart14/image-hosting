package com.example.heart.imagehosting.sdk.smms.service;

import com.example.heart.imagehosting.exception.AppBizException;
import com.example.heart.imagehosting.sdk.smms.response.SmmsBaseResponse;

/**
 * @ClassName: SmmsApiUserService
 * @Description: sm.ms v2 api接口
 * @Author: jayhe
 * @Date: 2020/1/13 17:30
 * @Version: v1.0
 */
public interface SmmsApiUserService {

    /**
     * 获取SM.MS用户TOKEN
     *
     * @param username
     * @param password
     * @return
     * @throws AppBizException
     */
    SmmsBaseResponse getUserToken(String username, String password) throws AppBizException;

    /**
     * 获取SM.MS用户信息
     *
     * @param token
     * @return
     * @throws AppBizException
     */
    SmmsBaseResponse getUserProfile(String token) throws AppBizException;
}
