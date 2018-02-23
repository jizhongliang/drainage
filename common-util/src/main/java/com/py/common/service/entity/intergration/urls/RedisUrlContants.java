/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.common.service.entity.intergration.urls;

/**
 * 
 * @author jinlilong
 * @version $Id: RedisUrlContants.java, v 0.1 2017年12月16日 下午4:35:31 jinlilong Exp $
 */
public class RedisUrlContants {

    /**  判断是否存在，如果存在返回false，如果不存在返回true*/
    public static final String PRESENT = "/redis/present";

    /**  判断加存储 返回true说明已存在，没有存进去；返回false说明存储成功，原先不存在*/
    public static final String EXIST   = "/redis/exist";

    /**  直接存储*/
    public static final String SET     = "/redis/set";

    /**  获取 根据key获取value*/
    public static final String GET     = "/redis/get";

    /**  删除key*/
    public static final String DEL     = "/redis/del";

}
