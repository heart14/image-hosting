package com.example.heart.imagehosting.utils;

import java.util.UUID;

/**
 * @ClassName: StringUtils
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 16:47
 * @Version: v1.0
 */
public class StringUtils {

    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
