package com.py.app.telecom.service;


import com.py.app.telecom.mysql.entities.CLUserBaseInfo;

/**
 * Created by jzl on 17/12/14.
 */
public interface UserBaseInfoService {
    /**
     * 根据phone查询用户信息实体
     * @param phone
     * @return
     */
    CLUserBaseInfo findOneByPhone(String phone);
}
