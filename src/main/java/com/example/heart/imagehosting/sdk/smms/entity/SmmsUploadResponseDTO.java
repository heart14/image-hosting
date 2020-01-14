package com.example.heart.imagehosting.sdk.smms.entity;

import com.alibaba.fastjson.JSONObject;
import com.example.heart.imagehosting.sdk.smms.response.SmmsBaseResponse;

import java.io.Serializable;

/**
 * @ClassName: SmmsUploadResponseDTO
 * @Description: 图片上传结果数据传输类
 * @Author: jayhe
 * @Date: 2020/1/14 10:16
 * @Version: v1.0
 */
public class SmmsUploadResponseDTO implements Serializable {

    private static final long serialVersionUID = 7658582910414066763L;

    private Boolean success;

    private Integer fileId;

    private String filename;

    private String storename;

    private String size;

    private Integer width;

    private Integer height;

    private String hash;

    private String delete;

    private String url;

    private String path;

    private String message;

    private String page;

    private String requestId;

    public SmmsUploadResponseDTO() {
    }

    public SmmsUploadResponseDTO(SmmsBaseResponse smmsBaseResponse) {
        String data = smmsBaseResponse.getData();
        JSONObject jsonObject = JSONObject.parseObject(data);
        this.success = smmsBaseResponse.isSuccess();
        if (smmsBaseResponse.isSuccess()) {
            this.fileId = jsonObject.getInteger("file_id");
            this.filename = jsonObject.getString("filename");
            this.storename = jsonObject.getString("storename");
            this.size = jsonObject.getString("size");
            this.width = jsonObject.getInteger("width");
            this.height = jsonObject.getInteger("height");
            this.hash = jsonObject.getString("hash");
            this.delete = jsonObject.getString("delete");
            this.url = jsonObject.getString("url");
            this.path = jsonObject.getString("path");
            this.page = jsonObject.getString("page");
        }
        this.message = smmsBaseResponse.getMessage();
        this.requestId = smmsBaseResponse.getRequestId();

    }

    public SmmsUploadResponseDTO(boolean success, Integer fileId, String filename, String storename, String size, Integer width, Integer height, String hash, String delete, String url, String path, String message, String page, String requestId) {
        this.success = success;
        this.fileId = fileId;
        this.filename = filename;
        this.storename = storename;
        this.size = size;
        this.width = width;
        this.height = height;
        this.hash = hash;
        this.delete = delete;
        this.url = url;
        this.path = path;
        this.message = message;
        this.page = page;
        this.requestId = requestId;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @Override
    public String toString() {
        return "SmmsUploadResponseDTO{" +
                "success=" + success +
                ", fileId='" + fileId + '\'' +
                ", filename='" + filename + '\'' +
                ", storename='" + storename + '\'' +
                ", size='" + size + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", hash='" + hash + '\'' +
                ", delete='" + delete + '\'' +
                ", url='" + url + '\'' +
                ", path='" + path + '\'' +
                ", message='" + message + '\'' +
                ", page='" + page + '\'' +
                ", requestId='" + requestId + '\'' +
                '}';
    }
}
