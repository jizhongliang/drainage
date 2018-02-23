package com.py.intergration.util.redis;

import java.util.ResourceBundle;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.py.common.service.entity.base.BaseContants;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
    private static final String   REDISIP        = resourceBundle.getString("redis.ip");
    private static final String   REDISPORT      = resourceBundle.getString("redis.port");
    private static final String   REDISPWD       = resourceBundle.getString("redis.pwd");
    private static final String   REDISDB        = resourceBundle.getString("redis.db");
    private static Logger         logger         = LoggerFactory.getLogger(RedisUtil.class);
    private static JedisPool      jedisPool      = null;

    private String                initKey;
    private int                   time;

    public RedisUtil(String initKey, int time) {
        super();
        this.initKey = initKey;
        this.time = time;
    }

    public RedisUtil(String initKey) {
        super();
        this.initKey = initKey;
    }

    public String getInitKey() {
        return initKey;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setInitKey(String initKey) {
        this.initKey = initKey;
    }

    private static JedisPool getPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大连接数, 默认8个
        jedisPoolConfig.setMaxTotal(500);
        //最大空闲连接数, 默认8个
        jedisPoolConfig.setMaxIdle(5);
        //获取连接时的最大等待毫秒数
        jedisPoolConfig.setMaxWaitMillis(100000L);
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPool = new JedisPool(jedisPoolConfig, REDISIP, Integer.parseInt(REDISPORT), 2000,
            REDISPWD);
        return jedisPool;
    }

    public static Jedis getJedis() {
        return getPool().getResource();
    }

    private static void returnResource(JedisPool jedisPool, Jedis jedis) {
        if (jedis != null)
            jedis.close();
    }

    public static void closeJedis(Jedis jedis) {
        returnResource(getPool(), jedis);
    }

    public String get(String key) {
        String value = null;
        JedisPool jedisPool = null;
        Jedis jedis = null;
        try {
            jedisPool = getPool();
            jedis = (Jedis) jedisPool.getResource();
            jedis.select(Integer.parseInt(REDISDB));//操作redis的第15个库，redis默认有16个库。
            value = jedis.get(initKey + BaseContants.UNDER_LINE + key);
        } catch (Exception ex) {
            logger.info("{}", ex);
            jedis.close();
        } finally {
            returnResource(jedisPool, jedis);
        }
        return value;
    }

    public Object getObject(String key) {
        byte[] value = null;
        JedisPool jedisPool = null;
        Jedis jedis = null;
        try {
            jedisPool = getPool();
            jedis = (Jedis) jedisPool.getResource();
            jedis.select(Integer.parseInt(REDISDB));
            value = jedis.get(key.getBytes());
        } catch (Exception ex) {
            logger.info("{}", ex.getMessage());
            jedis.close();
        } finally {
            returnResource(jedisPool, jedis);
        }
        return SerializeUtil.serialize(value);
    }

    public Long set(String key, String value) {
        JedisPool jedisPool = null;
        Jedis jedis = null;
        Long res = 0L;
        try {
            jedisPool = getPool();
            jedis = (Jedis) jedisPool.getResource();
            jedis.select(Integer.parseInt(REDISDB));
            res = jedis.setnx(initKey + BaseContants.UNDER_LINE + key, value);
            if (res > 0) {
                jedis.expire(initKey + BaseContants.UNDER_LINE + key, time);
            }
        } catch (Exception ex) {
            logger.info("{}", ex.getMessage());
            jedis.close();
        } finally {
            returnResource(jedisPool, jedis);
        }
        return res;
    }

    public Long set(String key, String value, Integer seconds) {
        JedisPool jedisPool = null;
        Jedis jedis = null;
        Long res = 0L;
        try {
            jedisPool = getPool();
            jedis = (Jedis) jedisPool.getResource();
            jedis.select(Integer.parseInt(REDISDB));
            jedis.setex(initKey + BaseContants.UNDER_LINE + key, seconds, value);
            jedis.expire(initKey + BaseContants.UNDER_LINE + key, time);
        } catch (Exception ex) {
            logger.info("{}", ex.getMessage());
            jedis.close();
        } finally {
            returnResource(jedisPool, jedis);
        }
        return res;
    }

    public void setex(String key, String value) {
        JedisPool jedisPool = null;
        Jedis jedis = null;
        try {
            jedisPool = getPool();
            jedis = (Jedis) jedisPool.getResource();
            jedis.select(Integer.parseInt(REDISDB));
            jedis.setex(initKey + BaseContants.UNDER_LINE + key, time, value);
        } catch (Exception ex) {
            logger.info("{}", ex.getMessage());
            jedis.close();
        } finally {
            returnResource(jedisPool, jedis);
        }
    }

    public void del(String key) {
        JedisPool jedisPool = null;
        Jedis jedis = null;
        try {
            jedisPool = getPool();
            jedis = (Jedis) jedisPool.getResource();
            jedis.select(Integer.parseInt(REDISDB));
            jedis.del(initKey + BaseContants.UNDER_LINE + key);

        } catch (Exception ex) {
            logger.info("{}", ex.getMessage());
            jedis.close();
        } finally {
            returnResource(jedisPool, jedis);
        }
    }

    public void setObject(String key, Object o) {
        JedisPool jedisPool = null;
        Jedis jedis = null;
        try {
            jedisPool = getPool();
            jedis = (Jedis) jedisPool.getResource();
            jedis.select(Integer.parseInt(REDISDB));
            jedis.set(key.getBytes(), SerializeUtil.serialize(o));
        } catch (Exception ex) {
            logger.info("{}", ex.getMessage());
            jedis.close();
        } finally {
            returnResource(jedisPool, jedis);
        }
    }

    /**
     * @param beforeKey
     * @return
     * @Description: 获得redis中所有的key
     * @Detail:（方法详细描述）
     */
    public static Set<String> getKeys(String beforeKey) {
        Set<String> keys = null;
        JedisPool jedisPool = null;
        Jedis jedis = null;
        try {
            jedisPool = getPool();
            jedis = (Jedis) jedisPool.getResource();
            jedis.select(Integer.parseInt(REDISDB));
            keys = jedis.keys(beforeKey + "*");
        } catch (Exception ex) {
            logger.info("{}", ex.getMessage());
            jedis.close();
        } finally {
            returnResource(jedisPool, jedis);
        }
        return keys;
    }

    public static void flushDb() {
        JedisPool jedisPool = null;
        Jedis jedis = null;
        try {
            jedisPool = getPool();
            jedis = (Jedis) jedisPool.getResource();
            jedis.select(Integer.parseInt(REDISDB));
            jedis.flushDB();
        } catch (Exception ex) {
            logger.info("{}", ex.getMessage());
            jedis.close();
        } finally {
            returnResource(jedisPool, jedis);
        }
    }

    //获取map中一个值
    public static String hget(String key, String field) {
        String value = null;
        JedisPool jedisPool = null;
        Jedis jedis = null;
        try {
            jedisPool = getPool();
            jedis = (Jedis) jedisPool.getResource();
            jedis.select(Integer.parseInt(REDISDB));//操作redis的第15个库，redis默认有16个库。
            value = jedis.hget(key, field);
            if ("nil".equals(value)) {
                value = "";
            }
        } catch (Exception ex) {
            logger.info("{}", ex.getMessage());
            jedis.close();
        } finally {
            returnResource(jedisPool, jedis);
        }
        return value;
    }

    public void incr(String key) {
        JedisPool jedisPool = null;
        Jedis jedis = null;
        try {
            jedisPool = getPool();
            jedis = (Jedis) jedisPool.getResource();
            jedis.select(Integer.parseInt(REDISDB));//操作redis的第15个库，redis默认有16个库。
            jedis.incr(initKey + BaseContants.UNDER_LINE + key);
        } catch (Exception ex) {
            logger.info("{}", ex.getMessage());
            jedis.close();
        } finally {
            returnResource(jedisPool, jedis);
        }
    }
}
