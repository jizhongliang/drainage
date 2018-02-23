/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.service.convertor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.py.common.service.entity.merchant.response.MerchantVO;
import com.py.common.utils.DateUtil;
import com.py.merchant.base.BaseBizErrorEnums;
import com.py.merchant.base.BaseBizException;
import com.py.merchant.base.enums.MerchantStatusEnums;
import com.py.merchant.base.request.merchant.MerchantInsertRequest;
import com.py.merchant.base.request.merchant.MerchantQueryRequest;
import com.py.merchant.base.request.merchant.MerchantUpdateRequest;
import com.py.merchant.base.request.merchant.MerchantUpdateStatusRequest;
import com.py.merchant.dao.entify.MerchantDO;
import com.py.merchant.dao.requestbo.MerchantQueryBO;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantServiceConvertor.java, v 0.1 2017年12月13日 下午6:08:35 jinlilong Exp $
 */
public class MerchantServiceConvertor {

    public static MerchantDO buildInsertMerchantDO(MerchantInsertRequest req) {
        MerchantDO merchantDO = new MerchantDO();
        merchantDO.setGmtCreate(DateUtil.formatDateTime(new Date(), null));
        merchantDO.setGmtModify(DateUtil.formatDateTime(new Date(), null));
        merchantDO.setStatus(MerchantStatusEnums.ENABLE.getCode());
        merchantDO.setName(req.getName());
        merchantDO.setSecurityCode(req.getSecurityCode());
        merchantDO.setCrator(req.getCreator());
        merchantDO.setModifier(req.getCreator());
        merchantDO.setPublicKey(req.getPublicKey());
        merchantDO.setIncludeIp(req.getIncludeIp());
        return merchantDO;
    }

    /**
     * 
     * @param req
     * @return
     */
    public static MerchantDO buildUpdateMerchantDO(MerchantUpdateRequest req) {
        MerchantDO merchantDO = new MerchantDO();
        merchantDO.setId(req.getId());
        merchantDO.setName(req.getName());
        merchantDO.setSecurityCode(req.getSecurityCode());
        merchantDO.setPublicKey(req.getPublicKey());
        merchantDO.setGmtModify(DateUtil.formatDateTime(new Date(), null));
        merchantDO.setModifier(req.getCreator());
        return merchantDO;
    }

    /**
     * 
     * @param req
     * @return
     */
    public static MerchantDO buildUpdateMerchantStatusDO(MerchantUpdateStatusRequest req) {

        MerchantStatusEnums enums = MerchantStatusEnums.queryByCode(req.getStatus());
        if (enums == null) {
            throw new BaseBizException(BaseBizErrorEnums.PARAM_IS_ILLEGAL, "商户状态不存在");
        }
        MerchantDO merchantDO = new MerchantDO();
        merchantDO.setId(req.getId());
        merchantDO.setStatus(req.getStatus());
        merchantDO.setModifier(req.getCreator());
        merchantDO.setGmtModify(DateUtil.formatDateTime(new Date(), null));
        return merchantDO;
    }

    /**
     * 
     * @param req
     * @return
     */
    public static MerchantQueryBO buildQueryMerchantBO(MerchantQueryRequest req) {
        MerchantQueryBO merchantQueryBO = new MerchantQueryBO();
        merchantQueryBO.setName(req.getName());
        merchantQueryBO.setSecurityCode(req.getSecurityCode());
        merchantQueryBO.setStatus(req.getStatus());
        merchantQueryBO.setPageNum(req.getPageNum());
        merchantQueryBO.setPageSize(req.getPageSize());
        return merchantQueryBO;
    }

    /**
     * 
     * @param merchantDO
     * @return
     */
    public static MerchantVO buildMerchantVO(MerchantDO merchantDO) {
        MerchantVO merchantVO = new MerchantVO();
        BeanUtils.copyProperties(merchantDO, merchantVO);
        return merchantVO;
    }

    /**
     * 
     * @param list
     * @return
     */
    public static List<MerchantVO> buildPageQueryResponse(List<MerchantDO> list) {
        List<MerchantVO> merchantVOList = new ArrayList<>();
        for (MerchantDO merchantDO : list) {
            merchantVOList.add(buildMerchantVO(merchantDO));
        }
        return merchantVOList;
    }
}
