package com.py.app.account.service.impl;

import com.py.app.account.mysql.entities.CLBankCard;
import com.py.app.account.mysql.mapper.CLBankCardMapper;
import com.py.app.account.service.BankCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jzl on 17/12/16.
 */
@Service
public class BankCardServiceImpl implements BankCardService {
    private static Logger logger = LoggerFactory.getLogger(BankCardServiceImpl.class);
    @Autowired
    private CLBankCardMapper bankCardMapper;


    /**
     * 查询实体
     * @param userId
     * @return
     */
    @Override
    public CLBankCard findOneByUid(Long userId) {
        return bankCardMapper.findOneByUid(userId);
    }
}
