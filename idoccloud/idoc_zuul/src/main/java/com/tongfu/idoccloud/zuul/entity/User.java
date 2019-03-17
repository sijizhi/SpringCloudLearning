package com.tongfu.idoccloud.zuul.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/3/13 10:42
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Setter
@Getter
public class User {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户中文名
     */
    private String chineseName;
    /**
     *用户英文名
     */
    private String englishName;
    /**
     *部门id
     */
    private Integer departId;
    /**
     *科室id
     */
    private Integer sectionId;
    /**
     *职位id
     */
    private Integer positionId;
    /**
     *状态，0是逻辑删除，1是有效状态
     */
    private Integer status;
    /**
     *用户账号
     */
    private String userCode;
    /**
     *用户密码
     */
    private String password;
    /**
     *是否初次登录
     */

    private Integer initStatus;
    /**
     *电话号码
     */
    private String phone;
    /**
     * 头像路径
     */
    private  String head_portrait;

    public String getHead_portrait() {
        return head_portrait;
    }

    public void setHead_portrait(String head_portrait) {
        this.head_portrait = head_portrait;
    }

    /**
     *邮箱
     */
    private String email;
    /**
     *主题
     */
    private String theme;
    /**
     *验证码
     */
    private String verisicationCode;
    /**
     *创建时间
     */
    private Date createDate;
    /**
     *创建人
     */
    private String createBy;
    /**
     *修改时间
     */
    private Date updateDate;
    /**
     *修改人
     */
    private String updateBy;


    /**
     * 客户公司-用户-访问的数据库
     */
    private  String db_name;

    /**
     * 令牌
     */
    private String idoc_token;

    public String getIdoc_token() {
        return idoc_token;
    }

    public void setIdoc_token(String idoc_token) {
        this.idoc_token = idoc_token;
    }

    public User() {
    }

    public String getDb_name() {
        return db_name;
    }

    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getInitStatus() {
        return initStatus;
    }

    public void setInitStatus(Integer initStatus) {
        this.initStatus = initStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getVerisicationCode() {
        return verisicationCode;
    }

    public void setVerisicationCode(String verisicationCode) {
        this.verisicationCode = verisicationCode;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public User(Integer userId, String chineseName, String englishName, Integer departId, Integer sectionId, Integer positionId, Integer status, String userCode, String password, Integer initStatus, String phone, String head_portrait, String email, String theme, String verisicationCode, Date createDate, String createBy, Date updateDate, String updateBy, String db_name, String idoc_token) {
        this.userId = userId;
        this.chineseName = chineseName;
        this.englishName = englishName;
        this.departId = departId;
        this.sectionId = sectionId;
        this.positionId = positionId;
        this.status = status;
        this.userCode = userCode;
        this.password = password;
        this.initStatus = initStatus;
        this.phone = phone;
        this.head_portrait = head_portrait;
        this.email = email;
        this.theme = theme;
        this.verisicationCode = verisicationCode;
        this.createDate = createDate;
        this.createBy = createBy;
        this.updateDate = updateDate;
        this.updateBy = updateBy;
        this.db_name = db_name;
        this.idoc_token = idoc_token;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userCode='" + userCode + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
