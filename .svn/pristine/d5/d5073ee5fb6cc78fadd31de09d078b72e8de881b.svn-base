/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.py.merchant.dao.entify.MerchantDO;
import com.py.merchant.dao.requestbo.MerchantQueryBO;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantMapper.java, v 0.1 2017年12月13日 上午10:50:12 jinlilong Exp $
 */
@Mapper
public interface MerchantMapper {

    /**
     * 根据Id查询商户
     * @param id
     * @return
     */
    MerchantDO queryById(long id);

    /**
     * 根据商户号取商户信息
     * @param code
     * @return
     */
    MerchantDO queryByCode(String code);

    /**
    * 删除商户
    * @param id
    */
    void deleteMerchant(long id);

    /**
     * 
     * @param merchantDO
     */
    void insertMerchant(MerchantDO merchantDO);

    /**
     * 
     * @param merchantDO
     */
    void updateMerchant(MerchantDO merchantDO);

    /**
     * 
     * @param merchantQueryBO
     * @return
     */
    List<MerchantDO> pageQuery(MerchantQueryBO merchantQueryBO);

    /**
     * 求和
     * @param merchantQueryBO
     * @return
     */
    long pageQueryCount(MerchantQueryBO merchantQueryBO);

}
