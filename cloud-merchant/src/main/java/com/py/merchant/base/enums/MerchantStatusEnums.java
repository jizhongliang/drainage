/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.base.enums;

import com.py.common.utils.ParamUtil;

/**
 * 
 * @author jinlilong
 * @version $Id: BaseBizErrorEnums.java, v 0.1 2017年12月13日 下午2:07:32 jinlilong Exp $
 */
public enum MerchantStatusEnums {

    ENABLE("1", "启用"),

    DISABLE("0", "停用");

    /**  */
    private String code;

    /**  */
    private String msg;

    MerchantStatusEnums(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 
     * @param code
     * @return
     */
    public static MerchantStatusEnums queryByCode(String code) {
        for (MerchantStatusEnums enums : MerchantStatusEnums.values()) {
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
