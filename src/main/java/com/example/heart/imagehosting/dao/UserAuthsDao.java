package com.example.heart.imagehosting.dao;

import com.example.heart.imagehosting.entity.UserAuths;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: UserAuthsDao
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 15:01
 * @Version: v1.0
 */
@Repository
public interface UserAuthsDao extends PagingAndSortingRepository<UserAuths, Long> {

    /**
     * 根据identifier查询用户账号信息
     *
     * @param identifier
     * @return
     */
    UserAuths findUserAuthsByIdentifier(String identifier);

    /**
     * 根据用户id查询用户账号信息
     *
     * @param userId
     * @return
     */
    UserAuths findUserAuthsByUserId(long userId);

}
