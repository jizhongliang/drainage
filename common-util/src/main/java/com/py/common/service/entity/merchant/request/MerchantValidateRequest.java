/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.common.service.entity.merchant.request;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantValidateRequest.java, v 0.1 2017年12月16日 上午11:53:27 jinlilong Exp $
 */
public class MerchantValidateRequest {

    /**  访问的url*/
    private String url;

    /**  请求的ip*/
    private String requestIp;

    /**  商户号*/
    private String merchantCode;

    /**
     * Getter method for property <tt>url</tt>.
     * 
     * @return property value of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter method for property <tt>url</tt>.
     * 
     * @param url value to be assigned to property url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Getter method for property <tt>requestIp</tt>.
     * 
     * @return property value of requestIp
     */
    public String getRequestIp() {
        return requestIp;
    }

    /**
     * Setter method for property <tt>requestIp</tt>.
     * 
     * @param requestIp value to be assigned to property requestIp
     */
    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    /**
     * Getter method for property <tt>merchantCode</tt>.
     * 
     * @return property value of merchantCode
     */
    public String getMerchantCode() {
        return merchantCode;
    }

    /**
     * Setter method for property <tt>merchantCode</tt>.
     * 
     * @param merchantCode value to be assigned to property merchantCode
     */
    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

}
