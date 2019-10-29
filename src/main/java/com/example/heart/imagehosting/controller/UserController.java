package com.example.heart.imagehosting.controller;

import com.example.heart.imagehosting.entity.UserInfo;
import com.example.heart.imagehosting.service.UserAuthsService;
import com.example.heart.imagehosting.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping(name = "/user")
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserAuthsService userAuthsService;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/edit/", method = RequestMethod.POST)
    public void editUserInfo(@RequestBody UserInfo userInfo) {

        logger.info("{}", userInfo);

    }
}
