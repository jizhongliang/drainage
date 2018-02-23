/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.service;

import java.util.List;

import com.py.common.service.entity.merchant.response.MerchantVO;
import com.py.merchant.base.request.merchant.MerchantInsertRequest;
import com.py.merchant.base.request.merchant.MerchantQueryRequest;
import com.py.merchant.base.request.merchant.MerchantUpdateRequest;
import com.py.merchant.base.request.merchant.MerchantUpdateStatusRequest;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantService.java, v 0.1 2017年12月13日 上午10:53:59 jinlilong Exp $
 */
public interface MerchantService {

    /**
     * 根据Id查询商户
     * @param id
     * @return
     */
    public MerchantVO queryById(long id);

    /**
     * 根据商户号取商户信息
     * @param code
     * @return
     */
    public MerchantVO queryByCode(String code);

    /**
     * 新增商户
     * @param merchantDO
     * @return
     */
    public long insertMerchant(MerchantInsertRequest req);

    /**
     * 更新商户
     * @param merchantDO
     */
    public Boolean updateMerchant(MerchantUpdateRequest req);

    /**
     * 删除商户
     * @param id
     * @return
     */
    public boolean deleteMerchant(long id);

    /**
     * 更新商户状态
     * @param req
     * @return
     */
    public Boolean updateMerchantStatus(MerchantUpdateStatusRequest req);

    /**
     * 商户分页查询
     * @param merchantQueryBO
     * @return
     */
    public List<MerchantVO> pageQuery(MerchantQueryRequest req);

    /**
     * 商户分页查询求和
     * @param merchantQueryBO
     * @return
     */
    public long pageQueryCount(MerchantQueryRequest req);
}
