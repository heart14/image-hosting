package com.example.heart.imagehosting.sdk.smms.request.image;

import com.alibaba.fastjson.JSON;
import com.example.heart.imagehosting.exception.AppBizException;
import com.example.heart.imagehosting.sdk.smms.request.AbstractSmmsApiBaseRequest;
import com.example.heart.imagehosting.sdk.smms.response.SmmsBaseResponse;
import com.example.heart.imagehosting.sdk.smms.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Map;

/**
 * @ClassName: SmmsApiImageUploadRequest
 * @Description: TODO
 * @Author: lwf14
 * @Date: 2020/1/13 21:08
 * @Version: v1.0
 */
public class SmmsApiImageUploadRequest extends AbstractSmmsApiBaseRequest {

    private static final Logger logger = LoggerFactory.getLogger(SmmsApiImageUploadRequest.class);

    private static final long serialVersionUID = 5828579022798696239L;

    private File smfile;

    public SmmsApiImageUploadRequest() {
    }

    public SmmsApiImageUploadRequest(File smfile) {
        this.smfile = smfile;
    }

    @Override
    public String apiUri() {
        return "/upload";
    }

    @Override
    public String apiMethod() {
        return "post";
    }

    @Override
    public Map<String, Object> apiParams() {
        return null;
    }

    @Override
    public SmmsBaseResponse doRequest() throws AppBizException {
        String doPostImage = HttpUtils.doPostImage(SMMS_BASE_URL + apiUri(), smfile, apiToken());
        logger.info("SMMS {} RESPONSE :{}", SMMS_BASE_URL + apiUri(), doPostImage);
        return JSON.parseObject(doPostImage, SmmsBaseResponse.class);
    }
}
