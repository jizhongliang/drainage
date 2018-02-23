/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.service.convertor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.py.common.service.entity.merchant.response.MerchantPermissionVO;
import com.py.common.utils.DateUtil;
import com.py.common.utils.ParamUtil;
import com.py.merchant.base.BaseBizContants;
import com.py.merchant.base.request.merchant.MerchantPermissionRequest;
import com.py.merchant.dao.entify.MerchantDO;
import com.py.merchant.dao.entify.MerchantPermissionDO;
import com.py.merchant.dao.entify.MerchantPermissionManualDO;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantPermissionServiceConvertor.java, v 0.1 2017年12月16日 上午10:26:32 jinlilong Exp $
 */
public class MerchantPermissionServiceConvertor {

    /**
     * 
     * @param list
     * @return
     */
    public static MerchantPermissionVO buildQueryMerchantPermissionResponseList(MerchantDO merchantDO,
                                                                                List<MerchantPermissionManualDO> list) {
        MerchantPermissionVO merchantPermissionVO = new MerchantPermissionVO();
        List<String> ipList = new ArrayList<>();
        List<String> urlList = new ArrayList<>();
        for (MerchantPermissionManualDO merchantPermissionManualDO : list) {
            urlList.add(merchantPermissionManualDO.getUrl());
        }

        if (ParamUtil.isNotEmpty(merchantDO.getIncludeIp())) {
            String[] array = merchantDO.getIncludeIp().split(BaseBizContants.COMMA);
            ipList = Arrays.asList(array);
        }
        merchantPermissionVO.setUrl(urlList);
        merchantPermissionVO.setIncludeIps(ipList);
        return merchantPermissionVO;
    }

    /**
     * 
     * @param req
     * @return
     */
    public static MerchantPermissionDO buildMerchantPermissionDO(MerchantPermissionRequest req) {
        MerchantPermissionDO merchantPermissionDO = new MerchantPermissionDO();
        merchantPermissionDO.setCrator(req.getCreator());
        merchantPermissionDO.setGmtCreate(DateUtil.getCurrentDate());
        merchantPermissionDO.setGmtModify(DateUtil.getCurrentDate());
        merchantPermissionDO.setMerchantId(req.getMerchantId());
        merchantPermissionDO.setModifier(req.getCreator());
        merchantPermissionDO.setPermissionId(req.getPermissionId());
        return merchantPermissionDO;
    }

    /**
     * 
     * @param req
     * @return
     */
    public static MerchantPermissionDO buildDeleteMerchantPermissionReq(MerchantPermissionRequest req) {
        MerchantPermissionDO merchantPermissionDO = new MerchantPermissionDO();
        merchantPermissionDO.setMerchantId(req.getMerchantId());
        merchantPermissionDO.setPermissionId(req.getPermissionId());
        return merchantPermissionDO;
    }
}
