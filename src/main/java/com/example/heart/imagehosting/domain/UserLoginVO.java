package com.example.heart.imagehosting.domain;

import java.io.Serializable;

/**
 * @ClassName: UserLoginVO
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/10/27 17:17
 * @Version: v1.0
 */
public class UserLoginVO {

//    private static final long serialVersionUID = 8090275720149638266L;

    /**
     * 登录类型[用户名|手机号|邮箱|QQ登录|微信登录|微博登录]
     */
    private String identityType;

    /**
     * 登陆凭证
     */
    private String identifier;

    /**
     * 登录票据
     */
    private String credential;

    /**
     * 验证码ID
     */
    private String captchaId;

    /**
     * 验证码
     */
    private String captchaCode;

    public UserLoginVO() {
    }

    public UserLoginVO(String identityType, String identifier, String credential, String captchaId, String captchaCode) {
        this.identityType = identityType;
        this.identifier = identifier;
        this.credential = credential;
        this.captchaId = captchaId;
        this.captchaCode = captchaCode;
    }

    @Override
    public String toString() {
        return "UserLoginVO{" +
                "identityType='" + identityType + '\'' +
                ", identifier='" + identifier + '\'' +
                ", credential='" + credential + '\'' +
                ", captchaId='" + captchaId + '\'' +
                ", captchaCode='" + captchaCode + '\'' +
                '}';
    }
}
