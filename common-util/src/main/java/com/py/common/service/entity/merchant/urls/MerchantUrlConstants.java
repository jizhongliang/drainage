/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.common.service.entity.merchant.urls;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantUrlConstants.java, v 0.1 2017年12月13日 下午5:45:04 jinlilong Exp $
 */
public class MerchantUrlConstants {

    /**  根据Id查询商户信息*/
    public static final String QUERY_MERCHANT_BY_ID              = "/queryMerchantById";

    /**  根据商户号查询商户信息*/
    public static final String QUERY_MERCHANT_BY_CODE            = "/queryMerchantByCode";

    /**  插入商户*/
    public static final String INSERT_MERCHANT                   = "/insertMerchant";

    /**  更新商户*/
    public static final String UPDATE_MERCHANT                   = "/updateMerchant";

    /**  删除商户*/
    public static final String DELETE_MERCHANT                   = "deleteMerchant";

    /**  更新商户状态*/
    public static final String UPDATE_MERCHANT_STATUS            = "/updateMerchantStatus";

    /**  商户分页查询*/
    public static final String QUERY_PAGE_MERCHANT               = "/queryPageMerchant";

    /**  根据商户号查询商户的所有权限*/
    public static final String QUERY_MERCHANT_PERMISSION_BY_CODE = "/queryMerchantPermissionByCode";

    /**  查询用的权限。  管理系统根据merchantId查询*/
    public static final String QUERY_MERCHANT_PERMISSION         = "/queryMerchantPermission";

    /**  查询商户未获得的权限*/
    public static final String QUERY_MERCHANT_NO_PERMISSION      = "/queryMerchantNoPermission";

    /**  新增商户权限*/
    public static final String INSERT_MERCHANT_PERMISSION        = "/insertMerchantPermission";

    /**  删除商户权限*/
    public static final String DELETE_MERCHANT_PERMISSION        = "/deleteMerchantPermission";

}
