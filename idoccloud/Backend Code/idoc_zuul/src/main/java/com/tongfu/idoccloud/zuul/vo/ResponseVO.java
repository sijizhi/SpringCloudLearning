package com.tongfu.idoccloud.zuul.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tongfu.idoccloud.zuul.enums.ResponseEnums;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 响应视图对象
 * @Author: Sijie Zhi
 * @Date: 2019/3/14 16:12
 */
@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseVO {
    public Integer code;
    private String msg;
    private Object data;
    private Integer count;

    /**
     * 简单异常构造方法【无返回值】
     *
     * @param code
     * @param msg
     */
    public ResponseVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 简单构造方法【无返回值】
     *
     * @param responseEnums
     */
    public ResponseVO(ResponseEnums responseEnums) {
        this.code = responseEnums.getCode();
        this.msg = responseEnums.getMsg();
    }

    /**
     * 常规返回值【带返回值】
     *
     * @param responseEnums
     * @param data
     */
    public ResponseVO(ResponseEnums responseEnums, Object data) {
        this.code = responseEnums.getCode();
        this.msg = responseEnums.getMsg();
        this.data = data;
    }

    /**
     * 多用于分页列表展示
     *
     * @param responseEnums
     * @param data
     * @param count
     */
    public ResponseVO(ResponseEnums responseEnums, Object data, Integer count) {
        this.code = responseEnums.getCode();
        this.msg = responseEnums.getMsg();
        this.data = data;
        this.count = count;
    }

}
