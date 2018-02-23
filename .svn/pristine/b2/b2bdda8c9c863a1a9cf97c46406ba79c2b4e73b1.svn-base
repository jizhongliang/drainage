/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.common.enums;

import com.py.common.utils.ParamUtil;

/**
 * 服务名称枚举
 * @author jinlilong
 * @version $Id: BaseBizErrorEnums.java, v 0.1 2017年12月13日 下午2:07:32 jinlilong Exp $
 */
public enum ServiceNameEnums {

    SERVICE_MERCHANT("SERVICE-MERCHANT", "商户服务"),

    CLOUD_INTERGRATION("CLOUD-INTERGRATION", "REDIS服务");

    /**  */
    private String code;

    /**  */
    private String msg;

    ServiceNameEnums(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 
     * @param code
     * @return
     */
    public static ServiceNameEnums queryByCode(String code) {
        for (ServiceNameEnums enums : ServiceNameEnums.values()) {
            if (ParamUtil.equals(code, enums.getCode())) {
                return enums;
            }
        }
        return null;
    }

    /**
     * Getter method for property <tt>code</tt>.
     * 
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     * 
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter method for property <tt>msg</tt>.
     * 
     * @return property value of msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Setter method for property <tt>msg</tt>.
     * 
     * @param msg value to be assigned to property msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

}
