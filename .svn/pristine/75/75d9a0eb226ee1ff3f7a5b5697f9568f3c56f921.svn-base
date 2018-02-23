/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.py.common.exception.ParamterException;
import com.py.common.service.entity.merchant.response.MerchantVO;
import com.py.merchant.base.request.merchant.MerchantInsertRequest;
import com.py.merchant.base.request.merchant.MerchantQueryRequest;
import com.py.merchant.base.request.merchant.MerchantUpdateRequest;
import com.py.merchant.base.request.merchant.MerchantUpdateStatusRequest;
import com.py.merchant.dao.MerchantMapper;
import com.py.merchant.dao.entify.MerchantDO;
import com.py.merchant.dao.requestbo.MerchantQueryBO;
import com.py.merchant.service.MerchantService;
import com.py.merchant.service.convertor.MerchantServiceConvertor;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantServiceImpl.java, v 0.1 2017年12月13日 上午10:54:57 jinlilong Exp $
 */
@Service
public class MerchantServiceImpl implements MerchantService {

    /**  */
    @Autowired
    private MerchantMapper merchantMapper;

    /** 
     * @see com.py.merchant.service.MerchantService#queryById(long)
     */
    @Override
    public MerchantVO queryById(long id) {
        MerchantDO merchantDO = merchantMapper.queryById(id);
        return MerchantServiceConvertor.buildMerchantVO(merchantDO);

    }

    /** 
     * @see com.py.merchant.service.MerchantService#insertMerchant(com.py.merchant.entity.MerchantDO)
     */
    @Override
    @Transactional
    public long insertMerchant(MerchantInsertRequest req) {
        MerchantDO checkMerchant = merchantMapper.queryByCode(req.getSecurityCode());
        if (checkMerchant != null) {
            throw new ParamterException("商户号已被占用");
        }
        MerchantDO merchantDO = MerchantServiceConvertor.buildInsertMerchantDO(req);
        merchantMapper.insertMerchant(merchantDO);
        return merchantDO.getId();
    }

    /** 
     * @see com.py.merchant.service.MerchantService#updateMerchant(com.py.merchant.entity.MerchantDO)
     */
    @Override
    @Transactional
    public Boolean updateMerchant(MerchantUpdateRequest req) {
        MerchantDO checkMerchant = merchantMapper.queryByCode(req.getSecurityCode());
        if (checkMerchant != null && checkMerchant.getId() != req.getId()) {
            throw new ParamterException("商户号已被占用");
        }
        MerchantDO merchantDO = MerchantServiceConvertor.buildUpdateMerchantDO(req);
        merchantMapper.updateMerchant(merchantDO);
        return true;
    }

    /** 
     * @see com.py.merchant.service.MerchantService#updateMerchantStatus(com.py.merchant.base.request.MerchantUpdateStatusRequest)
     */
    @Override
    @Transactional
    public Boolean updateMerchantStatus(MerchantUpdateStatusRequest req) {
        MerchantDO merchantDO = MerchantServiceConvertor.buildUpdateMerchantStatusDO(req);
        merchantMapper.updateMerchant(merchantDO);
        return true;
    }

    /** 
     * @see com.py.merchant.service.MerchantService#pageQuery(com.py.merchant.dao.requestbo.MerchantQueryBO)
     */
    @Override
    public List<MerchantVO> pageQuery(MerchantQueryRequest req) {
        MerchantQueryBO merchantQueryBO = MerchantServiceConvertor.buildQueryMerchantBO(req);
        List<MerchantDO> list = merchantMapper.pageQuery(merchantQueryBO);
        return MerchantServiceConvertor.buildPageQueryResponse(list);
    }

    /** 
     * @see com.py.merchant.service.MerchantService#pageQueryCount(com.py.merchant.dao.requestbo.MerchantQueryBO)
     */
    @Override
    public long pageQueryCount(MerchantQueryRequest req) {
        MerchantQueryBO merchantQueryBO = MerchantServiceConvertor.buildQueryMerchantBO(req);
        return merchantMapper.pageQueryCount(merchantQueryBO);
    }

    /** 
     * @see com.py.merchant.service.MerchantService#queryByCode(java.lang.String)
     */
    @Override
    public MerchantVO queryByCode(String code) {
        MerchantDO merchantDO = merchantMapper.queryByCode(code);
        return MerchantServiceConvertor.buildMerchantVO(merchantDO);
    }

    /** 
     * @see com.py.merchant.service.MerchantService#deleteMerchant(long)
     */
    @Override
    public boolean deleteMerchant(long id) {
        merchantMapper.deleteMerchant(id);
        return true;
    }

}
