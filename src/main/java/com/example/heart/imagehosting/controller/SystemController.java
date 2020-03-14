package com.example.heart.imagehosting.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.heart.imagehosting.common.SysConstants;
import com.example.heart.imagehosting.common.SysErrorCode;
import com.example.heart.imagehosting.domain.SysRequest;
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
import java.io.Serializable;
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

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysPermissionService sysPermissionService;

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

        UserAuths userAuthsByIdentifier = userAuthsService.findUserAuthsByIdentifier(userAuths.getIdentifier());
        subject.getSession().setAttribute(SysConstants.SHIRO_SUBJECT_USER_KEY, userAuthsByIdentifier);

        //sessionId返回给前端作为token
        Serializable id = subject.getSession().getId();
        JSONObject jsonObject = new JSONObject(1);
        jsonObject.put("access_token", id);
        return SysResponseUtils.success(jsonObject);
    }

    /**
     * 用户登出接口
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout() {
        SecurityUtils.getSubject().logout();
    }

    /**
     * 用户注册接口
     *
     * @return
     */
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public SysResponse reg(@RequestBody SysRequest sysRequest) {

        //获取参数
        String bizContent = sysRequest.getBizContent();
        JSONObject bizParams = JSONObject.parseObject(bizContent);

        String identifyType = bizParams.getString("identifyType");
        String identifier = bizParams.getString("identifier");
        String credential = bizParams.getString("credential");
        String reCredential = bizParams.getString("reCredential");
        String captchaId = bizParams.getString("captchaId");
        String captchaCode = bizParams.getString("captchaCode");

        //TODO 密码一致性校验
        //TODO 验证码校验

        //组装账号数据
        UserAuths userAuths = new UserAuths();
        userAuths.setId(SnowFlake.nextId());
        userAuths.setUserId(SnowFlake.nextId());
        userAuths.setIdentityType(identifyType);
        userAuths.setIdentifier(identifier);
        userAuths.setCredential(credential);
        userAuths.setUserState(SysConstants.STATUS_TRUE);
        userAuths.setCreateTime(new Date());

        //保存账号数据
        UserAuths saveUserAuths = userAuthsService.saveUserAuths(userAuths);
        return SysResponseUtils.success(saveUserAuths);
    }

    /**
     * 添加角色
     *
     * @return
     */
    @RequestMapping(value = "/role/save", method = RequestMethod.POST)
    public SysResponse saveRole(@RequestBody SysRequest sysRequest) {
        String bizContent = sysRequest.getBizContent();
        JSONObject bizParams = JSONObject.parseObject(bizContent);

        String roleName = bizParams.getString("roleName");
        String roleDesc = bizParams.getString("roleDesc");

        SysRole sysRole = new SysRole();
        sysRole.setId(SnowFlake.nextId());
        sysRole.setRoleName(roleName);
        sysRole.setRoleDesc(roleDesc);
//        示例
//        SysRole sysRole = new SysRole();
//        sysRole.setId(SnowFlake.nextId());
//        sysRole.setRoleName("admin");
//        sysRole.setRoleDesc("系统管理员");

        sysRoleService.saveSysRole(sysRole);
        return SysResponseUtils.success();
    }

    /**
     * 添加权限
     *
     * @return
     */
    @RequestMapping(value = "/permission/save", method = RequestMethod.POST)
    public SysResponse saveSysPermission(@RequestBody SysRequest sysRequest) {
        String bizContent = sysRequest.getBizContent();
        JSONObject bizParams = JSONObject.parseObject(bizContent);

        Long parentId = bizParams.getLong("parentId");
        String parentIds = bizParams.getString("parentIds");
        String resourceType = bizParams.getString("resourceType");
        String resourceUri = bizParams.getString("resourceUri");
        String permissionName = bizParams.getString("permissionName");
        String permissionDetail = bizParams.getString("permissionDetail");

        SysPermission sysPermission = new SysPermission();
        sysPermission.setId(SnowFlake.nextId());
        sysPermission.setParentId(parentId);
        sysPermission.setParentIds(parentIds);
        sysPermission.setResourceType(resourceType);
        sysPermission.setResourceUri(resourceUri);
        sysPermission.setPermissionName(permissionName);
        sysPermission.setPermissionDetail(permissionDetail);
//        示例
//        SysPermission sysPermission = new SysPermission();
//        sysPermission.setId(SnowFlake.nextId());
//        sysPermission.setParentId(0L);
//        sysPermission.setParentIds("");
//        sysPermission.setResourceType("button");
//        sysPermission.setResourceUri("/user/edit");
//        sysPermission.setPermissionName("编辑用户");
//        sysPermission.setPermissionDetail("user:edit");

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
