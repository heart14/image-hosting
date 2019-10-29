package com.example.heart.imagehosting.service;

import com.example.heart.imagehosting.entity.UserAuths;

import java.util.List;

/**
 * @ClassName: UserAuthsService
 * @Description: TODO
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
    void removeUserAuths(String id);

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
    UserAuths findUserAuthsById(String id);

    /**
     * 查
     *
     * @param userId
     * @return
     */
    UserAuths findUserAuthsByUserId(String userId);

    /**
     * 查
     *
     * @return
     */
    List<UserAuths> findAllUserAuths();

}
