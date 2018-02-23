package com.py.app.entrance.service.impl;

import com.py.app.entrance.mysql.entities.CLEntranceMerchants;
import com.py.app.entrance.mysql.mapper.CLEntranceMerchantsMapper;
import com.py.app.entrance.service.EntranceMerchantService;
import com.py.common.utils.ParamUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jzl on 17/12/22.
 */
@Service
public class EntranceMerchantServiceImpl implements EntranceMerchantService {
    private static Logger logger = LoggerFactory.getLogger(EntranceMerchantServiceImpl.class);
    @Autowired
    private CLEntranceMerchantsMapper merchantsMapper;


    /**
     * 校验商户
     * @param merchantCode
     * @return
     */
    @Override
    public boolean checkMerchantIsAble(String merchantCode) {
        if (ParamUtil.isEmpty(merchantCode)) {
            logger.info("商户code为空，返回false");
            return false;
        }

        CLEntranceMerchants merchant = merchantsMapper.findMerchantByCode(merchantCode);
        if (ParamUtil.isEmpty(merchant)) {
            logger.info("无此引流商户, merchantCode:{}", merchantCode);
            return false;
        }

        if (merchant.getStatus() != 1) {
            logger.info("此商户已关闭,merchantCode:{},status:{}", merchantCode, merchant.getStatus());
            return false;
        }
        logger.info("商户校验通过,merchantCode:{}", merchantCode);
        return true;
    }

    /**
     * 查询商户信息 status = 1
     * @param merchantCode
     * @return
     */
    @Override
    public CLEntranceMerchants findMerchantByCodeAndStatus(String merchantCode) {
        CLEntranceMerchants merchant = merchantsMapper.findMerchantByCodeAndStatus(merchantCode);
        return merchant;
    }
}
