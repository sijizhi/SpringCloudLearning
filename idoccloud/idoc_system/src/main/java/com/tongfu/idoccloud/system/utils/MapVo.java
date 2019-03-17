package com.tongfu.idoccloud.system.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/3/17 20:31
 */
public class MapVo {

    public static Map<String,Object> returnMap(String key,Object value){
        Map<String ,Object> map=new HashMap<>();
        map.put(key,value);
        return map;

    }
}
