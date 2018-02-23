package com.py.app.borrow.mysql.mapper;


import com.py.app.borrow.mysql.entities.CLBorrow;

import java.util.List;

public interface CLBorrowMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CLBorrow record);

    int insertSelective(CLBorrow record);

    CLBorrow selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CLBorrow record);

    int updateByPrimaryKeyWithBLOBs(CLBorrow record);

    int updateByPrimaryKey(CLBorrow record);

    List<CLBorrow> findByUid(Long userId);
}