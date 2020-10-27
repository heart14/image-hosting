package com.example.heart.imagehosting.utils;

import com.example.heart.imagehosting.common.SysErrorCode;
import com.example.heart.imagehosting.exception.AppBizException;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

/**
 * @ClassName: StringUtils
 * @Description: 字符串工具类
 * @Author: jayhe
 * @Date: 2019/10/29 16:47
 * @Version: v1.0
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * MD5加密
     *
     * @param source
     * @param salt
     * @return
     * @throws AppBizException
     */
    public static String md5Encrypt(String source, String salt) throws AppBizException {
        if (StringUtils.isAnyBlank(source, salt)) {
            throw new AppBizException(SysErrorCode.UnknownParamException.getCode(), SysErrorCode.UnknownParamException.getMsg());
        }
        //使用用户盐MD5加密
        String s1 = source + salt;
        String encrypt = DigestUtils.md5Hex(s1).toUpperCase();
        //二次加密
        String s2 = encrypt + salt;
        return DigestUtils.md5Hex(s2).toUpperCase();
    }
}
