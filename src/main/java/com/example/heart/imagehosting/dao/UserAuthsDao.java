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

    UserAuths findUserAuthsByIdentifier(String identifier);

    UserAuths findUserAuthsByUserId(long userId);

}
