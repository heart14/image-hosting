package com.example.heart.imagehosting.service.impl;

import com.example.heart.imagehosting.dao.SysPermissionDao;
import com.example.heart.imagehosting.entity.SysPermission;
import com.example.heart.imagehosting.exception.AppBizException;
import com.example.heart.imagehosting.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: SysPermissionServiceImpl
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/17 10:51
 * @Version: v1.0
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionDao sysPermissionDao;

    @Override
    public SysPermission saveSysPermission(SysPermission sysPermission) throws AppBizException {
        return sysPermissionDao.save(sysPermission);
    }
}
