package com.py.app.borrow.service;

import com.py.app.borrow.mysql.entities.CLBorrowRepay;

import java.util.List;

/**
 * Created by jzl on 17/12/18.
 */
public interface BorrowRepayService {
    /**
     * 查询实体集合
     * @param userId
     * @return
     */
    List<CLBorrowRepay> findByUid(Long userId);
}
