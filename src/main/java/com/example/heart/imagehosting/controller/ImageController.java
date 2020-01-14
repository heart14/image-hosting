package com.example.heart.imagehosting.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.heart.imagehosting.common.SysErrorCode;
import com.example.heart.imagehosting.entity.ImageInfo;
import com.example.heart.imagehosting.exception.AppBizException;
import com.example.heart.imagehosting.exception.SysResponse;
import com.example.heart.imagehosting.sdk.smms.entity.SmmsUploadResponseDTO;
import com.example.heart.imagehosting.service.ImageInfoService;
import com.example.heart.imagehosting.service.ImageService;
import com.example.heart.imagehosting.utils.SysResponseUtils;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    private final ImageService imageService;

    private final ImageInfoService imageInfoService;

    public ImageController(ImageInfoService imageInfoService, ImageService imageService) {
        this.imageInfoService = imageInfoService;
        this.imageService = imageService;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public SysResponse imgUpload(@RequestParam("multipartFiles") MultipartFile[] multipartFiles) {
        logger.info("开始进行图片上传");
        JSONObject jsonObject = new JSONObject(2);
        if (multipartFiles == null || multipartFiles.length == 0) {
            logger.error("图片不存在");
            return SysResponseUtils.fail(SysErrorCode.UnknownParamException.getCode(), SysErrorCode.UnknownParamException.getMsg());
        }

        String userId = "yoursheart";
        File file;
        int fileNum = 0;
        int failNum = 0;
        JSONObject data = new JSONObject();

        for (MultipartFile multipartFile : multipartFiles) {
            try {
                File targetDir = new File(imgPath);
                if (!targetDir.exists()) {
                    targetDir.mkdirs();
                }
                file = new File(imgPath + "\\" + multipartFile.getOriginalFilename());
                multipartFile.transferTo(file);
                fileNum++;
            } catch (IOException e) {
                logger.error("文件缓存失败 :{}", e.getMessage());
                throw new AppBizException(SysErrorCode.ImageUploadException.getCode(), SysErrorCode.ImageUploadException.getMsg());
            }
            SmmsUploadResponseDTO smmsUploadResponseDTO = imageService.uploadImage(file, userId);
            if (!smmsUploadResponseDTO.getSuccess()) {
                failNum++;
                data.put("filename", multipartFile.getOriginalFilename());
                data.put("error_desc", smmsUploadResponseDTO.getMessage());
            }
        }
        logger.info("图片上传完毕， 共" + fileNum + "， 失败" + failNum);
        return SysResponseUtils.success(SysErrorCode.SUCCESS.getCode(), "图片上传完毕， 共" + fileNum + "， 失败" + failNum, data);
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
