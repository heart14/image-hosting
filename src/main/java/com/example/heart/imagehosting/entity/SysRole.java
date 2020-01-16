package com.example.heart.imagehosting.entity;

import com.example.heart.imagehosting.utils.SnowFlake;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: UserRoles
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/16 14:41
 * @Version: v1.0
 */
@Entity
@Table(name = "SYS_ROLE")
public class SysRole implements Serializable {

    private static final long serialVersionUID = 4788940827648935858L;

    /**
     * 角色id 主键 唯一标识
     */
    @Id
    private Long id;

    /**
     * 角色名 用于业务逻辑中识别角色
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色描述 用于前端页面中展示角色
     */
    @Column(name = "role_desc")
    private String roleDesc;

    /**
     * 角色状态 当前角色是否可用
     */
    @Column(name = "role_state")
    private Boolean roleState = Boolean.TRUE;

    /**
     * 角色-权限：多对多关系
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysRolePermission", joinColumns = {@JoinColumn(name = "rid")}, inverseJoinColumns = {@JoinColumn(name = "pid")})
    private List<SysPermission> permissions;

    /**
     * 角色-用户：多对多关系
     */
    @ManyToMany
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "rid")}, inverseJoinColumns = {@JoinColumn(name = "uid")})
    private List<UserAuths> userAuths;

    public SysRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Boolean getRoleState() {
        return roleState;
    }

    public void setRoleState(Boolean roleState) {
        this.roleState = roleState;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    public List<UserAuths> getUserAuths() {
        return userAuths;
    }

    public void setUserAuths(List<UserAuths> userAuths) {
        this.userAuths = userAuths;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", roleState=" + roleState +
                ", permissions=" + permissions +
                ", userAuths=" + userAuths +
                '}';
    }
}
