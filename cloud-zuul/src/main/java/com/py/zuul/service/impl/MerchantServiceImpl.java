/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.zuul.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.py.common.exception.ParamterException;
import com.py.common.service.entity.merchant.response.MerchantPermissionVO;
import com.py.common.utils.ParamUtil;
import com.py.zuul.base.entity.ValidateMerchantRequest;
import com.py.zuul.client.MerchantClient;
import com.py.zuul.client.RedisClient;
import com.py.zuul.service.MerchantService;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantServiceImpl.java, v 0.1 2017年12月15日 下午5:45:06 jinlilong Exp $
 */
@Service
public class MerchantServiceImpl implements MerchantService {
    /**  */
    private static Logger       logger       = LoggerFactory.getLogger(MerchantServiceImpl.class);

    /**  */
    public static final String  REDIS_PREFIX = "merchant";

    /**  */
    private static final String REDIS_KEY    = "permission_";

    /**  */
    private static final long   REDIS_TIME   = 24 * 60 * 60;

    /**  */
    @Autowired
    private MerchantClient      merchantClient;

    /**  */
    @Autowired
    private RedisClient         redisClient;

    /** 
     * @see com.py.zuul.service.MerchantService#queryMerchantPermission(java.lang.String)
     */
    @Override
    public boolean queryMerchantPermission(ValidateMerchantRequest req) {

        if (ParamUtil.isEmpty(req.getMerchantCode())) {
            logger.warn("商户号不能为空", req);
            throw new ParamterException("商户号不能为空");
        }

        MerchantPermissionVO merchantPermissionVO = null;
        String data = redisClient.get(REDIS_PREFIX, REDIS_KEY + req.getMerchantCode());
        if (data == null) {
            merchantPermissionVO = merchantClient.queryMerchantPermission(req.getMerchantCode());
            redisClient.set(REDIS_PREFIX, REDIS_KEY + req.getMerchantCode(),
                JSONObject.toJSONString(merchantPermissionVO), String.valueOf(REDIS_TIME));
        } else {
            merchantPermissionVO = JSONObject.parseObject(data, MerchantPermissionVO.class);
        }
        List<String> url = merchantPermissionVO.getUrl();
        if (CollectionUtils.isEmpty(url) || !url.contains(req.getUrl())) {
            return false;
        }
        List<String> ip = merchantPermissionVO.getIncludeIps();
        if (CollectionUtils.isEmpty(ip) || !ip.contains(req.getIp())) {
            return false;
        }
        return true;
    }

}
