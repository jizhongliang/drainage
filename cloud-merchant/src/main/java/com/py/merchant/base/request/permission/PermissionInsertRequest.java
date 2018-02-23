/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.base.request.permission;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author jinlilong
 * @version $Id: PermissionInsertRequest.java, v 0.1 2017年12月14日 上午10:23:13 jinlilong Exp $
 */
public class PermissionInsertRequest {

    /**  */
    @NotEmpty(message = "权限名称不能为空")
    @Length(min = 1, max = 32, message = "权限名称1到32个字符以内")
    private String name;

    /**  */
    @NotEmpty(message = "服务名称不能为空")
    @Length(min = 1, max = 32, message = "服务名称1到32个字符以内")
    private String serviceName;

    /**  */
    @NotEmpty(message = "服务code不能为空")
    @Length(min = 1, max = 32, message = "服务code1到32个字符以内")
    private String serviceCode;

    /**  */
    @NotEmpty(message = "请求url不能为空")
    @Length(min = 1, max = 255, message = "请求url,1到255个字符以内")
    private String url;

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

}
