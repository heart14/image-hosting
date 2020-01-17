package com.example.heart.imagehosting.service;

import com.example.heart.imagehosting.entity.SysRole;
import com.example.heart.imagehosting.exception.AppBizException;

/**
 * @ClassName: SysRoleService
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/17 10:50
 * @Version: v1.0
 */
public interface SysRoleService {

    /**
     * 增
     * @param sysRole
     * @return
     * @throws AppBizException
     */
    SysRole saveSysRole(SysRole sysRole) throws AppBizException;
}
