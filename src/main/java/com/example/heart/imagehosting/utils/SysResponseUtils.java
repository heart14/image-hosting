package com.example.heart.imagehosting.utils;

import com.example.heart.imagehosting.common.SysConstants;
import com.example.heart.imagehosting.common.SysErrorCode;
import com.example.heart.imagehosting.exception.SysResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: SysResponseUtils
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/12/30 17:13
 * @Version: v1.0
 */
public class SysResponseUtils {

    public static final Logger logger = LoggerFactory.getLogger(SysResponseUtils.class);

    public static SysResponse success() {
        return success(null);
    }

    public static SysResponse success(Object object) {
        SysResponse sysResponse = new SysResponse();
        sysResponse.setState(SysConstants.STATE_SUCCESS);
        sysResponse.setErrCode(SysErrorCode.SUCCESS.getCode());
        sysResponse.setErrMessage(SysErrorCode.SUCCESS.getMsg());
        sysResponse.setData(object);
        return sysResponse;
    }

    public static SysResponse success(Integer code,String msg) {
        SysResponse sysResponse = new SysResponse();
        sysResponse.setState(SysConstants.STATE_SUCCESS);
        sysResponse.setErrCode(code);
        sysResponse.setErrMessage(msg);
        return sysResponse;
    }

    public static SysResponse fail(Integer code, String msg) {
        return fail(code, msg, null);
    }

    public static SysResponse fail(Integer code, String msg, Object object) {
        SysResponse sysResponse = new SysResponse();
        sysResponse.setState(SysConstants.STATE_FAIL);
        sysResponse.setErrCode(code);
        sysResponse.setErrMessage(msg);
        sysResponse.setData(object);
        return sysResponse;
    }
}
