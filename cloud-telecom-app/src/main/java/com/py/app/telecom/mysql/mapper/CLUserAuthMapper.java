package com.py.app.telecom.mysql.mapper;


import com.py.app.telecom.mysql.entities.CLUserAuth;

public interface CLUserAuthMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CLUserAuth record);

    int insertSelective(CLUserAuth record);

    CLUserAuth selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CLUserAuth record);

    int updateByPrimaryKey(CLUserAuth record);

    CLUserAuth findOneByUid(Long userId);
}