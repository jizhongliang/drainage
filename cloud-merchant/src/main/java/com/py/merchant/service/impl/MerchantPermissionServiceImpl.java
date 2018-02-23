/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.py.common.service.entity.merchant.response.MerchantPermissionVO;
import com.py.merchant.base.BaseBizErrorEnums;
import com.py.merchant.base.BaseBizException;
import com.py.merchant.base.request.merchant.MerchantPermissionRequest;
import com.py.merchant.dao.MerchantMapper;
import com.py.merchant.dao.MerchantPermissionMapper;
import com.py.merchant.dao.PermissionMapper;
import com.py.merchant.dao.entify.MerchantDO;
import com.py.merchant.dao.entify.MerchantPermissionDO;
import com.py.merchant.dao.entify.MerchantPermissionManualDO;
import com.py.merchant.dao.entify.PermissionDO;
import com.py.merchant.service.MerchantPermissionService;
import com.py.merchant.service.convertor.MerchantPermissionServiceConvertor;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantPermissionServiceImpl.java, v 0.1 2017年12月14日 下午1:37:13 jinlilong Exp $
 */
@Service
public class MerchantPermissionServiceImpl implements MerchantPermissionService {

    /**  */
    @Autowired
    private MerchantMapper           merchantMapper;

    /**  */
    @Autowired
    private MerchantPermissionMapper merchantPermissionMapper;

    /**  */
    @Autowired
    private PermissionMapper         permissionMapper;

    /** 
     * @see com.py.merchant.service.MerchantPermissionService#queryMerchantPermission(java.lang.String)
     */
    @Override
    public MerchantPermissionVO queryMerchantPermission(String merchantCode) {
        MerchantDO merchantDO = merchantMapper.queryByCode(merchantCode);
        if (merchantDO == null) {
            throw new BaseBizException(BaseBizErrorEnums.DATA_IS_NULL,
                "商户不存在,merchantCode=>" + merchantCode);
        }
        List<MerchantPermissionManualDO> list = merchantPermissionMapper
            .queryPermissionByMerchantId(merchantDO.getId());
        return MerchantPermissionServiceConvertor
            .buildQueryMerchantPermissionResponseList(merchantDO, list);

    }

    /** 
     * @see com.py.merchant.service.MerchantPermissionService#insertMerchantPermission(com.py.merchant.base.request.merchant.MerchantPermissionRequest)
     */
    @Override
    public boolean insertMerchantPermission(MerchantPermissionRequest req) {
        MerchantPermissionDO merchantPermissionDO = MerchantPermissionServiceConvertor
            .buildMerchantPermissionDO(req);
        merchantPermissionMapper.insertMerchantPermission(merchantPermissionDO);
        return true;
    }

    /** 
     * @see com.py.merchant.service.MerchantPermissionService#deleteMerchantPermission(com.py.merchant.base.request.merchant.MerchantPermissionRequest)
     */
    @Override
    public boolean deleteMerchantPermission(MerchantPermissionRequest req) {
        MerchantPermissionDO merchantPermissionDO = MerchantPermissionServiceConvertor
            .buildDeleteMerchantPermissionReq(req);
        merchantPermissionMapper.deleteByMerchantIdAndPermissionId(merchantPermissionDO);
        return true;
    }

    /** 
     * @see com.py.merchant.service.MerchantPermissionService#queryMerchantPermission(long)
     */
    @Override
    public List<MerchantPermissionManualDO> queryMerchantPermission(long merchantId) {
        List<MerchantPermissionManualDO> list = merchantPermissionMapper
            .queryPermissionByMerchantId(merchantId);
        return list;
    }

    /** 
     * @see com.py.merchant.service.MerchantPermissionService#queryMerchantNoPermission(long)
     */
    @Override
    public List<PermissionDO> queryMerchantNoPermission(long merchantId) {
        return permissionMapper.queryMerchantNoPermission(merchantId);
    }

}
