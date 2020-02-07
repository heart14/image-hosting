package com.example.heart.imagehosting.controller;

import com.example.heart.imagehosting.common.SysConstants;
import com.example.heart.imagehosting.common.SysErrorCode;
import com.example.heart.imagehosting.domain.SysResponse;
import com.example.heart.imagehosting.entity.SysPermission;
import com.example.heart.imagehosting.entity.SysRole;
import com.example.heart.imagehosting.entity.UserAuths;
import com.example.heart.imagehosting.service.SysPermissionService;
import com.example.heart.imagehosting.service.SysRoleService;
import com.example.heart.imagehosting.service.UserAuthsService;
import com.example.heart.imagehosting.utils.SnowFlake;
import com.example.heart.imagehosting.utils.SysResponseUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;

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
    public SysResponse login(@RequestBody UserAuths userAuths, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userAuths.getIdentifier(), userAuths.getCredential());
        subject.login(token);
//        Collection<Object> attributeKeys = subject.getSession().getAttributeKeys();
//        if (attributeKeys != null && attributeKeys.size() > 0) {
//            System.out.println("Shiro Subject Session:");
//            for (Object attributeKey : attributeKeys) {
//                System.out.println("key\t:" + attributeKey);
//                System.out.println("value\t:" + subject.getSession().getAttribute(attributeKey));
//                System.out.println(subject.getSession().getId());
//                System.out.println(subject.getSession().getHost());
//                System.out.println(subject.getSession().getStartTimestamp());
//                System.out.println(subject.getSession().getLastAccessTime());
//                System.out.println(subject.getSession().getTimeout());
//                System.out.println(subject.getSession());
//                System.out.println();
//            }
//        }
//        System.out.println("-----------");
//
//        Enumeration<String> attributeNames = request.getSession().getAttributeNames();
//        if (attributeNames != null) {
//            System.out.println("HttpServletRequest Session:");
//            while (attributeNames.hasMoreElements()) {
//                String s = attributeNames.nextElement();
//                System.out.println("key\t:" + s);
//                System.out.println("value\t:" + request.getSession().getAttribute(s));
//                System.out.println(request.getSession().getId());
//                System.out.println(request.getSession().getCreationTime());
//                System.out.println(request.getSession().getLastAccessedTime());
//                System.out.println(request.getSession().getMaxInactiveInterval());
//                System.out.println(request.getSession().getServletContext());
//                System.out.println();
//            }
//        }

        return SysResponseUtils.success();
    }

    /**
     * 用户登出接口
     */

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout() {
        SecurityUtils.getSubject().logout();
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public SysResponse reg() {
        UserAuths userAuths = new UserAuths();
        userAuths.setId(SnowFlake.nextId());
        userAuths.setUserId(SnowFlake.nextId());
        userAuths.setIdentityType(SysConstants.IDENTITY_TYPE_ACCOUNT);
        userAuths.setIdentifier("heartzz1");
        userAuths.setCredential("1234566");
        userAuths.setUserState(SysConstants.STATUS_TRUE);
        userAuths.setCreateTime(new Date());

        UserAuths saveUserAuths = userAuthsService.saveUserAuths(userAuths);
        return SysResponseUtils.success(saveUserAuths);
    }

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping(value = "/role/save", method = RequestMethod.POST)
    public SysResponse saveRole() {
        SysRole sysRole = new SysRole();
        sysRole.setId(SnowFlake.nextId());
        sysRole.setRoleName("admin");
        sysRole.setRoleDesc("系统管理员");
        sysRoleService.saveSysRole(sysRole);
        return SysResponseUtils.success();
    }

    @Autowired
    private SysPermissionService sysPermissionService;

    @RequestMapping(value = "/permission/save", method = RequestMethod.POST)
    private SysResponse saveSysPermission() {
        SysPermission sysPermission = new SysPermission();
        sysPermission.setId(SnowFlake.nextId());
        sysPermission.setParentId(0L);
        sysPermission.setParentIds("");
        sysPermission.setResourceType("menu");
        sysPermission.setResourceUri("/user/edit");
        sysPermission.setPermissionName("编辑用户");
        sysPermission.setPermissionDetail("user:edit");
        sysPermissionService.saveSysPermission(sysPermission);
        return SysResponseUtils.success();
    }

    /**
     * 无权限
     *
     * @return
     */
    @RequestMapping(value = "/unauthz", method = RequestMethod.GET)
    public SysResponse unAuthorized() {
        return SysResponseUtils.fail(SysErrorCode.UnAuthorizedException.getCode(), SysErrorCode.UnAuthorizedException.getMsg());
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
