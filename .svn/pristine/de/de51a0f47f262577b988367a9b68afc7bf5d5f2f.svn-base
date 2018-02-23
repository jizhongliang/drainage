/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.zuul.client;

/**
 * 
 * @author jinlilong
 * @version $Id: RedisClient.java, v 0.1 2017年12月16日 下午4:41:28 jinlilong Exp $
 */
public interface RedisClient {

    /**
     * redis查询是否存在值
     * @param prefix
     * @param key
     * @return
     */
    public boolean present(String prefix, String key);

    /**
     * 缓存数据
     * @param prefix
     * @param key
     * @param time
     * @return
     */
    public boolean set(String prefix, String key, String data, String time);

    /**
     * 获取数据
     * @param prefix
     * @param key
     * @return
     */
    public String get(String prefix, String key);

}
