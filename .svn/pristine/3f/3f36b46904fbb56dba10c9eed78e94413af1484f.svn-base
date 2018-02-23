/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.service;

import java.util.List;

import com.py.merchant.base.request.permission.PermissionInsertRequest;
import com.py.merchant.base.request.permission.PermissionQueryRequest;
import com.py.merchant.base.request.permission.PermissionUpdateRequest;
import com.py.merchant.dao.entify.PermissionDO;

/**
 * 
 * @author jinlilong
 * @version $Id: PermissionService.java, v 0.1 2017年12月14日 上午10:20:21 jinlilong Exp $
 */
public interface PermissionService {

    /**
     * 
     * @param id
     * @return
     */
    public PermissionDO queryById(long id);

    /**
     * 
     * @param req
     * @return
     */
    public long insertPermission(PermissionInsertRequest req);

    /**
     * 
     * @param req
     * @return
     */
    public boolean updatePermission(PermissionUpdateRequest req);

    /**
     * 
     * @param id
     * @return
     */
    public boolean deletePermission(long id);

    /**
     * 
     * @param req
     * @return
     */
    public List<PermissionDO> queryPagePermission(PermissionQueryRequest req);

    /**
     * 
     * @param req
     * @return
     */
    public long queryPagePermissionCount(PermissionQueryRequest req);

    /**
     * 查询权限里面所有的服务
     * @return
     */
    public List<PermissionDO> queryAllService();

}
