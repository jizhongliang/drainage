package com.py.app.user.service.impl;

import com.py.app.user.dao.mysql.entities.CLUser;
import com.py.app.user.dao.mysql.mapper.CLUserMapper;
import com.py.app.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jzl on 17/12/14.
 */
@Service
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private CLUserMapper userMapper;

    @Override
    public CLUser findOneByUid(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
