package com.example.heart.imagehosting.controller;

import com.example.heart.imagehosting.domain.SysResponse;
import com.example.heart.imagehosting.service.UserInfoService;
import com.example.heart.imagehosting.utils.SysResponseUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 15:34
 * @Version: v1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {
        logger.info("Image-Hosting project test.");
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public SysResponse findUserInfo() {
        logger.info("/user/info 需要登录才能访问");
        return SysResponseUtils.success();
    }

    @RequestMapping(value = "/all", method = RequestMethod.POST)
    @RequiresRoles({"admin"})
    public SysResponse findAllUsers() {
        logger.info("/user/all 需要管理员admin角色才能访问");
        return SysResponseUtils.success();
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @RequiresPermissions({"user:edit"})
    public SysResponse editUser() {
        logger.info("/user/edit 需要user:edit权限才能访问");
        return SysResponseUtils.success();
    }
}

