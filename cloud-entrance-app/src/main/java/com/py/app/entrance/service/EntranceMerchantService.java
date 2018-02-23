package com.py.app.entrance.service;

import com.py.app.entrance.mysql.entities.CLEntranceMerchants;

/**
 * Created by jzl on 17/12/22.
 */
public interface EntranceMerchantService {
    /**
     * 校验商户是否可用
     * @param merchantCode
     * @return
     */
    boolean checkMerchantIsAble(String merchantCode);

    /**
     * 查询商户信息 status=1
     * @param merchantCode
     * @return
     */
    CLEntranceMerchants findMerchantByCodeAndStatus(String merchantCode);
}
