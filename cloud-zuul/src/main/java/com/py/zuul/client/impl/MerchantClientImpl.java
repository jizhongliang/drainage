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
import com.py.common.service.entity.merchant.response.MerchantPermissionVO;
import com.py.common.service.entity.merchant.urls.MerchantUrlConstants;
import com.py.zuul.client.MerchantClient;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantClientImpl.java, v 0.1 2017年12月16日 上午10:32:29 jinlilong Exp $
 */
@Component
public class MerchantClientImpl extends BaseClient implements MerchantClient {

    /**  */
    private static Logger logger = LoggerFactory.getLogger(MerchantClientImpl.class);

    /**  */
    @Autowired
    RestTemplate          restTemplate;

    /** 
     * @see com.py.zuul.client.MerchantClient#queryMerchantPermission(java.lang.String)
     */
    @Override
    public MerchantPermissionVO queryMerchantPermission(String merchantCode) {
        String url = BaseContants.HTTP + ServiceNameEnums.SERVICE_MERCHANT.getCode()
                     + MerchantUrlConstants.QUERY_MERCHANT_PERMISSION_BY_CODE + "?merchantCode="
                     + merchantCode;
        MerchantPermissionVO merchantPermissionVO = null;
        try {
            String data = restTemplate.getForObject(url, String.class);
            merchantPermissionVO = this.getData(data, MerchantPermissionVO.class);
        } catch (Exception e) {
            logger.error("查询商户服务权限异常", e);
            throw new RuntimeException("查询商户服务权限异常");
        }
        if (merchantPermissionVO == null) {
            logger.error("查询商户服务权限异常");
            throw new RuntimeException("查询商户服务权限异常");
        }
        return merchantPermissionVO;
    }

}
