/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.base.request.merchant;

import com.py.merchant.base.BasePageRequest;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantQueryRequest.java, v 0.1 2017年12月14日 上午9:28:42 jinlilong Exp $
 */
public class MerchantQueryRequest extends BasePageRequest {

    /**  */
    private String name;

    /**  */
    private String securityCode;

    /**  */
    private String status;

    /**
     * Getter method for property <tt>name</tt>.
     * 
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     * 
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>securityCode</tt>.
     * 
     * @return property value of securityCode
     */
    public String getSecurityCode() {
        return securityCode;
    }

    /**
     * Setter method for property <tt>securityCode</tt>.
     * 
     * @param securityCode value to be assigned to property securityCode
     */
    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    /**
     * Getter method for property <tt>status</tt>.
     * 
     * @return property value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     * 
     * @param status value to be assigned to property status
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
