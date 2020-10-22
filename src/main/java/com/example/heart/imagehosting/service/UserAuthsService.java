package com.example.heart.imagehosting.service;

import com.example.heart.imagehosting.entity.UserAuths;

import java.util.List;

/**
 * @ClassName: UserAuthsService
 * @Description: 用户账号服务类
 * @Author: jayhe
 * @Date: 2019/10/29 15:03
 * @Version: v1.0
 */
public interface UserAuthsService {

    /**
     * 增
     *
     * @param userAuths
     * @return
     */
    UserAuths saveUserAuths(UserAuths userAuths);

    /**
     * 删
     *
     * @param id
     */
    void removeUserAuths(long id);

    /**
     * 改
     *
     * @param userAuths
     * @return
     */
    UserAuths editUserAuths(UserAuths userAuths);

    /**
     * 查
     *
     * @param id
     * @return
     */
    UserAuths findUserAuthsById(long id);

    /**
     * 查
     *
     * @param userId
     * @return
     */
    UserAuths findUserAuthsByUserId(long userId);

    /**
     * 查
     *
     * @param identifier
     * @return
     */
    UserAuths findUserAuthsByIdentifier(String identifier);

    /**
     * 查
     *
     * @return
     */
    List<UserAuths> findAllUserAuths();

}
