package com.example.heart.imagehosting.domain;

/**
 * @ClassName: SysRequest
 * @Description: 系统级请求
 * @Author: jayhe
 * @Date: 2020/1/14 16:35
 * @Version: v1.0
 */
public class SysRequest {

    /**
     * 应用id
     */
    private String appId;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 参数编码
     */
    private String charset;

    /**
     * 参数格式
     */
    private String format;

    /**
     * 签名方式
     */
    private String signType;

    /**
     * 签名
     */
    private String sign;

    /**
     * 随机因子
     */
    private String random;

    /**
     * 时间戳
     */
    private long timestamp;

    /**
     * 接口版本
     */
    private String version;

    /**
     * 业务参数
     */
    private String bizContent;

    public SysRequest() {
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBizContent() {
        return bizContent;
    }

    public void setBizContent(String bizContent) {
        this.bizContent = bizContent;
    }

    @Override
    public String toString() {
        return "SysRequest{" +
                "appId='" + appId + '\'' +
                ", method='" + method + '\'' +
                ", charset='" + charset + '\'' +
                ", format='" + format + '\'' +
                ", signType='" + signType + '\'' +
                ", sign='" + sign + '\'' +
                ", random='" + random + '\'' +
                ", timestamp=" + timestamp +
                ", version='" + version + '\'' +
                ", bizContent='" + bizContent + '\'' +
                '}';
    }
}
