/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.base.request.permission;

import com.py.merchant.base.BasePageRequest;

/**
 * 
 * @author jinlilong
 * @version $Id: PermissionQueryRequest.java, v 0.1 2017年12月14日 上午10:37:49 jinlilong Exp $
 */
public class PermissionQueryRequest extends BasePageRequest {

    /**  */
    private String name;

    /**  */
    private String serviceCode;

    /**  */
    private String serviceName;

    /**  */
    private long   merchantId;

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
     * Getter method for property <tt>serviceCode</tt>.
     * 
     * @return property value of serviceCode
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * Setter method for property <tt>serviceCode</tt>.
     * 
     * @param serviceCode value to be assigned to property serviceCode
     */
    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    /**
     * Getter method for property <tt>serviceName</tt>.
     * 
     * @return property value of serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Setter method for property <tt>serviceName</tt>.
     * 
     * @param serviceName value to be assigned to property serviceName
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * Getter method for property <tt>merchantId</tt>.
     * 
     * @return property value of merchantId
     */
    public long getMerchantId() {
        return merchantId;
    }

    /**
     * Setter method for property <tt>merchantId</tt>.
     * 
     * @param merchantId value to be assigned to property merchantId
     */
    public void setMerchantId(long merchantId) {
        this.merchantId = merchantId;
    }

}
