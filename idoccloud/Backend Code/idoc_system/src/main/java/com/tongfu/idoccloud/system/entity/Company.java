package com.tongfu.idoccloud.system.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/3/20 13:43
 */
@Setter
@Getter
@ToString
public class Company {
    /**
     * 公司id
     */
    private Integer companyId;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 公司英文名
     */
    private String enName;
    /**
     * 公司注册码
     */
    private String registUuid;
    /**
     *公司状态
     */
    private Byte status;
    /**
     *公司logo
     */
    private String logo;
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
     * 令牌
     */
    private String idoc_token;
    /**
     * 用户id
     */
    private Integer userId;
}
