package com.py.app.telecom.mysql.mapper;


import com.py.app.telecom.mysql.entities.CLInterfaceAccessRecord;

public interface CLInterfaceAccessRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CLInterfaceAccessRecord record);

    int insertSelective(CLInterfaceAccessRecord record);

    CLInterfaceAccessRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CLInterfaceAccessRecord record);

    int updateByPrimaryKey(CLInterfaceAccessRecord record);
}