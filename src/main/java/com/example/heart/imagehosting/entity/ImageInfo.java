package com.example.heart.imagehosting.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "IMAGE_INFO")
public class ImageInfo {

    @Id
    private String id;

    @Column(name = "filename")
    private String filename;

    @Column(name = "storename")
    private String storename;

    @Column(name = "size")
    private String size;

    @Column(name = "width")
    private Integer width;

    @Column(name = "height")
    private Integer height;

    @Column(name = "hash")
    private String hash;

    @Column(name = "delete_url")
    private String deleteUrl;

    @Column(name = "url")
    private String url;

    @Column(name = "path")
    private String path;

    @Column(name = "msg")
    private String msg;

    @Column(name = "status")
    private Integer status;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "page")
    private String page;

    @Column(name = "file_id")
    private Integer fileId;

    @Column(name = "request_id")
    private String requestId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDeleteUrl() {
        return deleteUrl;
    }

    public void setDeleteUrl(String deleteUrl) {
        this.deleteUrl = deleteUrl;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ImageInfo{" +
                "id='" + id + '\'' +
                ", filename='" + filename + '\'' +
                ", storename='" + storename + '\'' +
                ", size='" + size + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", hash='" + hash + '\'' +
                ", deleteUrl='" + deleteUrl + '\'' +
                ", url='" + url + '\'' +
                ", path='" + path + '\'' +
                ", msg='" + msg + '\'' +
                ", status=" + status +
                ", userId='" + userId + '\'' +
                ", page='" + page + '\'' +
                ", fileId=" + fileId +
                ", requestId='" + requestId + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}