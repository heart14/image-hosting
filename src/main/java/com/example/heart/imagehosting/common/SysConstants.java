package com.example.heart.imagehosting.common;

/**
 * @ClassName: SysConstants
 * @Description: 系统常量
 * @Author: jayhe
 * @Date: 2019/12/30 17:16
 * @Version: v1.0
 */
public class SysConstants {

    public static final int STATE_SUCCESS = 0;
    public static final int STATE_FAIL = -1;

    public static final int STATUS_TRUE = 1;
    public static final int STATUS_FALSE = 0;

    public static final String HTTP_METHOD_POST = "POST";
    public static final String HTTP_METHOD_GET = "GET";

    public static final String IDENTITY_TYPE_ACCOUNT = "ACCOUNT";
    public static final String IDENTITY_TYPE_TELEPHONE = "TELEPHONE";
    public static final String IDENTITY_TYPE_EMAIL = "EMAIL";

    public static final String SHIRO_SUBJECT_USER_KEY = "current_user";

    public static final Long JWT_TOKEN_TTL = 30000L;
    public static final String JWT_TOKEN_SECRET = "heartzzzzzzzzzzzzzzzz";
}
