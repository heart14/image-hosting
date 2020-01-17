package com.example.heart.imagehosting.dao;

import com.example.heart.imagehosting.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: SysRoleDao
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/17 10:52
 * @Version: v1.0
 */
@Repository
public interface SysRoleDao extends JpaRepository<SysRole, Long> {
}
