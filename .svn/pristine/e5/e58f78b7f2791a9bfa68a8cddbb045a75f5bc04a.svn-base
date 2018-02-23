/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;

import com.alibaba.fastjson.JSONObject;
import com.py.common.exception.ParamterException;

/**
 * 
 * @author jinlilong
 * @version $Id: BaseController.java, v 0.1 2017年12月13日 下午1:56:10 jinlilong Exp $
 */
public class BaseController {

    /**  */
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**  */
    public static final String  DATA   = "data";

    /**  */
    public static final String  TOTAL  = "total";

    /**
     * 
     * @param request
     * @param map
     * @param callback
     * @return
     */
    public String httpExecute(ModelMap map, ControllerCallback callback) {

        BaseResponse response = null;
        try {
            map.clear();
            UserContext context = UserContextHolder.getUserContext();
            handleProcess(map, callback, context);
            response = BaseResponse.getSuccessResponse();
        } catch (Exception e) {
            response = handleException(e);
        } finally {
            map.putAll(response.toMap());
        }
        return JSONObject.toJSONString(map);

    }

    /**
     * 异常处理
     * @param e
     */
    public BaseResponse handleException(Exception e) {

        BaseResponse response = BaseResponse.getFailResponse();
        if (e instanceof BaseBizException) {
            BaseBizException ex = (BaseBizException) e;
            response.setCode(ex.getCode());
            response.setMsg(ex.getMsg());
            logger.error("系统发生业务异常：" + ex.getMsg(), e);
        } else if (e instanceof ParamterException) {
            ParamterException ex = (ParamterException) e;
            response.setCode(BaseBizErrorEnums.PARAM_IS_ILLEGAL.getCode());
            response.setMsg(ex.getMessage());
            logger.warn("系统校验参数失败：" + ex.getMessage(), e);
        } else {
            logger.error("系统发生异常：" + e);
        }

        return response;

    }

    /**
     * 正常流程处理
     */
    public void handleProcess(ModelMap map, ControllerCallback callback, UserContext context) {

        {
            callback.check(map, context);
        }

        {
            callback.execute(map, context);
        }
    }

    /**
     * 
     * @author jinlilong
     * @version $Id: BaseController.java, v 0.1 2017年12月13日 下午1:58:53 jinlilong Exp $
     */
    public class ControllerCallback {

        public void check(ModelMap map, UserContext context) {

        }

        public void execute(ModelMap map, UserContext context) {

        }

    }
}
