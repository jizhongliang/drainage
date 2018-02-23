/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.zuul.client;

import com.py.common.service.entity.merchant.response.MerchantPermissionVO;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantClient.java, v 0.1 2017年12月16日 上午10:22:45 jinlilong Exp $
 */
public interface MerchantClient {

    /**
     * 查询商户所有的权限
     * @param merchantCode
     * @return
     */
    public MerchantPermissionVO queryMerchantPermission(String merchantCode);

}
