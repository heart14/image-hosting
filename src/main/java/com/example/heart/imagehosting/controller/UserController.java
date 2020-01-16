package com.example.heart.imagehosting.controller;

import com.example.heart.imagehosting.domain.SysResponse;
import com.example.heart.imagehosting.service.UserInfoService;
import com.example.heart.imagehosting.utils.SysResponseUtils;
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

        return SysResponseUtils.success();
    }
}

