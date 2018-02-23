package com.py.app.user.dao.mysql.mapper;


import com.py.app.user.dao.mysql.entities.CLInterfaceAccessRecord;

public interface CLInterfaceAccessRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CLInterfaceAccessRecord record);

    int insertSelective(CLInterfaceAccessRecord record);

    CLInterfaceAccessRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CLInterfaceAccessRecord record);

    int updateByPrimaryKey(CLInterfaceAccessRecord record);
}