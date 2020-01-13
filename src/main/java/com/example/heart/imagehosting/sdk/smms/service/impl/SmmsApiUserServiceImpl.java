package com.example.heart.imagehosting.sdk.smms.service.impl;

import com.example.heart.imagehosting.common.SysErrorCode;
import com.example.heart.imagehosting.exception.AppBizException;
import com.example.heart.imagehosting.sdk.smms.request.user.SmmsApiGetTokenReqeust;
import com.example.heart.imagehosting.sdk.smms.request.user.SmmsApiGetUserProfileRequest;
import com.example.heart.imagehosting.sdk.smms.response.SmmsBaseResponse;
import com.example.heart.imagehosting.sdk.smms.service.SmmsApiUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: SmmsApiUserServiceImpl
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/13 17:32
 * @Version: v1.0
 */
@Service
public class SmmsApiUserServiceImpl implements SmmsApiUserService {

    private final static Logger logger = LoggerFactory.getLogger(SmmsApiUserServiceImpl.class);

    @Override
    public SmmsBaseResponse getUserToken(String username, String password) throws AppBizException {
        if (StringUtils.isAnyBlank(username, password)) {
            logger.error("获取SM.MS用户Token参数异常 :{}", SysErrorCode.UnknownParamException.getMsg());
            throw new AppBizException(SysErrorCode.UnknownParamException.getCode(), SysErrorCode.UnknownParamException.getMsg());
        }
        SmmsApiGetTokenReqeust smmsApiGetTokenReqeust = new SmmsApiGetTokenReqeust(username, password);
        return smmsApiGetTokenReqeust.doRequest();
    }

    @Override
    public SmmsBaseResponse getUserProfile(String token) throws AppBizException {
        if (StringUtils.isBlank(token)) {
            logger.error("获取SM.MS用户Profile参数异常 :{}", SysErrorCode.UnknownParamException.getMsg());
            throw new AppBizException(SysErrorCode.UnknownParamException.getCode(), SysErrorCode.UnknownParamException.getMsg());
        }
        SmmsApiGetUserProfileRequest smmsApiGetUserProfileRequest = new SmmsApiGetUserProfileRequest();
        return smmsApiGetUserProfileRequest.doRequest();
    }
}
