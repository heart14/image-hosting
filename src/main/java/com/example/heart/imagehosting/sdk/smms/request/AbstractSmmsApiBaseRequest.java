package com.example.heart.imagehosting.sdk.smms.request;

import com.alibaba.fastjson.JSON;
import com.example.heart.imagehosting.common.SysConstants;
import com.example.heart.imagehosting.exception.AppBizException;
import com.example.heart.imagehosting.sdk.smms.response.SmmsBaseResponse;
import com.example.heart.imagehosting.sdk.smms.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName: SmmsApiBaseRequest
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/8 17:42
 * @Version: v1.0
 */
public abstract class AbstractSmmsApiBaseRequest implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(AbstractSmmsApiBaseRequest.class);

    private static final long serialVersionUID = -8992597076160732457L;

    public static final String SMMS_BASE_URL = "https://sm.ms/api/v2";

    private String requestId;

    private String timestamp;

    private String apiUri;

    private String apiMethod;

    private String apiToken;

    private Map<String, Object> apiParams;

    public AbstractSmmsApiBaseRequest() {
        this.requestId = UUID.randomUUID().toString();
        this.timestamp = String.valueOf(System.currentTimeMillis());
        this.apiUri = apiUri();
        this.apiMethod = apiMethod();
        this.apiToken = apiToken();
        this.apiParams = apiParams();
    }

    /**
     * 请求地址 子类根据要请求的接口来确定
     *
     * @return
     */
    public abstract String apiUri();

    /**
     * 请求方法 子类根据要请求的接口来确定
     *
     * @return
     */
    public abstract String apiMethod();

    /**
     * 请求参数 子类根据要请求的接口来确定
     *
     * @return
     */
    public abstract Map<String, Object> apiParams();

    /**
     * 请求TOKEN 从系统配置获取
     *
     * @return
     */
    private String apiToken() {
        return "zQB4WBCOTRPNtZ28REyBv062mWOTkdA8";
    }

    /**
     * 发送HTTP请求
     *
     * @return
     */
    public SmmsBaseResponse doRequest() throws AppBizException {
        String resp;
        if (SysConstants.HTTP_METHOD_GET.equalsIgnoreCase(apiMethod)) {
            resp = HttpUtils.doGet(SMMS_BASE_URL + apiUri, apiToken);
            logger.info("SMMS {} RESPONSE :{}", SMMS_BASE_URL + apiUri, resp);
        } else if (SysConstants.HTTP_METHOD_POST.equalsIgnoreCase(apiMethod)) {
            resp = HttpUtils.doPost(SMMS_BASE_URL + apiUri, buildApiParams(apiParams()), apiToken);
            logger.info("SMMS {} RESPONSE :{}", SMMS_BASE_URL + apiUri, resp);
        } else {
            logger.error("SMMS {} REQUEST METHOD ERROR! :{}", SMMS_BASE_URL + apiUri, apiMethod);
            return null;
        }
        return JSON.parseObject(resp, SmmsBaseResponse.class);
    }

    /**
     * 组装请求参数
     *
     * @param apiParams
     * @return
     */
    public String buildApiParams(Map<String, Object> apiParams) {
        if (apiParams == null || apiParams.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Object> stringObjectEntry : apiParams.entrySet()) {
            String key = stringObjectEntry.getKey();
            Object value = stringObjectEntry.getValue();
            stringBuilder.append("&");
            stringBuilder.append(key);
            stringBuilder.append("=");
            stringBuilder.append(value);
        }
        return stringBuilder.toString().replaceFirst("&", "");
    }
}
