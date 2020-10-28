package com.example.heart.imagehosting.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户账号实体类
 */
@Entity
@Table(name = "USER_AUTHS")
public class UserAuths implements Serializable {

    private static final long serialVersionUID = 8684771121313587762L;

    @Id
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 登录类型[用户名|手机号|邮箱|QQ登录|微信登录|微博登录]
     */
    @Column(name = "identity_type")
    private String identityType;

    /**
     * 登陆凭证
     */
    @Column(name = "identifier")
    private String identifier;

    /**
     * 登录票据
     */
    @Column(name = "credential")
    private String credential;

    /**
     * 用户状态
     */
    @Column(name = "user_state")
    private Integer userState;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    public UserAuths() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    @Override
    public String toString() {
        return "UserAuths{" +
                "id=" + id +
                ", userId=" + userId +
                ", identityType='" + identityType + '\'' +
                ", identifier='" + identifier + '\'' +
                ", credential='" + credential + '\'' +
                ", userState=" + userState +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}