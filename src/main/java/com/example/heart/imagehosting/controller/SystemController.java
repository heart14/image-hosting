package com.example.heart.imagehosting.controller;

import com.example.heart.imagehosting.common.SysConstants;
import com.example.heart.imagehosting.common.SysErrorCode;
import com.example.heart.imagehosting.domain.SysResponse;
import com.example.heart.imagehosting.entity.UserAuths;
import com.example.heart.imagehosting.service.UserAuthsService;
import com.example.heart.imagehosting.utils.SnowFlake;
import com.example.heart.imagehosting.utils.SysResponseUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
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
     * @param userAuths
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public SysResponse login(@RequestBody UserAuths userAuths) {
        logger.info("用户登录 :{}", userAuths);
        return SysResponseUtils.success();
    }

    /**
     * 用户登出接口
     */

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout() {
        logger.info("用户登出 :{}", "");
        SecurityUtils.getSubject().logout();
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public SysResponse reg(){
        logger.info("用户注册 :{}", "");
        UserAuths userAuths = new UserAuths();
        userAuths.setId(SnowFlake.nextId());
        userAuths.setUserId(SnowFlake.nextId());
        userAuths.setIdentityType(SysConstants.IDENTITY_TYPE_ACCOUNT);
        userAuths.setIdentifier("heartzz1");
        userAuths.setCredential("1234566");
        userAuths.setUserState(SysConstants.STATUS_TRUE);
        userAuths.setCreateTime(new Date());

        //密码加密存储
        userAuths.setCredential(String.valueOf(new Md5Hash(new Md5Hash(userAuths.getCredential(), userAuths.buildUserSalt()))));

        UserAuths saveUserAuths = userAuthsService.saveUserAuths(userAuths);
        return SysResponseUtils.success(saveUserAuths);
    }

    /**
     * 无权限用户操作
     *
     * @return
     */
    @RequestMapping(value = "/unauth", method = RequestMethod.GET)
    public SysResponse unAuth() {
        logger.warn("用户无操作权限");
        return SysResponseUtils.fail(SysErrorCode.UnAuthorizedException.getCode(), SysErrorCode.UnAuthorizedException.getMsg());
    }

}
