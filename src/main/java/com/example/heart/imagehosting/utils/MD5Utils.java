package com.example.heart.imagehosting.utils;

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
     * @param str
     * @param salt
     * @return
     */
    public static String md5(String str, String salt) {
        return str + salt;
    }
}
