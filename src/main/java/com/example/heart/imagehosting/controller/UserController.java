package com.example.heart.imagehosting.controller;

import com.example.heart.imagehosting.common.SysConstants;
import com.example.heart.imagehosting.domain.SysResponse;
import com.example.heart.imagehosting.entity.UserAuths;
import com.example.heart.imagehosting.entity.UserInfo;
import com.example.heart.imagehosting.service.UserInfoService;
import com.example.heart.imagehosting.utils.SysResponseUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

        Subject subject = SecurityUtils.getSubject();
//        PrincipalCollection previousPrincipals = subject.getPreviousPrincipals();
//        Object principal = subject.getPrincipal();
//        PrincipalCollection principals = subject.getPrincipals();
//
//        System.out.println("----subject----");
//        System.out.println("previousPrincipals :" + previousPrincipals);
//        System.out.println("principal :" + principal);
//        System.out.println("principals :" + principals);
//        System.out.println("--------");

        Session session = subject.getSession();
//        Serializable id = session.getId();
//        String host = session.getHost();
//        Collection<Object> attributeKeys = session.getAttributeKeys();
//        Date startTimestamp = session.getStartTimestamp();
//        Date lastAccessTime = session.getLastAccessTime();
//        long timeout = session.getTimeout();
//        System.out.println("----session----");
//        System.out.println("id :" + id);
//        System.out.println("host :" + host);
//        System.out.println("startTimestamp :" + startTimestamp);
//        System.out.println("lastAccessTime :" + lastAccessTime);
//        System.out.println("timeout :" + timeout);
//        if (attributeKeys != null && attributeKeys.size() > 0) {
//            for (Object attributeKey : attributeKeys) {
//                System.out.println("attributeKey :" + attributeKey);
//                System.out.println("session.getAttribute(attributeKey) :" + session.getAttribute(attributeKey));
//            }
//        }
//        System.out.println("--------");

        UserInfo userInfoById = userInfoService.findUserInfoById(((UserAuths) session.getAttribute(SysConstants.SHIRO_SUBJECT_USER_KEY)).getUserId());
        return SysResponseUtils.success(userInfoById);
    }

    @RequestMapping(value = "/all", method = RequestMethod.POST)
    @RequiresRoles({"admin"})
    public SysResponse findAllUsers() {
        logger.info("拥有admin角色，可以访问/user/all");
        List<UserInfo> allUserInfo = userInfoService.findAllUserInfo();
        return SysResponseUtils.success(allUserInfo);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @RequiresPermissions({"user:edit"})
    public SysResponse editUser() {
        logger.info("拥有user:edit权限，可以访问/user/edit");
        List<UserInfo> allUserInfo = userInfoService.findAllUserInfo();
        return SysResponseUtils.success(allUserInfo);
    }
}

