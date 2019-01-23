package com.example.pagehelper.entity;

import java.util.Date;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/1/23 21:20
 */
public class Document {
    private int documentId;
    private String    title;
    private int departId;
    private String      doc_uuid;
    private int levelId;
    private String      updateReason;
    private String updateContent;
    private int     presentVersion;
    private int highestVersion;
    private int      isView;
    private int isDownload;
    private int      isHardCopy;
    private int isForeignFile;
    private  String      location;
    private Date publishDate;
    private Date disAbleDate;
    private int userId;
    private Date create_Date;
    private String create_By;
    private  Date      update_Date;
    private String update_By;
    private  int      status;

    public Document() {
    }

    public Document(String title, int departId, String doc_uuid, int levelId, int userId) {
        this.title = title;
        this.departId = departId;
        this.doc_uuid = doc_uuid;
        this.levelId = levelId;
        this.userId = userId;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public String getDoc_uuid() {
        return doc_uuid;
    }

    public void setDoc_uuid(String doc_uuid) {
        this.doc_uuid = doc_uuid;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getUpdateReason() {
        return updateReason;
    }

    public void setUpdateReason(String updateReason) {
        this.updateReason = updateReason;
    }

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }

    public int getPresentVersion() {
        return presentVersion;
    }

    public void setPresentVersion(int presentVersion) {
        this.presentVersion = presentVersion;
    }

    public int getHighestVersion() {
        return highestVersion;
    }

    public void setHighestVersion(int highestVersion) {
        this.highestVersion = highestVersion;
    }

    public int getIsView() {
        return isView;
    }

    public void setIsView(int isView) {
        this.isView = isView;
    }

    public int getIsDownload() {
        return isDownload;
    }

    public void setIsDownload(int isDownload) {
        this.isDownload = isDownload;
    }

    public int getIsHardCopy() {
        return isHardCopy;
    }

    public void setIsHardCopy(int isHardCopy) {
        this.isHardCopy = isHardCopy;
    }

    public int getIsForeignFile() {
        return isForeignFile;
    }

    public void setIsForeignFile(int isForeignFile) {
        this.isForeignFile = isForeignFile;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getDisAbleDate() {
        return disAbleDate;
    }

    public void setDisAbleDate(Date disAbleDate) {
        this.disAbleDate = disAbleDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreate_Date() {
        return create_Date;
    }

    public void setCreate_Date(Date create_Date) {
        this.create_Date = create_Date;
    }

    public String getCreate_By() {
        return create_By;
    }

    public void setCreate_By(String create_By) {
        this.create_By = create_By;
    }

    public Date getUpdate_Date() {
        return update_Date;
    }

    public void setUpdate_Date(Date update_Date) {
        this.update_Date = update_Date;
    }

    public String getUpdate_By() {
        return update_By;
    }

    public void setUpdate_By(String update_By) {
        this.update_By = update_By;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
