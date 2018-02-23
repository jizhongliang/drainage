package com.py.app.telecom.service.impl;

import com.py.app.telecom.mysql.entities.CLUserAuth;
import com.py.app.telecom.mysql.mapper.CLUserAuthMapper;
import com.py.app.telecom.service.UserAuthService;
import com.py.common.constant.Constants;
import com.py.common.utils.ParamUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**用户认证服务
 * Created by jzl on 17/12/20.
 */
@Service
public class UserAuthServiceImpl implements UserAuthService {
    private static Logger logger = LoggerFactory.getLogger(UserAuthServiceImpl.class);
    @Autowired
    private CLUserAuthMapper userAuthMapper;

    /**
     * 是否认证通过
     * @param userId
     * @return
     */
    @Override
    public boolean isTheUserAuthed(Long userId) {
        CLUserAuth userAuth = userAuthMapper.findOneByUid(userId);
        if (ParamUtil.isEmpty(userAuth)) {
            return false;
        }

        if (Constants.PHONE_STATUS_ALREADY.equals(userAuth.getPhoneState())) {
            logger.info("手机状态已认证，uid:{}", userId);
            return true;
        }

        return false;
    }
}
