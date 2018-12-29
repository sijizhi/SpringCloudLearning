package com.example.order_server.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 封装redis常用方法 redis工具类
 * @Author: Sijie Zhi
 * @Date: 2018/11/14 11:42
 */
@Component
public class RedisClient {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * redis 设置键值 key-value
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key ,String value){
        try{
            stringRedisTemplate.opsForValue().set(key, value);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 设置key-value-time
     * @param key
     * @param value
     * @param time
     * @return
     */
    public boolean set(String key ,String value ,int time){
        try{
            stringRedisTemplate.opsForValue().set(key,value , time,  TimeUnit.SECONDS);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除key
     * @param key
     * @return
     */
    public boolean delete(String key){
        try{
            stringRedisTemplate.delete(key);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 通过字符串key获取值
     * @param key 键
     * @return 值
     */
    public String get(String key){
        return key==null?null:stringRedisTemplate.opsForValue().get(key);
    }



	/**
	 * 功能描述：设置某个key过期时间
	 * @param key
	 * @param time
	 * @return
	 */
	  public boolean expire(String key,long time){
	        try {
	            if(time>0){
                    stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
	            }
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }




	  /**
	   * 功能描述：根据key 获取过期时间
	   * @param key
	   * @return
	   */
	  public long getExpire(String key){
	        return stringRedisTemplate.getExpire(key,TimeUnit.SECONDS);
	    }


	  	/**
	     * 递增
	     * @param key 键
	     * @return
	     */
	    public long incr(String key, long delta){
	        return stringRedisTemplate.opsForValue().increment(key, delta);
	    }


	    /**
	     * 递减
	     * @param key 键
	     * @param delta 要减少几
	     * @return
	     */
	    public long decr(String key, long delta){
	        return stringRedisTemplate.opsForValue().increment(key, -delta);
	    }
//
//	    //==============Map结构=====================
//
//
//	    //==============List结构=====================
//
//
//

}
