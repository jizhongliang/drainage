package com.py.app.telecom.service;

/**
 * Created by jzl on 17/12/14.
 */
public interface InterfaceAccessRecordService {
    /**
     * 插入记录
     * @param merchantCode
     * @param method
     * @param type
     */
    void insertRecord(String merchantCode, String method, int type);
}
