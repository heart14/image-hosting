package com.example.heart.imagehosting.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.heart.imagehosting.domain.SysRequest;
import com.example.heart.imagehosting.domain.SysResponse;
import com.example.heart.imagehosting.entity.SysRole;
import com.example.heart.imagehosting.service.SysPermissionService;
import com.example.heart.imagehosting.service.SysRoleService;
import com.example.heart.imagehosting.utils.SnowFlake;
import com.example.heart.imagehosting.utils.SysResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: RoleController
 * @Description: TODO
 * @Author: lwf14
 * @Date: 2020/3/18 20:46
 * @Version: v1.0
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    public static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysPermissionService sysPermissionService;


    /**
     * 添加角色
     *
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
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
}
