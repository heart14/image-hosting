package com.example.heart.imagehosting.sdk.smms.request;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: SmmsApiGetTokenReqeust
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/8 17:37
 * @Version: v1.0
 */
public class SmmsApiGetTokenReqeust extends AbstractSmmsApiBaseRequest {

    /**
     * Username or Email Address
     */
    private String username;

    /**
     * password
     */
    private String password;

    public SmmsApiGetTokenReqeust() {
    }

    @Override
    public String apiUri() {
        return "/token";
    }

    @Override
    public String apiMethod() {
        return "post";
    }

    @Override
    public Map<String, Object> apiParams() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("username", username);
        map.put("password", password);
        return map;
    }

    public SmmsApiGetTokenReqeust(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SmmsApiGetTokenReqeust{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
