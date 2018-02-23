/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.zuul.service;

import com.py.zuul.base.entity.ValidateMerchantRequest;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantService.java, v 0.1 2017年12月15日 下午5:42:51 jinlilong Exp $
 */

public interface MerchantService {

    /**
     * 
     * @param content
     * @return
     */
    public boolean queryMerchantPermission(ValidateMerchantRequest req);
}
