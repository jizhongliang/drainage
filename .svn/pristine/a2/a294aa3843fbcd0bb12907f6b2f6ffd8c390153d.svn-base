/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.base;

/**
 * 
 * @author jinlilong
 * @version $Id: BaseBizException.java, v 0.1 2017年12月13日 下午2:16:04 jinlilong Exp $
 */
public class BaseBizException extends RuntimeException {

    /**  */
    private static final long serialVersionUID = -2611507164623974525L;

    /**  */
    private String            msg;

    /**  */
    private String            code;

    /**
     * @param enums
     */
    public BaseBizException(BaseBizErrorEnums enums) {

        this.code = enums.getCode();
        this.msg = enums.getMsg();
    }

    /**
     * @param enums
     * @param msg
     */
    public BaseBizException(BaseBizErrorEnums enums, String msg) {

        this.code = enums.getCode();
        this.msg = msg;
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

}
