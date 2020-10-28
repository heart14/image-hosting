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

    /**
     * 生成uuid
     *
     * @return
     */
    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 生成用户盐
     *
     * @param identifier
     * @return
     * @throws AppBizException
     */
    public static String salt(String identifier) throws AppBizException {
        if (StringUtils.isBlank(identifier)) {
            throw new AppBizException(SysErrorCode.UnknownParamException.getCode(), SysErrorCode.UnknownParamException.getMsg());
        }
        //TODO 盐密钥从配置文件中获取
        String saltKey = "1234566";
        return MD5Utils.md5(identifier, saltKey);
    }
}
