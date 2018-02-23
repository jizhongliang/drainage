package com.py.app.entrance.service.impl;

import com.py.app.entrance.mysql.entities.CLEntranceAccessRecord;
import com.py.app.entrance.mysql.mapper.CLEntranceAccessRecordMapper;
import com.py.app.entrance.service.EntranceAccessRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jzl on 17/12/22.
 */
@Service
public class EntranceAccessRecordServiceImpl implements EntranceAccessRecordService {
    private static Logger logger = LoggerFactory.getLogger(EntranceAccessRecordServiceImpl.class);
    @Autowired
    private CLEntranceAccessRecordMapper recordMapper;

    @Override
    public void insertRecord(CLEntranceAccessRecord record) {
        recordMapper.insertSelective(record);
    }
}
