package com.example.heart.imagehosting.service.impl;

import com.example.heart.imagehosting.dao.UserAuthsDao;
import com.example.heart.imagehosting.entity.UserAuths;
import com.example.heart.imagehosting.service.UserAuthsService;
import com.example.heart.imagehosting.utils.MD5Utils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserAuthsServiceImpl
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 15:07
 * @Version: v1.0
 */
@Service
public class UserAuthsServiceImpl implements UserAuthsService {

    private final UserAuthsDao userAuthsDao;

    public UserAuthsServiceImpl(UserAuthsDao userAuthsDao) {
        this.userAuthsDao = userAuthsDao;
    }

    @Override
    public UserAuths saveUserAuths(UserAuths userAuths) {
        //密码加密存储
        userAuths.setCredential(MD5Utils.md5(userAuths.getCredential(), userAuths.buildUserSalt()));
        return userAuthsDao.save(userAuths);
    }

    @Override
    public void removeUserAuths(long id) {
        userAuthsDao.deleteById(id);
    }

    @Override
    public UserAuths editUserAuths(UserAuths userAuths) {
        return userAuthsDao.save(userAuths);
    }

    @Override
    public UserAuths findUserAuthsById(long id) {
        return userAuthsDao.findById(id).orElse(null);
    }

    @Override
    public UserAuths findUserAuthsByUserId(long userId) {
        return userAuthsDao.findUserAuthsByUserId(userId);
    }

    @Override
    public UserAuths findUserAuthsByIdentifier(String identifier) {
        //TODO param validation
        return userAuthsDao.findUserAuthsByIdentifier(identifier);
    }

    @Override
    public List<UserAuths> findAllUserAuths() {
        Iterable<UserAuths> authsIterable = userAuthsDao.findAll();
        List<UserAuths> userAuthsList = new ArrayList<>();

        authsIterable.forEach(userAuths -> userAuthsList.add(userAuths));
        return userAuthsList;
    }
}
