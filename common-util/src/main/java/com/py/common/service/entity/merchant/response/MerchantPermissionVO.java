/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.common.service.entity.merchant.response;

import java.util.List;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantPermissionVO.java, v 0.1 2017年12月16日 上午10:24:59 jinlilong Exp $
 */
public class MerchantPermissionVO {

    /**  允许的url*/
    private List<String> url;

    /**  允许访问的ip地址*/
    private List<String> includeIps;

    /**
     * Getter method for property <tt>url</tt>.
     * 
     * @return property value of url
     */
    public List<String> getUrl() {
        return url;
    }

    /**
     * Setter method for property <tt>url</tt>.
     * 
     * @param url value to be assigned to property url
     */
    public void setUrl(List<String> url) {
        this.url = url;
    }

    /**
     * Getter method for property <tt>includeIps</tt>.
     * 
     * @return property value of includeIps
     */
    public List<String> getIncludeIps() {
        return includeIps;
    }

    /**
     * Setter method for property <tt>includeIps</tt>.
     * 
     * @param includeIps value to be assigned to property includeIps
     */
    public void setIncludeIps(List<String> includeIps) {
        this.includeIps = includeIps;
    }

}
