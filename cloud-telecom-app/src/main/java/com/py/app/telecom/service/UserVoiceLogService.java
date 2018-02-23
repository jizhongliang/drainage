package com.py.app.telecom.service;

import com.py.app.telecom.mysql.entities.UserVoiceLog;
import com.py.app.telecom.vo.UserTelecomInfoVo;

/**
 * Created by jzl on 17/12/19.
 */
public interface UserVoiceLogService {
    /**
     * 查询运营商信息
     * @param userId
     * @param tableName
     * @return
     */
    UserVoiceLog findUserTeleInfo(Long userId, String tableName);

    /**
     * 解析数据
     * @param voiceLog
     * @return
     */
    UserTelecomInfoVo handleVoiceLogToTelecomVo(UserVoiceLog voiceLog);
}
