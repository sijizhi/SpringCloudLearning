package com.tongfu.idoccloud.system.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/3/13 10:42
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Setter
@Getter
@ToString
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    private  String headPortrait;
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
    private Integer createBy;
    /**
     *修改时间
     */
    private Date updateDate;
    /**
     *修改人
     */
    private Integer updateBy;
    /**
     * 客户公司-用户-访问的数据库
     */
    private  String db_name;
    /**
     * 令牌
     */
    private String idoc_token;
    /**
     * ip地址
     */
    private String ip;
    /**
     * 设备号
     */
    private String deviceNumber;

    public User() {
    }




}
