package com.tongfu.idoccloud.preposition.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 日志类
 * @Author: Sijie Zhi
 * @Date: 2019/3/18 16:02
 */
@Setter
@Getter
public class LoggerEntity {
    /**
     * 日志id
     */
    private Integer loggerId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     *用户名称
     */
    private String userName;
    /**
     *ip地址
     */
    private String userIp;
    /**
     *请求服务
     */
    private String requestService;
    /**
     *接口
     */
    private String requestApi;
    /**
     *描述
     */
    private String description;
    /**
     *部门
     */
    private Integer departId;
    /**
     *文档id
     */
    private Integer docId;
    /**
     *操作
     */
    private Integer docOperation;
    /**
     *目标id
     */
    private Integer targetId;
    /**
     *创建时间
     */
    private Date createDate;
    /**
     * 操作
     */
    private String operation;
}
