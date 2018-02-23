package com.py.app.entrance.mysql.mapper;


import com.py.app.entrance.mysql.entities.CLEntranceMerchants;

public interface CLEntranceMerchantsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CLEntranceMerchants record);

    int insertSelective(CLEntranceMerchants record);

    CLEntranceMerchants selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CLEntranceMerchants record);

    int updateByPrimaryKey(CLEntranceMerchants record);

    CLEntranceMerchants findMerchantByCode(String merchantCode);

    CLEntranceMerchants findMerchantByCodeAndStatus(String merchantCode);
}