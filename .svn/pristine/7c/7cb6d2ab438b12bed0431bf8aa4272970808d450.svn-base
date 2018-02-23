/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.zuul.client.impl;

import com.alibaba.fastjson.JSONObject;
import com.py.common.service.entity.base.BaseContants;

/**
 * 
 * @author jinlilong
 * @version $Id: BaseClient.java, v 0.1 2017年12月16日 下午3:45:21 jinlilong Exp $
 */
public class BaseClient {

    public <T> T getData(String result, Class<T> classz) {
        JSONObject json = JSONObject.parseObject(result);
        if (json.containsKey(BaseContants.CODE)
            && json.getString(BaseContants.CODE).equals(BaseContants.SUCCESS_CODE)) {
            String data = json.getString(BaseContants.DATA);
            return JSONObject.parseObject(data, classz);
        }
        return null;
    }

}
