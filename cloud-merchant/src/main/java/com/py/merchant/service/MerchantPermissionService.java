/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.service;

import java.util.List;

import com.py.common.service.entity.merchant.response.MerchantPermissionVO;
import com.py.merchant.base.request.merchant.MerchantPermissionRequest;
import com.py.merchant.dao.entify.MerchantPermissionManualDO;
import com.py.merchant.dao.entify.PermissionDO;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantPermissionService.java, v 0.1 2017年12月14日 上午11:49:01 jinlilong Exp $
 */
public interface MerchantPermissionService {

    /**
     * 根据商户号查询商户的所有权限
     * @param merchantCode
     * @return
     */
    MerchantPermissionVO queryMerchantPermission(String merchantCode);

    /**
     * 根据商户ID查询 该商户未拥有的权限
     * @param merchantId
     * @return
     */
    List<MerchantPermissionManualDO> queryMerchantPermission(long merchantId);

    /**
     * 
     * @param req
     */
    boolean insertMerchantPermission(MerchantPermissionRequest req);

    /**
     * 
     * @param req
     * @return
     */
    boolean deleteMerchantPermission(MerchantPermissionRequest req);

    /**
     * 查询该商户未获得的权限
     * @param merchantId
     * @return
     */
    List<PermissionDO> queryMerchantNoPermission(long merchantId);

}
