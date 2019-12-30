package com.example.heart.imagehosting.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.heart.imagehosting.entity.ImageInfo;
import com.example.heart.imagehosting.service.ImageInfoService;
import com.example.heart.imagehosting.utils.HttpUtils;
import com.example.heart.imagehosting.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @ClassName: ImageController
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 15:45
 * @Version: v1.0
 */
@RestController
@RequestMapping("/image")
public class ImageController {

    public static final Logger logger = LoggerFactory.getLogger(ImageController.class);

    @Value("${IMG_STORE_PATH}")
    String imgPath;

    @Value("${UPLOAD_API_URL}")
    String uploadApiUrl;

    @Value("${HISTORY_API_URL}")
    String historyApiUrl;

    @Value("${CLEAR_API_URL}")
    String clearApiUrl;

    private final ImageInfoService imageInfoService;

    public ImageController(ImageInfoService imageInfoService) {
        this.imageInfoService = imageInfoService;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void imgUpload(@RequestParam("multipartFiles") MultipartFile[] multipartFiles) {
        logger.info("开始进行图片上传");

        //TODO 判空流程
        //TODO 统一返回

        //TODO 第一步：缓存到本地
        //TODO 第二步：上传到sm.ms，收到响应报文，解析处理并保存到数据库
        //TODO 第三步：清理本地缓存，响应前端

        JSONObject jsonObject = new JSONObject(2);
        if (multipartFiles == null || multipartFiles.length == 0) {
            logger.error("没有上传任何图片");
            jsonObject.put("msg", "没有上传任何图片");
            jsonObject.put("data", new ArrayList<>());
//            return jsonObject;
            return;
        }

        List<File> list = new ArrayList<>();
        File file = null;
        int failNum = 0;

        //将上传的文件缓存至本地
        logger.info("建立临时文件缓存");
        for (MultipartFile multipartFile : multipartFiles) {
            try {
                File targetDir = new File(imgPath);
                if (!targetDir.exists()) {
                    targetDir.mkdirs();
                }
                file = new File(imgPath + "\\" + multipartFile.getOriginalFilename());
                multipartFile.transferTo(file);
                list.add(file);
            } catch (IOException e) {
                //TODO 统一异常处理
                logger.error("{}", e.getMessage());
            }
        }

        //上传至sm.ms
        logger.info("上传至http://sm.ms");
        String resp = "";
        List<Map<String, String>> data = new ArrayList<>();
        for (File tempfile : list) {
            resp = HttpUtils.doPostImage(uploadApiUrl, tempfile);
            Map<String, String> map = new HashMap<>();
            ImageInfo image = new ImageInfo();
            if (JSONObject.parseObject(resp).getBoolean("success") && "success".equals(JSONObject.parseObject(resp).getString("code"))) {
                JSONObject respData = JSONObject.parseObject(JSONObject.parseObject(resp).getString("data"));
                String filename = respData.getString("filename");
                String url = respData.getString("url");
                String delete = respData.getString("delete");
                Integer width = respData.getInteger("width");
                Integer height = respData.getInteger("height");
                String storename = respData.getString("storename");
                Integer size = respData.getInteger("size");
                String path = respData.getString("path");
                String hash = respData.getString("hash");
                String page = respData.getString("page");
                Integer fileId = respData.getInteger("file_id");

                String msg = JSONObject.parseObject(resp).getString("message");
                String requestId = JSONObject.parseObject(resp).getString("RequestId");

                image.setId(StringUtils.getUuid());
                image.setFilename(filename);
                image.setStorename(storename);
                image.setSize(String.valueOf(size));
                image.setWidth(width);
                image.setHeight(height);
                image.setHash(hash);
                image.setDeleteUrl(delete);
                image.setUrl(url);
                image.setPath(path);
                image.setStatus(1);
                image.setUserId("heartzz1");
                image.setMsg(msg);
                image.setPage(page);
                image.setFileId(fileId);
                image.setRequestId(requestId);
                image.setCreateTime(new Date());

                map.put("filename", filename);
                map.put("url", url);
                map.put("delete", delete);
            } else {
                failNum++;
                String errMsg = JSONObject.parseObject(resp).getString("message");

                image.setId(StringUtils.getUuid());
                image.setFilename(tempfile.getName());
                image.setStatus(0);
                image.setMsg(errMsg);
                image.setUserId("000000");
                image.setCreateTime(new Date());

                map.put("filename", tempfile.getName());
                map.put("errMsg", errMsg);
            }
            imageInfoService.saveImageInfo(image);
            data.add(map);
        }
        jsonObject.put("msg", "图片上传完毕， 共" + list.size() + "， 失败" + failNum);
        jsonObject.put("data", data);

        //清理本地缓存文件
        boolean delete = false;
        for (File tempfile : list) {
            if (tempfile.exists()) {
                delete = tempfile.delete();
            }
        }
        logger.info("清理本地临时文件{}", delete ? "完毕" : "失败");
//        return jsonObject;
    }

    /**
     * 查询所有图片url
     *
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<String> getAllImageInfo() {

        List<String> list = new ArrayList<>();

        List<ImageInfo> allImageInfo = imageInfoService.findAllImageInfo();
        if (allImageInfo == null || allImageInfo.size() == 0) {
            logger.info("查询所有图片 :{}", list);
            return list;
        }
        for (ImageInfo imageInfo : allImageInfo) {
            list.add(imageInfo.getUrl());
        }

        logger.info("查询所有图片 :{}", list);
        return list;
    }

    @RequestMapping(value = "/index")
    public ModelAndView imagePageIndex() {
        return new ModelAndView("image");
    }

    /**
     * 无条件 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/get/page/all")
    public List<ImageInfo> getImagePageAll(Integer pageNum, Integer pageSize) {
        logger.info("分页查询 :pageNum = {}, pageSize = {}", pageNum, pageSize);

        Page<ImageInfo> imageInfoPage = imageInfoService.findAllImageInfoPage(PageRequest.of(pageNum, pageSize, Sort.Direction.DESC, "createTime"));
        List<ImageInfo> list = new ArrayList<>();
        for (ImageInfo imageInfo : imageInfoPage) {
            list.add(imageInfo);
        }
        logger.info("分页查询 =>{}", list);
        return list;
    }

    /**
     * 根据图片名 分页 模糊查询
     *
     * @param pageNum
     * @param pageSize
     * @param imageName
     * @return
     */
    @RequestMapping(value = "/get/page")
    public List<ImageInfo> getImagePage(Integer pageNum, Integer pageSize, String imageName) {
        logger.info("分页查询（filename模糊查询） :pageNum = {}, pageSize = {}, imageName = {}", pageNum, pageSize, imageName);

        Page<ImageInfo> imageInfoPage = imageInfoService.findImageInfoPage(imageName, 1, "heartzz1", PageRequest.of(pageNum, pageSize, Sort.Direction.DESC, "createTime"));
        List<ImageInfo> list = new ArrayList<>();
        Iterator<ImageInfo> iterator = imageInfoPage.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        logger.info("分页查询（filename模糊查询） =>{}", list);
        return list;
    }
}
