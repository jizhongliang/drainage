package com.py.app.account.mysql.mapper;

import com.py.app.account.mysql.entities.CLUserBaseInfo;

public interface CLUserBaseInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CLUserBaseInfo record);

    int insertSelective(CLUserBaseInfo record);

    CLUserBaseInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CLUserBaseInfo record);

    int updateByPrimaryKey(CLUserBaseInfo record);

    CLUserBaseInfo findOneByPhone(String phone);
}