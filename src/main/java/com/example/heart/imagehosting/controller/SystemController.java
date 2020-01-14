package com.example.heart.imagehosting.controller;

import com.example.heart.imagehosting.entity.UserAuths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestBody UserAuths userAuths) {
        logger.info("{}", userAuths);
    }
}
