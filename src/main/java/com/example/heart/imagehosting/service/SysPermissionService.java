package com.example.heart.imagehosting.service;

import com.example.heart.imagehosting.entity.SysPermission;
import com.example.heart.imagehosting.exception.AppBizException;

/**
 * @ClassName: SysPermissionService
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/17 10:51
 * @Version: v1.0
 */
public interface SysPermissionService {

    /**
     * 增
     *
     * @param sysPermission
     * @return
     * @throws AppBizException
     */
    SysPermission saveSysPermission(SysPermission sysPermission) throws AppBizException;
}
