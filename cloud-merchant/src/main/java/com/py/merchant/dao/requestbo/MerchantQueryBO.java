/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.dao.requestbo;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantQueryBO.java, v 0.1 2017年12月13日 下午5:21:59 jinlilong Exp $
 */
public class MerchantQueryBO extends BasePageBO {

    /**  主键Id*/
    private long   id;

    /**  商户名称*/
    private String name;

    /**  商户code*/
    private String securityCode;

    /**  */
    private String status;

    /**
     * Getter method for property <tt>id</tt>.
     * 
     * @return property value of id
     */
    public long getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id
     */
    public void setId(long id) {
        this.id = id;
    }

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
