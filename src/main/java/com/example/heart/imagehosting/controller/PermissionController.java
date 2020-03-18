package com.example.heart.imagehosting.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.heart.imagehosting.domain.SysRequest;
import com.example.heart.imagehosting.domain.SysResponse;
import com.example.heart.imagehosting.entity.SysPermission;
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
 * @ClassName: PermissionController
 * @Description: TODO
 * @Author: lwf14
 * @Date: 2020/3/18 20:46
 * @Version: v1.0
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    public static final Logger logger = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 添加权限
     *
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
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
}
