/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.common.service.entity.base;

import java.io.Serializable;

/**
 * 
 * @author jinlilong
 * @version $Id: BaseVO.java, v 0.1 2017年12月16日 上午11:02:55 jinlilong Exp $
 */
public class BaseVO<T> implements Serializable {

    /**  */
    private static final long serialVersionUID = 794322584667606180L;

    /**  */
    private String            code;

    /**  */
    private String            msg;

    /**  */
    private T                 data;

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

    /**
     * Getter method for property <tt>data</tt>.
     * 
     * @return property value of data
     */
    public T getData() {
        return data;
    }

    /**
     * Setter method for property <tt>data</tt>.
     * 
     * @param data value to be assigned to property data
     */
    public void setData(T data) {
        this.data = data;
    }

}
