/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.py.merchant.dao.entify.PermissionDO;
import com.py.merchant.dao.requestbo.PermissionQueryBO;

/**
 * 
 * @author jinlilong
 * @version $Id: PermissionMapper.java, v 0.1 2017年12月14日 上午10:05:44 jinlilong Exp $
 */
@Mapper
public interface PermissionMapper {

    /**
     * 
     * @param id
     * @return
     */
    PermissionDO queryById(long id);

    /**
     * 
     * @param permissionDO
     */
    void insertPermission(PermissionDO permissionDO);

    /**
     * 
     * @param permissionDO
     */
    void updatePermission(PermissionDO permissionDO);

    /**
     * 
     * @param permissionQueryBO
     * @return
     */
    List<PermissionDO> pageQuery(PermissionQueryBO permissionQueryBO);

    /**
     * 查询权限里面的所有服务
     * @return
     */
    List<PermissionDO> selectAllService();

    /**
     * 
     * @param permissionQueryBO
     * @return
     */
    long pageQueryCount(PermissionQueryBO permissionQueryBO);

    /**
     * 
     * @param id
     */
    void deleteById(long id);

    /**
     * 
     * @param merchantId
     * @return
     */
    List<PermissionDO> queryMerchantNoPermission(long merchantId);

}
