package com.tongfu.idoccloud.preposition.utils;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/1/16 14:25
 */
public class DbUtil {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static String getDbName(){
        return threadLocal.get();
    }
    public static void  setDbName(String dbName){
        threadLocal.set(dbName);
    }
    public static void cleanDbName(){
        threadLocal.remove();
    }
}
