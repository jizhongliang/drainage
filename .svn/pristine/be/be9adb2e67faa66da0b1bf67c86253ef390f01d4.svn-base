package com.py.app.telecom.mysql.mapper;


import com.py.app.telecom.bo.MerchantSummaryRequestBo;
import com.py.app.telecom.mysql.entities.CLInterfaceMerchantSummary;

public interface CLInterfaceMerchantSummaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CLInterfaceMerchantSummary record);

    int insertSelective(CLInterfaceMerchantSummary record);

    CLInterfaceMerchantSummary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CLInterfaceMerchantSummary record);

    int updateByPrimaryKey(CLInterfaceMerchantSummary record);

    CLInterfaceMerchantSummary findOneByMerchantAndType(MerchantSummaryRequestBo requestBo);
}