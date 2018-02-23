package com.py.intergration.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.py.common.service.entity.intergration.urls.RedisUrlContants;
import com.py.intergration.util.ParamUtil;
import com.py.intergration.util.redis.RedisLock;
import com.py.intergration.util.redis.RedisUtil;

/**
 * Created by jzl on 17/12/15.
 */
@RestController
public class RedisController {

    private static final String INITTIME = "86400";//单位秒

    /**
     * 判断是否存在，如果存在返回false，如果不存在返回true
     * @param prefix
     * @param key
     * @return
     */
    @ResponseBody
    @RequestMapping(value = RedisUrlContants.PRESENT, method = { RequestMethod.POST,
                                                                 RequestMethod.GET })
    public boolean present(@RequestParam("prefix") String prefix, @RequestParam("key") String key) {
        if (ParamUtil.isEmpty(prefix) || ParamUtil.isEmpty(key)) {
            return false;
        }
        RedisUtil redisUtil = new RedisUtil(prefix);
        return RedisLock.present(redisUtil, key);
    }

    /**
     * 判断加存储 返回true说明已存在，没有存进去；返回false说明存储成功，原先不存在
     * @param prefix
     * @param time 秒
     * @param key
     * @return
     */
    @ResponseBody
    @RequestMapping(value = RedisUrlContants.EXIST, method = { RequestMethod.POST,
                                                               RequestMethod.GET })
    public boolean exist(@RequestParam("prefix") String prefix, @RequestParam("time") String time,
                         @RequestParam("key") String key) {
        if (ParamUtil.isEmpty(prefix) || ParamUtil.isEmpty(key)) {
            return false;
        }
        if (ParamUtil.isEmpty(time)) {
            time = INITTIME;
        }
        int timeOv = Integer.parseInt(time);
        RedisUtil redisUtil = new RedisUtil(prefix, timeOv);
        return RedisLock.exist(redisUtil, key);
    }

    /**
     * 直接存储
     * @param prefix
     * @param time
     * @param key
     * @param value
     * @return
     */
    @ResponseBody
    @RequestMapping(value = RedisUrlContants.SET, method = { RequestMethod.POST,
                                                             RequestMethod.GET })
    public boolean set(@RequestParam("prefix") String prefix, @RequestParam("time") String time,
                       @RequestParam("key") String key, @RequestParam("value") String value) {
        if (ParamUtil.isEmpty(prefix) || ParamUtil.isEmpty(key) || ParamUtil.isEmpty(value)) {
            return false;
        }
        if (ParamUtil.isEmpty(time)) {
            time = INITTIME;
        }
        int timeOv = Integer.parseInt(time);
        RedisUtil redisUtil = new RedisUtil(prefix, timeOv);
        return RedisLock.set(redisUtil, key, value);
    }

    /**
     * 获取 根据key获取value
     * @param prefix
     * @param key
     * @return
     */
    @ResponseBody
    @RequestMapping(value = RedisUrlContants.GET, method = { RequestMethod.POST,
                                                             RequestMethod.GET })
    public String get(@RequestParam("prefix") String prefix, @RequestParam("key") String key) {
        if (ParamUtil.isEmpty(prefix) || ParamUtil.isEmpty(key)) {
            return null;
        }
        RedisUtil redisUtil = new RedisUtil(prefix);
        return RedisLock.get(redisUtil, key);
    }

    /**
     * 删除key
     * @param prefix
     * @param key
     * @return
     */
    @ResponseBody
    @RequestMapping(value = RedisUrlContants.DEL, method = { RequestMethod.POST,
                                                             RequestMethod.GET })
    public boolean del(@RequestParam("prefix") String prefix, @RequestParam("key") String key) {
        if (ParamUtil.isEmpty(prefix) || ParamUtil.isEmpty(key)) {
            return false;
        }
        RedisUtil redisUtil = new RedisUtil(prefix);
        redisUtil.del(key);
        return true;
    }
}
