/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.service.convertor;

import java.util.Date;

import com.py.common.utils.DateUtil;
import com.py.merchant.base.request.permission.PermissionInsertRequest;
import com.py.merchant.base.request.permission.PermissionQueryRequest;
import com.py.merchant.base.request.permission.PermissionUpdateRequest;
import com.py.merchant.dao.entify.PermissionDO;
import com.py.merchant.dao.requestbo.PermissionQueryBO;

/**
 * 
 * @author jinlilong
 * @version $Id: PermissionServiceConvertor.java, v 0.1 2017年12月14日 上午10:45:39 jinlilong Exp $
 */
public class PermissionServiceConvertor {

    /**
     * 
     * @param req
     * @return
     */
    public static PermissionDO buildInsertPermissionRequest(PermissionInsertRequest req) {
        PermissionDO permissionDO = new PermissionDO();
        permissionDO.setCrator(req.getCreator());
        permissionDO.setGmtCreate(DateUtil.formatDateTime(new Date(), null));
        permissionDO.setGmtModify(DateUtil.formatDateTime(new Date(), null));
        permissionDO.setModifier(req.getCreator());
        permissionDO.setName(req.getName());
        permissionDO.setServiceCode(req.getServiceCode());
        permissionDO.setServiceName(req.getServiceName());
        permissionDO.setUrl(req.getUrl());
        return permissionDO;
    }

    /**
     * 
     * @param req
     * @return
     */
    public static PermissionDO buildUpdatePermissionRequest(PermissionUpdateRequest req) {
        PermissionDO permissionDO = new PermissionDO();
        permissionDO.setId(req.getId());
        permissionDO.setGmtModify(DateUtil.getCurrentDate());
        permissionDO.setModifier(req.getCreator());
        permissionDO.setName(req.getName());
        permissionDO.setServiceCode(req.getServiceCode());
        permissionDO.setServiceName(req.getServiceName());
        permissionDO.setUrl(req.getUrl());
        return permissionDO;
    }

    /**
     * 
     * @param req
     * @return
     */
    public static PermissionQueryBO buildQueryPagePermissionQueryBO(PermissionQueryRequest req) {
        PermissionQueryBO permissionQueryBO = new PermissionQueryBO();
        permissionQueryBO.setName(req.getName());
        permissionQueryBO.setPageNum(req.getPageNum());
        permissionQueryBO.setPageSize(req.getPageSize());
        permissionQueryBO.setServiceCode(req.getServiceCode());
        permissionQueryBO.setServiceName(req.getServiceName());
        return permissionQueryBO;
    }

}
