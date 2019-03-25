package com.tongfu.idoccloud.preposition.utils;

import com.tongfu.idoccloud.preposition.enums.ResponseEnums;
import com.tongfu.idoccloud.preposition.vo.ResponseVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 响应工具类
 * @Author: Sijie Zhi
 * @Date: 2019/3/14 17:03
 */
@Getter
@Setter
@ToString
public class ResponseUtil {
    /**
     * 成功
     * @return
     */
    public static ResponseVO success() {
        return new ResponseVO(ResponseEnums.OK);
    }

    /**
     * 成功-带返回值
     * @param data
     * @return
     */
    public static ResponseVO success(Object data) {
        return new ResponseVO(ResponseEnums.OK, data);
    }

    /**
     * 成功-带分页数据的返回值
     *
     * @param data
     * @return
     */
    public static ResponseVO success(Object data, int count) {
        return new ResponseVO(ResponseEnums.OK, data, count);
    }

    /**
     * 参数错误
     * @param errorJson
     * @return
     */
    public static ResponseVO parameterError(String errorJson) {
        return new ResponseVO(ResponseEnums.PARAM_ERROR, errorJson);
    }

    /**
     * 【推荐】错误提示-自定义枚举类
     * @param responseEnums
     * @return
     */
    public static ResponseVO error(ResponseEnums responseEnums) {
        return new ResponseVO(responseEnums);
    }

    /**
     * 有现成的异常代码和异常提示信息时推荐调用此方法
     * @param code
     * @param msg
     * @return
     */
    public static ResponseVO error(Integer code, String msg) {
        return new ResponseVO(code, msg);
    }
}
