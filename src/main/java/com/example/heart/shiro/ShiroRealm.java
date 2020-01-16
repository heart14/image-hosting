package com.example.heart.shiro;

import com.example.heart.imagehosting.dao.UserAuthsDao;
import com.example.heart.imagehosting.entity.SysPermission;
import com.example.heart.imagehosting.entity.SysRole;
import com.example.heart.imagehosting.entity.UserAuths;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName: ShiroRealm
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/16 14:31
 * @Version: v1.0
 */
public class ShiroRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private UserAuthsDao userAuthsDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("ShiroRealm doGetAuthorizationInfo start...");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        String identifier = (String) principalCollection.getPrimaryPrincipal();
        UserAuths userAuthsByIdentifier = userAuthsDao.findUserAuthsByIdentifier(identifier);
        logger.info("用户登录信息 => {}", userAuthsByIdentifier);
        if (userAuthsByIdentifier.getRoles() != null && userAuthsByIdentifier.getRoles().size() > 0) {
            List<String> roles = new ArrayList<>();
            List<String> permissions = new ArrayList<>();
            for (SysRole sysRole : userAuthsByIdentifier.getRoles()) {
                roles.add(sysRole.getRoleName());
                if (sysRole.getPermissions() != null && sysRole.getPermissions().size() > 0) {
                    for (SysPermission sysPermission : sysRole.getPermissions()) {
                        permissions.add(sysPermission.getPermissionDetail());
                    }
                    //将用户所拥有的权限告诉shiro
                    simpleAuthorizationInfo.setStringPermissions(new HashSet<>(permissions));
                }
            }
            //将用户所拥有角色告诉shiro
            simpleAuthorizationInfo.setRoles(new HashSet<>(roles));
        }
        logger.info("ShiroRealm doGetAuthorizationInfo over.");
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("ShiroRealm doGetAuthenticationInfo start...");
        String identifier = (String) authenticationToken.getPrincipal();

        UserAuths userAuthsByIdentifier = userAuthsDao.findUserAuthsByIdentifier(identifier);
        if (userAuthsByIdentifier == null) {
            logger.error("用户[{}]不存在", identifier);
            return null;
        }
        logger.info("用户登录信息 => {}", userAuthsByIdentifier);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(identifier, userAuthsByIdentifier.getCredential(), ByteSource.Util.bytes(userAuthsByIdentifier.buildUserSalt()), getName());
        logger.info("ShiroRealm doGetAuthenticationInfo over.");
        return simpleAuthenticationInfo;
    }
}
