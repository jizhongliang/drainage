package com.py.app.entrance.service;

import com.py.app.entrance.mysql.entities.CLEntranceAccessRecord;

/**
 * Created by jzl on 17/12/22.
 */
public interface EntranceAccessRecordService {
    /**
     * 插入记录
     */
    void insertRecord(CLEntranceAccessRecord record);
}
