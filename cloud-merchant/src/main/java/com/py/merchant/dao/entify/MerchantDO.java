/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.dao.entify;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantDO.java, v 0.1 2017年12月13日 上午10:29:22 jinlilong Exp $
 */
public class MerchantDO {

    /**  主键Id*/
    private long   id;

    /**  商户名称*/
    private String name;

    /**  商户code*/
    private String securityCode;

    /**  */
    private String gmtCreate;

    /**  */
    private String gmtModify;

    /**  */
    private String crator;

    /**  */
    private String modifier;

    /**  */
    private String status;

    /** 密钥 */
    private String publicKey;

    /**  允许访问的ip*/
    private String includeIp;

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
     * Getter method for property <tt>gmtCreate</tt>.
     * 
     * @return property value of gmtCreate
     */
    public String getGmtCreate() {
        return gmtCreate;
    }

    /**
     * Setter method for property <tt>gmtCreate</tt>.
     * 
     * @param gmtCreate value to be assigned to property gmtCreate
     */
    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * Getter method for property <tt>gmtModify</tt>.
     * 
     * @return property value of gmtModify
     */
    public String getGmtModify() {
        return gmtModify;
    }

    /**
     * Setter method for property <tt>gmtModify</tt>.
     * 
     * @param gmtModify value to be assigned to property gmtModify
     */
    public void setGmtModify(String gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * Getter method for property <tt>crator</tt>.
     * 
     * @return property value of crator
     */
    public String getCrator() {
        return crator;
    }

    /**
     * Setter method for property <tt>crator</tt>.
     * 
     * @param crator value to be assigned to property crator
     */
    public void setCrator(String crator) {
        this.crator = crator;
    }

    /**
     * Getter method for property <tt>modifier</tt>.
     * 
     * @return property value of modifier
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * Setter method for property <tt>modifier</tt>.
     * 
     * @param modifier value to be assigned to property modifier
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
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
