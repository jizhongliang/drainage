package com.py.app.telecom.mysql.mapper;
import com.py.app.telecom.bo.GetUserVoiceLogRequestBo;
import com.py.app.telecom.mysql.entities.UserVoiceLog;

public interface UserVoiceLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserVoiceLog record);

    int insertSelective(UserVoiceLog record);

    UserVoiceLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserVoiceLog record);

    int updateByPrimaryKeyWithBLOBs(UserVoiceLog record);

    int updateByPrimaryKey(UserVoiceLog record);

    UserVoiceLog getUserVoiceLogByUid(GetUserVoiceLogRequestBo requestBo);
}