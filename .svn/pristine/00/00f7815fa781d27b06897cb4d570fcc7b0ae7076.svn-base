package com.py.app.borrow.service.impl;

import com.py.app.borrow.mysql.entities.CLBorrowRepay;
import com.py.app.borrow.mysql.mapper.CLBorrowRepayMapper;
import com.py.app.borrow.service.BorrowRepayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jzl on 17/12/18.
 */
@Service
public class BorrowRepayServiceImpl implements BorrowRepayService {
    private static Logger logger = LoggerFactory.getLogger(BorrowRepayServiceImpl.class);
    @Autowired
    private CLBorrowRepayMapper borrowRepayMapper;

    /**
     * 查询实体集合
     * @param userId
     * @return
     */
    @Override
    public List<CLBorrowRepay> findByUid(Long userId) {
        return borrowRepayMapper.findByUid(userId);
    }
}
