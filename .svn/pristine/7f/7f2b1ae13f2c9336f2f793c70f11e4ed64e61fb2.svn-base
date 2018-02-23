package com.py.app.borrow.service.impl;

import com.py.app.borrow.mysql.entities.CLBorrow;
import com.py.app.borrow.mysql.mapper.CLBorrowMapper;
import com.py.app.borrow.service.BorrowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jzl on 17/12/18.
 */
@Service
public class BorrowServiceImpl implements BorrowService {
    private static Logger logger = LoggerFactory.getLogger(BorrowServiceImpl.class);
    @Autowired
    private CLBorrowMapper borrowMapper;


    /**
     * 查询实体
     * @param userId
     * @return
     */
    @Override
    public List<CLBorrow> findByUid(Long userId) {
        return borrowMapper.findByUid(userId);
    }
}
