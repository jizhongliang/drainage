/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.py.merchant.base.request.permission.PermissionInsertRequest;
import com.py.merchant.base.request.permission.PermissionQueryRequest;
import com.py.merchant.base.request.permission.PermissionUpdateRequest;
import com.py.merchant.dao.PermissionMapper;
import com.py.merchant.dao.entify.PermissionDO;
import com.py.merchant.dao.requestbo.PermissionQueryBO;
import com.py.merchant.service.PermissionService;
import com.py.merchant.service.convertor.PermissionServiceConvertor;

/**
 * 
 * @author jinlilong
 * @version $Id: PermissionServiceImpl.java, v 0.1 2017年12月14日 上午10:45:01 jinlilong Exp $
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    /**  */
    @Autowired
    private PermissionMapper permissionMapper;

    /** 
     * @see com.py.merchant.service.PermissionService#queryById(long)
     */
    @Override
    public PermissionDO queryById(long id) {
        return permissionMapper.queryById(id);
    }

    /** 
     * @see com.py.merchant.service.PermissionService#insertPermission(com.py.merchant.base.request.permission.PermissionInsertRequest)
     */
    @Override
    public long insertPermission(PermissionInsertRequest req) {
        PermissionDO permissionDO = PermissionServiceConvertor.buildInsertPermissionRequest(req);
        permissionMapper.insertPermission(permissionDO);
        return permissionDO.getId();
    }

    /** 
     * @see com.py.merchant.service.PermissionService#updatePermission(com.py.merchant.base.request.permission.PermissionUpdateRequest)
     */
    @Override
    public boolean updatePermission(PermissionUpdateRequest req) {
        PermissionDO permissionDO = PermissionServiceConvertor.buildUpdatePermissionRequest(req);
        permissionMapper.updatePermission(permissionDO);
        return true;
    }

    /** 
     * @see com.py.merchant.service.PermissionService#deletePermission(long)
     */
    @Override
    public boolean deletePermission(long id) {
        permissionMapper.deleteById(id);
        return true;
    }

    /** 
     * @see com.py.merchant.service.PermissionService#queryPagePermission(com.py.merchant.base.request.permission.PermissionQueryRequest)
     */
    @Override
    public List<PermissionDO> queryPagePermission(PermissionQueryRequest req) {
        PermissionQueryBO permissionQueryBO = PermissionServiceConvertor
            .buildQueryPagePermissionQueryBO(req);
        return permissionMapper.pageQuery(permissionQueryBO);
    }

    /** 
     * @see com.py.merchant.service.PermissionService#queryPagePermissionCount(com.py.merchant.base.request.permission.PermissionQueryRequest)
     */
    @Override
    public long queryPagePermissionCount(PermissionQueryRequest req) {
        PermissionQueryBO permissionQueryBO = PermissionServiceConvertor
            .buildQueryPagePermissionQueryBO(req);
        return permissionMapper.pageQueryCount(permissionQueryBO);
    }

    /** 
     * @see com.py.merchant.service.PermissionService#queryAllService()
     */
    @Override
    public List<PermissionDO> queryAllService() {
        return permissionMapper.selectAllService();
    }

}
