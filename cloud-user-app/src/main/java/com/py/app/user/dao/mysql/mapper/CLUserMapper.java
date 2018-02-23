package com.py.app.user.dao.mysql.mapper;


import com.py.app.user.dao.mysql.entities.CLUser;

public interface CLUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CLUser record);

    int insertSelective(CLUser record);

    CLUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CLUser record);

    int updateByPrimaryKey(CLUser record);
}