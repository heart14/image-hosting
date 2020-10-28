package com.example.heart.imagehosting.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.heart.imagehosting.common.SysConstants;
import com.example.heart.imagehosting.common.SysErrorCode;
import com.example.heart.imagehosting.domain.SysRequest;
import com.example.heart.imagehosting.domain.SysResponse;
import com.example.heart.imagehosting.domain.UserAuthsVO;
import com.example.heart.imagehosting.entity.UserAuths;
import com.example.heart.imagehosting.service.UserAuthsService;
import com.example.heart.imagehosting.utils.SnowFlake;
import com.example.heart.imagehosting.utils.SysResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName: SystemController
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 15:42
 * @Version: v1.0
 */
@RestController
@RequestMapping("/system")
public class SystemController {

    public static final Logger logger = LoggerFactory.getLogger(SystemController.class);

    @Autowired
    private UserAuthsService userAuthsService;

    /**
     * 用户登录接口
     *
     * @param userAuthsVO
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public SysResponse login(@RequestBody UserAuthsVO userAuthsVO) {
        logger.info("用户登录 :{}", userAuthsVO);
        //TODO 校验验证码

        //登录

        return SysResponseUtils.success();
    }

    /**
     * 用户登出接口
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout() {

    }

    /**
     * 用户注册接口
     *
     * @return
     */
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public SysResponse reg(@RequestBody UserAuthsVO userAuthsVO) {
        logger.info("用户注册 :{}", userAuthsVO);

        //TODO 验证码校验

        //组装账号数据
        UserAuths userAuths = new UserAuths();
        userAuths.setId(SnowFlake.nextId());
        userAuths.setUserId(SnowFlake.nextId());
        userAuths.setIdentityType(userAuthsVO.getIdentityType());
        userAuths.setIdentifier(userAuthsVO.getIdentifier());
        userAuths.setCredential(userAuthsVO.getCredential());
        userAuths.setUserState(SysConstants.STATUS_TRUE);
        userAuths.setCreateTime(new Date());

        //保存账号数据
        UserAuths saveUserAuths = userAuthsService.saveUserAuths(userAuths);
        return SysResponseUtils.success(saveUserAuths);
    }

    /**
     * 未认证
     *
     * @return
     */
    @RequestMapping(value = "/unauthc", method = RequestMethod.GET)
    public SysResponse unAuthenticated() {
        return SysResponseUtils.fail(SysErrorCode.UnAuthenticatedException.getCode(), SysErrorCode.UnAuthenticatedException.getMsg());
    }

}
