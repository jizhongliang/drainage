/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.base.request.merchant;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantPermissionInsertRequest.java, v 0.1 2017年12月19日 下午2:04:36 jinlilong Exp $
 */
public class MerchantPermissionRequest {

    /**  */
    @Min(value = 1, message = "商户主键ID不能为空")
    private long   merchantId;

    /**  */
    @Min(value = 1, message = "权限主键ID不能为空")
    private long   permissionId;

    /**  */
    @NotEmpty(message = "创建人不能为空")
    @Length(min = 1, max = 32, message = "创建人1到32个字符以内")
    private String creator;

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
