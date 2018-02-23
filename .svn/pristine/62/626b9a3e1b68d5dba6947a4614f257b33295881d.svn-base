/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.base.request.merchant;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantInsertRequest.java, v 0.1 2017年12月13日 下午6:05:21 jinlilong Exp $
 */
public class MerchantInsertRequest {

    /**  商户名称*/
    @NotEmpty(message = "商户名称不能为空")
    @Length(min = 1, max = 32, message = "商户名称1到32个字符以内")
    private String name;

    /**  商户code*/
    @NotEmpty(message = "商户号不能为空")
    @Length(min = 1, max = 32, message = "商户号1到32个字符以内")
    private String securityCode;

    /**  商户密钥*/
    @NotEmpty(message = "商户密钥不能为空")
    @Length(min = 1, max = 32, message = "商户密钥1到2048个字符以内")
    private String publicKey;

    /**  允许访问的ip地址。多个以逗号隔开*/
    @NotEmpty(message = "商户允许访问的ip地址不能为空")
    @Length(min = 1, max = 32, message = "商户允许访问的ip地址1到2024个字符以内")
    private String includeIp;

    /**  创建人*/
    @NotEmpty(message = "创建人不能为空")
    @Length(min = 1, max = 32, message = "创建人1到32个字符以内")
    private String creator;

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
     * Getter method for property <tt>publicKey</tt>.
     * 
     * @return property value of publicKey
     */
    public String getPublicKey() {
        return publicKey;
    }

    /**
     * Setter method for property <tt>publicKey</tt>.
     * 
     * @param publicKey value to be assigned to property publicKey
     */
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    /**
     * Getter method for property <tt>creator</tt>.
     * 
     * @return property value of creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * Setter method for property <tt>creator</tt>.
     * 
     * @param creator value to be assigned to property creator
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * Getter method for property <tt>includeIp</tt>.
     * 
     * @return property value of includeIp
     */
    public String getIncludeIp() {
        return includeIp;
    }

    /**
     * Setter method for property <tt>includeIp</tt>.
     * 
     * @param includeIp value to be assigned to property includeIp
     */
    public void setIncludeIp(String includeIp) {
        this.includeIp = includeIp;
    }

}
