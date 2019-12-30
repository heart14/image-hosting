package com.example.heart.imagehosting.service.impl;

import com.example.heart.imagehosting.dao.UserAuthsDao;
import com.example.heart.imagehosting.entity.UserAuths;
import com.example.heart.imagehosting.service.UserAuthsService;
import org.springframework.stereotype.Service;

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
        return userAuthsDao.save(userAuths);
    }

    @Override
    public void removeUserAuths(String id) {
        userAuthsDao.deleteById(id);
    }

    @Override
    public UserAuths editUserAuths(UserAuths userAuths) {
        return userAuthsDao.save(userAuths);
    }

    @Override
    public UserAuths findUserAuthsById(String id) {
        return userAuthsDao.findById(id).isPresent() ? userAuthsDao.findById(id).get() : null;
    }

    @Override
    public UserAuths findUserAuthsByUserId(String userId) {
        return null;
    }

    @Override
    public List<UserAuths> findAllUserAuths() {
        return null;
    }
}
