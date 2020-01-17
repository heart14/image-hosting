package com.example.heart.imagehosting.service.impl;

import com.example.heart.imagehosting.dao.SysRoleDao;
import com.example.heart.imagehosting.entity.SysRole;
import com.example.heart.imagehosting.exception.AppBizException;
import com.example.heart.imagehosting.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: SysRoleServiceImpl
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/17 10:51
 * @Version: v1.0
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public SysRole saveSysRole(SysRole sysRole) throws AppBizException {
        SysRole role = sysRoleDao.save(sysRole);
        return role;
    }
}
