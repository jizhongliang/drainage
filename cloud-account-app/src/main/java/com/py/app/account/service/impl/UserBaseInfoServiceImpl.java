package com.py.app.account.service.impl;

import com.py.app.account.mysql.entities.CLUserBaseInfo;
import com.py.app.account.mysql.mapper.CLUserBaseInfoMapper;
import com.py.app.account.service.UserBaseInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by jzl on 17/12/14.
 */
@Service
public class UserBaseInfoServiceImpl implements UserBaseInfoService {
    private static Logger logger = LoggerFactory.getLogger(UserBaseInfoServiceImpl.class);
    @Autowired
    private CLUserBaseInfoMapper userBaseInfoMapper;

    @Override
    public CLUserBaseInfo findOneByPhone(String phone) {
        return userBaseInfoMapper.findOneByPhone(phone);
    }
}
