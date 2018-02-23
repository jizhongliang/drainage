/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.zuul.client.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.py.common.enums.ServiceNameEnums;
import com.py.common.service.entity.base.BaseContants;
import com.py.common.service.entity.intergration.urls.RedisUrlContants;
import com.py.zuul.client.RedisClient;

/**
 * 
 * @author jinlilong
 * @version $Id: RedisClientImpl.java, v 0.1 2017年12月16日 下午4:55:41 jinlilong Exp $
 */
@Component
public class RedisClientImpl implements RedisClient {

    /**  */
    private static Logger logger = LoggerFactory.getLogger(RedisClientImpl.class);

    /**  */
    @Autowired
    RestTemplate          restTemplate;

    /** 
     * @see com.py.zuul.client.RedisClient#present(java.lang.String, java.lang.String)
     */
    @Override
    public boolean present(String prefix, String key) {
        String url = BaseContants.HTTP + ServiceNameEnums.CLOUD_INTERGRATION.getCode()
                     + RedisUrlContants.PRESENT + "?prefix=" + prefix + "&key=" + key;
        boolean state = false;
        try {
            state = restTemplate.getForObject(url, Boolean.class);
        } catch (Exception e) {
            logger.error("redis服务查询异常", e);
            throw new RuntimeException("redis服务查询异常");
        }
        return state;
    }

    /** 
     * @see com.py.zuul.client.RedisClient#set(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public boolean set(String prefix, String key, String data, String time) {

        String url = BaseContants.HTTP + ServiceNameEnums.CLOUD_INTERGRATION.getCode()
                     + RedisUrlContants.SET + "?prefix=" + prefix + "&key=" + key + "&value=" + data
                     + "&time=" + time;
        boolean state = false;
        try {
            state = restTemplate.getForObject(url, Boolean.class);
        } catch (Exception e) {
            logger.error("redis服务存储信息异常", e);
            throw new RuntimeException("redis服务存储信息异常");
        }
        return state;
    }

    /** 
     * @see com.py.zuul.client.RedisClient#get(java.lang.String, java.lang.String)
     */
    @Override
    public String get(String prefix, String key) {
        String url = BaseContants.HTTP + ServiceNameEnums.CLOUD_INTERGRATION.getCode()
                     + RedisUrlContants.GET + "?prefix=" + prefix + "&key=" + key;
        String data = null;
        try {
            data = restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            logger.error("redis服务查询信息异常", e);
            throw new RuntimeException("redis服务查询信息异常");
        }
        return data;
    }

}
