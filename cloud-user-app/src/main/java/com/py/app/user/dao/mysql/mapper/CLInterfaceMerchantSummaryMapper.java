package com.py.app.user.dao.mysql.mapper;


import com.py.app.user.bo.MerchantSummaryRequestBo;
import com.py.app.user.dao.mysql.entities.CLInterfaceMerchantSummary;

public interface CLInterfaceMerchantSummaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CLInterfaceMerchantSummary record);

    int insertSelective(CLInterfaceMerchantSummary record);

    CLInterfaceMerchantSummary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CLInterfaceMerchantSummary record);

    int updateByPrimaryKey(CLInterfaceMerchantSummary record);

    CLInterfaceMerchantSummary findOneByMerchantAndType(MerchantSummaryRequestBo requestBo);
}