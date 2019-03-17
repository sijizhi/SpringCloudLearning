package com.tongfu.idoccloud.preposition.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @Author: Sijie Zhi
 * @Date: 2018/12/19 11:04
 */
public class ResultData implements Serializable {
    private static final long serialVersionUID = 1L;

    //状态码,0表示成功，-1表示失败
    private int code;

    //结果
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    //错误描述
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultData(int code, Object data) {
        super();
        this.code = code;
        this.data = data;
    }

    public ResultData(int code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultData(Object data) {
        this.data = data;
    }
}
