package com.example.heart.imagehosting.dao;

import com.example.heart.imagehosting.entity.UserInfo;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @ClassName: UserInfoDao
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 15:27
 * @Version: v1.0
 */
public interface UserInfoDao extends PagingAndSortingRepository<UserInfo, Long> {
}
