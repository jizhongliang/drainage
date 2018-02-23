/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.py.merchant.dao.entify.MerchantPermissionDO;
import com.py.merchant.dao.entify.MerchantPermissionManualDO;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantPermissionMapper.java, v 0.1 2017年12月14日 上午11:32:13 jinlilong Exp $
 */
@Mapper
public interface MerchantPermissionMapper {

    /**
     * 根据商户ID查询所有的权限
     * @param merchantId
     * @return
     */
    List<MerchantPermissionManualDO> queryPermissionByMerchantId(long merchantId);

    /**
     * 商户权限新增
     * @param merchantPermissionDO
     */
    void insertMerchantPermission(MerchantPermissionDO merchantPermissionDO);

    /**
     * 根据主键删除
     * @param id
     */
    void deleteMerchantPermission(long id);

    /**
     * 
     * @param merchantId
     */
    void deleteMerchantPermissionByMerchantId(long merchantId);

    /**
     * 根据merchantId和permissionId删除
     * @param merchantPermissionDO
     */
    void deleteByMerchantIdAndPermissionId(MerchantPermissionDO merchantPermissionDO);

}
