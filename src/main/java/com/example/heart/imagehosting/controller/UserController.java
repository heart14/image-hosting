package com.example.heart.imagehosting.controller;

import com.example.heart.imagehosting.entity.UserInfo;
import com.example.heart.imagehosting.service.SmmsImageService;
import com.example.heart.imagehosting.service.UserAuthsService;
import com.example.heart.imagehosting.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 15:34
 * @Version: v1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserAuthsService userAuthsService;

    private final UserInfoService userInfoService;

    private final SmmsImageService smmsImageService;

    public UserController(UserAuthsService userAuthsService, UserInfoService userInfoService, SmmsImageService smmsImageService) {
        this.userAuthsService = userAuthsService;
        this.userInfoService = userInfoService;
        this.smmsImageService = smmsImageService;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {
        logger.info("Image-Hosting project test.");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public void editUserInfo(@RequestBody UserInfo userInfo) {

        logger.info("{}", userInfo);

    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void upload(@RequestParam("multipartFiles") MultipartFile[] multipartFiles) {
        List<File> list = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            try {
                File targetDir = new File("D:\\HOSTING");
                if (!targetDir.exists()) {
                    targetDir.mkdirs();
                }
                File file = new File("D:\\HOSTING" + "\\" + multipartFile.getOriginalFilename());
                multipartFile.transferTo(file);
                smmsImageService.smmsUploadImage(file);
                list.add(file);
            } catch (IOException e) {
                //TODO 统一异常处理
                logger.error("{}", e.getMessage());
            }
        }
        /*
        2020-01-13 22:55:23.023 INFO  1444 --- [http-nio-8091-exec-4] c.e.h.i.s.s.service.impl.SmmsApiImageServiceImpl  54 :SMMS SDK :上传文件[smfile = D:\HOSTING\0d5b857819f4b3bb068b9d7142c830bddca9f8427fd8d98dd8d93ffbf15e6374.jpg]
2020-01-13 22:55:26.026 INFO  1444 --- [http-nio-8091-exec-4] c.e.heart.imagehosting.sdk.smms.utils.HttpUtils  257 :SM.MS上传结果 : {"success":true,"code":"success","message":"Upload success.","data":{"file_id":0,"width":1920,"height":1080,"filename":"0d5b857819f4b3bb068b9d7142c830bddca9f8427fd8d98dd8d93ffbf15e6374.jpg","storename":"OnvEqglPmI1tdNi.jpg","size":326172,"path":"\/2020\/01\/13\/OnvEqglPmI1tdNi.jpg","hash":"gc9BKMFj5GOlPQoN2svAa8ChYE","url":"https:\/\/i.loli.net\/2020\/01\/13\/OnvEqglPmI1tdNi.jpg","delete":"https:\/\/sm.ms\/delete\/gc9BKMFj5GOlPQoN2svAa8ChYE","page":"https:\/\/sm.ms\/image\/OnvEqglPmI1tdNi"},"RequestId":"6D1D0BFD-0901-4342-B7C4-71A102F99CE4"}
2020-01-13 22:55:26.026 INFO  1444 --- [http-nio-8091-exec-4] c.e.h.i.s.s.r.image.SmmsApiImageUploadRequest     54 :SMMS https://sm.ms/api/v2/upload RESPONSE :{"success":true,"code":"success","message":"Upload success.","data":{"file_id":0,"width":1920,"height":1080,"filename":"0d5b857819f4b3bb068b9d7142c830bddca9f8427fd8d98dd8d93ffbf15e6374.jpg","storename":"OnvEqglPmI1tdNi.jpg","size":326172,"path":"\/2020\/01\/13\/OnvEqglPmI1tdNi.jpg","hash":"gc9BKMFj5GOlPQoN2svAa8ChYE","url":"https:\/\/i.loli.net\/2020\/01\/13\/OnvEqglPmI1tdNi.jpg","delete":"https:\/\/sm.ms\/delete\/gc9BKMFj5GOlPQoN2svAa8ChYE","page":"https:\/\/sm.ms\/image\/OnvEqglPmI1tdNi"},"RequestId":"6D1D0BFD-0901-4342-B7C4-71A102F99CE4"}
2020-01-13 22:55:26.026 INFO  1444 --- [http-nio-8091-exec-4] c.e.h.i.service.impl.SmmsImageServiceImpl         32 :图片上传 :SmmsBaseResponse{success=true, code='success', message='Upload success.', data={"path":"/2020/01/13/OnvEqglPmI1tdNi.jpg","filename":"0d5b857819f4b3bb068b9d7142c830bddca9f8427fd8d98dd8d93ffbf15e6374.jpg","size":326172,"file_id":0,"width":1920,"storename":"OnvEqglPmI1tdNi.jpg","page":"https://sm.ms/image/OnvEqglPmI1tdNi","delete":"https://sm.ms/delete/gc9BKMFj5GOlPQoN2svAa8ChYE","hash":"gc9BKMFj5GOlPQoN2svAa8ChYE","url":"https://i.loli.net/2020/01/13/OnvEqglPmI1tdNi.jpg","height":1080}, RequestId='6D1D0BFD-0901-4342-B7C4-71A102F99CE4'}
2020-01-13 22:56:46.046 INFO  1444 --- [http-nio-8091-exec-3] c.e.h.i.s.s.service.impl.SmmsApiImageServiceImpl  54 :SMMS SDK :上传文件[smfile = D:\HOSTING\2ff790a38931a25dd59bb286c01ed1d0f91a6f4a62452b4784fa335ac2554c76.jpg]
2020-01-13 22:56:49.049 INFO  1444 --- [http-nio-8091-exec-3] c.e.heart.imagehosting.sdk.smms.utils.HttpUtils  257 :SM.MS上传结果 : {"success":true,"code":"success","message":"Upload success.","data":{"file_id":0,"width":1920,"height":1080,"filename":"2ff790a38931a25dd59bb286c01ed1d0f91a6f4a62452b4784fa335ac2554c76.jpg","storename":"Ei6mTyU21lnxzXp.jpg","size":433009,"path":"\/2020\/01\/13\/Ei6mTyU21lnxzXp.jpg","hash":"2ZHRDJQ8wNUMFgChu6BKpoIOtc","url":"https:\/\/i.loli.net\/2020\/01\/13\/Ei6mTyU21lnxzXp.jpg","delete":"https:\/\/sm.ms\/delete\/2ZHRDJQ8wNUMFgChu6BKpoIOtc","page":"https:\/\/sm.ms\/image\/Ei6mTyU21lnxzXp"},"RequestId":"830EA0F8-EE8E-402B-BED9-752C2BFFD7A2"}
2020-01-13 22:56:49.049 INFO  1444 --- [http-nio-8091-exec-3] c.e.h.i.s.s.r.image.SmmsApiImageUploadRequest     54 :SMMS https://sm.ms/api/v2/upload RESPONSE :{"success":true,"code":"success","message":"Upload success.","data":{"file_id":0,"width":1920,"height":1080,"filename":"2ff790a38931a25dd59bb286c01ed1d0f91a6f4a62452b4784fa335ac2554c76.jpg","storename":"Ei6mTyU21lnxzXp.jpg","size":433009,"path":"\/2020\/01\/13\/Ei6mTyU21lnxzXp.jpg","hash":"2ZHRDJQ8wNUMFgChu6BKpoIOtc","url":"https:\/\/i.loli.net\/2020\/01\/13\/Ei6mTyU21lnxzXp.jpg","delete":"https:\/\/sm.ms\/delete\/2ZHRDJQ8wNUMFgChu6BKpoIOtc","page":"https:\/\/sm.ms\/image\/Ei6mTyU21lnxzXp"},"RequestId":"830EA0F8-EE8E-402B-BED9-752C2BFFD7A2"}
2020-01-13 22:56:49.049 INFO  1444 --- [http-nio-8091-exec-3] c.e.h.i.service.impl.SmmsImageServiceImpl         32 :图片上传 :SmmsBaseResponse{success=true, code='success', message='Upload success.', data={"path":"/2020/01/13/Ei6mTyU21lnxzXp.jpg","filename":"2ff790a38931a25dd59bb286c01ed1d0f91a6f4a62452b4784fa335ac2554c76.jpg","size":433009,"file_id":0,"width":1920,"storename":"Ei6mTyU21lnxzXp.jpg","page":"https://sm.ms/image/Ei6mTyU21lnxzXp","delete":"https://sm.ms/delete/2ZHRDJQ8wNUMFgChu6BKpoIOtc","hash":"2ZHRDJQ8wNUMFgChu6BKpoIOtc","url":"https://i.loli.net/2020/01/13/Ei6mTyU21lnxzXp.jpg","height":1080}, RequestId='830EA0F8-EE8E-402B-BED9-752C2BFFD7A2'}
2020-01-13 22:57:30.030 INFO  1444 --- [http-nio-8091-exec-9] c.e.h.i.s.s.service.impl.SmmsApiImageServiceImpl  54 :SMMS SDK :上传文件[smfile = D:\HOSTING\0fcdfc9e7985a7383045f1277a1de77685f7ab606845213c4d5a88b510af2651.jpg]
2020-01-13 22:57:30.030 INFO  1444 --- [http-nio-8091-exec-8] c.e.h.i.s.s.service.impl.SmmsApiImageServiceImpl  54 :SMMS SDK :上传文件[smfile = D:\HOSTING\1eea6f5286df713188a89e6da69e4b7ca6c5f57cd973f539bb23567011e5dd33.jpg]
2020-01-13 22:57:33.033 INFO  1444 --- [http-nio-8091-exec-9] c.e.heart.imagehosting.sdk.smms.utils.HttpUtils  257 :SM.MS上传结果 : {"success":true,"code":"success","message":"Upload success.","data":{"file_id":0,"width":1080,"height":1920,"filename":"0fcdfc9e7985a7383045f1277a1de77685f7ab606845213c4d5a88b510af2651.jpg","storename":"g2qsiAmd6cpYTt1.jpg","size":445080,"path":"\/2020\/01\/13\/g2qsiAmd6cpYTt1.jpg","hash":"sebV2dML5HNm7JZXAYEQfqG6Io","url":"https:\/\/i.loli.net\/2020\/01\/13\/g2qsiAmd6cpYTt1.jpg","delete":"https:\/\/sm.ms\/delete\/sebV2dML5HNm7JZXAYEQfqG6Io","page":"https:\/\/sm.ms\/image\/g2qsiAmd6cpYTt1"},"RequestId":"4CACEC8D-F50B-4F9A-8E14-8CFDA96EBD1B"}
2020-01-13 22:57:33.033 INFO  1444 --- [http-nio-8091-exec-9] c.e.h.i.s.s.r.image.SmmsApiImageUploadRequest     54 :SMMS https://sm.ms/api/v2/upload RESPONSE :{"success":true,"code":"success","message":"Upload success.","data":{"file_id":0,"width":1080,"height":1920,"filename":"0fcdfc9e7985a7383045f1277a1de77685f7ab606845213c4d5a88b510af2651.jpg","storename":"g2qsiAmd6cpYTt1.jpg","size":445080,"path":"\/2020\/01\/13\/g2qsiAmd6cpYTt1.jpg","hash":"sebV2dML5HNm7JZXAYEQfqG6Io","url":"https:\/\/i.loli.net\/2020\/01\/13\/g2qsiAmd6cpYTt1.jpg","delete":"https:\/\/sm.ms\/delete\/sebV2dML5HNm7JZXAYEQfqG6Io","page":"https:\/\/sm.ms\/image\/g2qsiAmd6cpYTt1"},"RequestId":"4CACEC8D-F50B-4F9A-8E14-8CFDA96EBD1B"}
2020-01-13 22:57:33.033 INFO  1444 --- [http-nio-8091-exec-9] c.e.h.i.service.impl.SmmsImageServiceImpl         32 :图片上传 :SmmsBaseResponse{success=true, code='success', message='Upload success.', data={"path":"/2020/01/13/g2qsiAmd6cpYTt1.jpg","filename":"0fcdfc9e7985a7383045f1277a1de77685f7ab606845213c4d5a88b510af2651.jpg","size":445080,"file_id":0,"width":1080,"storename":"g2qsiAmd6cpYTt1.jpg","page":"https://sm.ms/image/g2qsiAmd6cpYTt1","delete":"https://sm.ms/delete/sebV2dML5HNm7JZXAYEQfqG6Io","hash":"sebV2dML5HNm7JZXAYEQfqG6Io","url":"https://i.loli.net/2020/01/13/g2qsiAmd6cpYTt1.jpg","height":1920}, RequestId='4CACEC8D-F50B-4F9A-8E14-8CFDA96EBD1B'}
2020-01-13 22:57:33.033 INFO  1444 --- [http-nio-8091-exec-8] c.e.heart.imagehosting.sdk.smms.utils.HttpUtils  257 :SM.MS上传结果 : {"success":true,"code":"success","message":"Upload success.","data":{"file_id":0,"width":1080,"height":1920,"filename":"1eea6f5286df713188a89e6da69e4b7ca6c5f57cd973f539bb23567011e5dd33.jpg","storename":"MFTrARwhLqetms7.jpg","size":460815,"path":"\/2020\/01\/13\/MFTrARwhLqetms7.jpg","hash":"zrm1UHd6iIpDAZ3BwcJlQ59jax","url":"https:\/\/i.loli.net\/2020\/01\/13\/MFTrARwhLqetms7.jpg","delete":"https:\/\/sm.ms\/delete\/zrm1UHd6iIpDAZ3BwcJlQ59jax","page":"https:\/\/sm.ms\/image\/MFTrARwhLqetms7"},"RequestId":"276B98A5-FDB3-4171-B0BA-DE6352472C53"}
2020-01-13 22:57:33.033 INFO  1444 --- [http-nio-8091-exec-8] c.e.h.i.s.s.r.image.SmmsApiImageUploadRequest     54 :SMMS https://sm.ms/api/v2/upload RESPONSE :{"success":true,"code":"success","message":"Upload success.","data":{"file_id":0,"width":1080,"height":1920,"filename":"1eea6f5286df713188a89e6da69e4b7ca6c5f57cd973f539bb23567011e5dd33.jpg","storename":"MFTrARwhLqetms7.jpg","size":460815,"path":"\/2020\/01\/13\/MFTrARwhLqetms7.jpg","hash":"zrm1UHd6iIpDAZ3BwcJlQ59jax","url":"https:\/\/i.loli.net\/2020\/01\/13\/MFTrARwhLqetms7.jpg","delete":"https:\/\/sm.ms\/delete\/zrm1UHd6iIpDAZ3BwcJlQ59jax","page":"https:\/\/sm.ms\/image\/MFTrARwhLqetms7"},"RequestId":"276B98A5-FDB3-4171-B0BA-DE6352472C53"}
2020-01-13 22:57:33.033 INFO  1444 --- [http-nio-8091-exec-8] c.e.h.i.service.impl.SmmsImageServiceImpl         32 :图片上传 :SmmsBaseResponse{success=true, code='success', message='Upload success.', data={"path":"/2020/01/13/MFTrARwhLqetms7.jpg","filename":"1eea6f5286df713188a89e6da69e4b7ca6c5f57cd973f539bb23567011e5dd33.jpg","size":460815,"file_id":0,"width":1080,"storename":"MFTrARwhLqetms7.jpg","page":"https://sm.ms/image/MFTrARwhLqetms7","delete":"https://sm.ms/delete/zrm1UHd6iIpDAZ3BwcJlQ59jax","hash":"zrm1UHd6iIpDAZ3BwcJlQ59jax","url":"https://i.loli.net/2020/01/13/MFTrARwhLqetms7.jpg","height":1920}, RequestId='276B98A5-FDB3-4171-B0BA-DE6352472C53'}

         */
    }

}
