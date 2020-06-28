package com.example.heart.imagehosting.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: UserPermissions
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/16 14:42
 * @Version: v1.0
 */
@Entity
@Table(name = "SYS_PERMISSION")
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 1578573861692503201L;

    @Id
    private Long id;

    /**
     * 权限id
     */
    @Column(name = "permission_id")
    private Long permissionId;

    /**
     * 权限名 用于标识大权限
     */
    @Column(name = "permission_name")
    private String permissionName;

    /**
     * 资源类型
     */
    @Column(name = "resource_type")
    private String resourceType;

    /**
     * 资源路径
     */
    @Column(name = "resource_uri")
    private String resourceUri;

    /**
     * 权限名 具体权限描述
     */
    @Column(name = "permission_detail")
    private String permissionDetail;

    /**
     * 父权限id
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 父权限id列表
     */
    @Column(name = "parent_ids")
    private String parentIds;

    /**
     * 权限状态
     */
    @Column(name = "permission_state")
    private Boolean permissionState = Boolean.TRUE;

    /**
     * 权限-角色 多对多关系
     */
    @ManyToMany(mappedBy = "permissions")
    private List<SysRole> roles;

    public SysPermission() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }

    public String getPermissionDetail() {
        return permissionDetail;
    }

    public void setPermissionDetail(String permissionDetail) {
        this.permissionDetail = permissionDetail;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public Boolean getPermissionState() {
        return permissionState;
    }

    public void setPermissionState(Boolean permissionState) {
        this.permissionState = permissionState;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "id=" + id +
                ", permissionId='" + permissionId + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", resourceUri='" + resourceUri + '\'' +
                ", permissionDetail='" + permissionDetail + '\'' +
                ", parentId=" + parentId +
                ", parentIds='" + parentIds + '\'' +
                ", permissionState=" + permissionState +
                '}';
    }
}
