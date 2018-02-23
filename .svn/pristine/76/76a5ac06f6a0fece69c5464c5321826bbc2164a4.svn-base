package com.py.intergration.util.redis;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class RedisLock {

    public static RedisUtil refundOrderRedis;
    public static RedisUtil refundWhiteListRedis;
    public static RedisUtil userRouteOrderSn;//订单关联行程详情
    public static RedisUtil depositBlankListRedis;
    public static RedisUtil unlockBikeBikeSn;
    public static RedisUtil unlockBikeUid;



    static {

        refundOrderRedis =  new RedisUtil("refundOrderRedis-", 24 * 60 * 60);//退款订单号
        refundWhiteListRedis  =  new RedisUtil("refundWhiteListRedis-", 10 * 365 * 24 * 60 * 60);//退款白名单
        userRouteOrderSn = new RedisUtil("userRouteOrderSn-", 24 * 60 * 60);    //订单号前缀，用户行程
        depositBlankListRedis =  new RedisUtil("depositBlankListRedis-", 10 * 365 * 24 * 60 * 60);//充押金黑名单
        unlockBikeBikeSn =  new RedisUtil("unlockBikeBikeSn-", 15);//创建骑行订单
        unlockBikeUid =  new RedisUtil("unlockBikeUid-", 15);//创建骑行订单
    }

    /**
     * @param beforeKey
     * @return
     * @Description: 获取redis对象中所有的id
     * @Detail:（方法详细描述）
     */
    public static List<Long> getAllKeys(String beforeKey) {
        List<Long> allKeys = new ArrayList<Long>();
        Set<String> keys = RedisUtil.getKeys(beforeKey);
        for (String key : keys) {
            allKeys.add(Long.valueOf(key.substring(beforeKey.length())));
        }
        return allKeys;
    }

    public static boolean present(RedisUtil redis, String orderno) {

        String boo = redis.get(orderno + "");
        if (StringUtils.isEmpty(boo)) {
            return true;
        }
        return false;

    }

    public static boolean exist(RedisUtil redis, String key) {

        if (redis.set(key, "true") > 0) {
            return false;
        }
        return true;

    }

    public static boolean set(RedisUtil redis, String key, String value) {
        if (redis.set(key, value) > 0) {
            return true;
        }
        return false;
    }

    public static boolean set(RedisUtil redis, String key, String value, Integer seconds) {
        if (redis.set(key, value, seconds) > 0) {
            return true;
        }
        return false;
    }

    public static String get(RedisUtil redis, String key){
        String value = redis.get(key + "");
        return value;
    }


}
