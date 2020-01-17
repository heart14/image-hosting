package com.example.heart.imagehosting.dao;

import com.example.heart.imagehosting.entity.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: SysPermissionDao
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/17 10:55
 * @Version: v1.0
 */
@Repository
public interface SysPermissionDao extends JpaRepository<SysPermission, Long> {
}
