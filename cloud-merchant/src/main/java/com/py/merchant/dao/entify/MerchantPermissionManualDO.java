/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.dao.entify;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantPermissionDO.java, v 0.1 2017年12月14日 上午11:32:43 jinlilong Exp $
 */
public class MerchantPermissionManualDO {

    /**  */
    private long   id;

    /**  */
    private long   merchantId;

    /**  */
    private long   permissionId;

    /**  */
    private String url;

    /**  权限名称*/
    private String name;

    /**  */
    private String serviceCode;

    /**  */
    private String serviceName;

    /**  */
    private String gmtCreate;

    /**  */
    private String gmtModify;

    /**  */
    private String crator;

    /**  */
    private String modifier;

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
     * Getter method for property <tt>permissionId</tt>.
     * 
     * @return property value of permissionId
     */
    public long getPermissionId() {
        return permissionId;
    }

    /**
     * Setter method for property <tt>permissionId</tt>.
     * 
     * @param permissionId value to be assigned to property permissionId
     */
    public void setPermissionId(long permissionId) {
        this.permissionId = permissionId;
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

}
