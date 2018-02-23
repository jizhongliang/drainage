package com.py.app.account.mysql.mapper;


import com.py.app.account.bo.MerchantSummaryRequestBo;
import com.py.app.account.mysql.entities.CLInterfaceMerchantSummary;

public interface CLInterfaceMerchantSummaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CLInterfaceMerchantSummary record);

    int insertSelective(CLInterfaceMerchantSummary record);

    CLInterfaceMerchantSummary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CLInterfaceMerchantSummary record);

    int updateByPrimaryKey(CLInterfaceMerchantSummary record);

    CLInterfaceMerchantSummary findOneByMerchantAndType(MerchantSummaryRequestBo requestBo);
}