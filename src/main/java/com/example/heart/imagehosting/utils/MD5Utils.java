package com.example.heart.imagehosting.utils;

import com.example.heart.imagehosting.common.SysErrorCode;
import com.example.heart.imagehosting.exception.AppBizException;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @ClassName: MD5Utils
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/10/22 11:04
 * @Version: v1.0
 */
public class MD5Utils {

    /**
     * MD5摘要算法
     *
     * @param source
     * @param salt
     * @return
     */
    public static String md5(String source, String salt) throws AppBizException {
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
