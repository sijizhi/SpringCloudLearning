package com.tongfu.idoccloud.zuul.enums;

import lombok.Getter;

/**
 * 前端控制器响应枚举类
 * @Author: Sijie Zhi
 * @Date: 2019/3/14 16:14
 */
@Getter
public enum ResponseEnums {
    /**
     * 0  成功
     */
    OK(0, "OK"),
    /**
     * 400 参数错误
     */
    PARAM_ERROR(400, "PARAM ERROR"),
    LOGIN_ERROR(401,"登录超时"),
    /**
     *500  错误
     */
    ERROR(500, "ERROR"),
    NO_DATA(700, "数据找不到了"),
    INSERT_ERROR(800,"INSERT ERROR"),
    UPDATE_ERROR(801,"UPDATE ERROR"),
    DELETE_ERROR(802,"DELETE ERROR"),
    /* 业务错误 */

    ;

    /**
     * 响应码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;

    ResponseEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
