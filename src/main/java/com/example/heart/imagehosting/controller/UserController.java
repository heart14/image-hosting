package com.example.heart.imagehosting.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {
        logger.info("Image-Hosting project test.");
    }

}
