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
 * @version $Id: MerchantUpdateStatusRequest.java, v 0.1 2017年12月14日 上午9:48:29 jinlilong Exp $
 */
public class MerchantUpdateStatusRequest {

    /**  主键Id*/
    @Min(value = 1, message = "商户主键ID不能为空")
    private long   id;

    @NotEmpty(message = "商户更新的状态不能为空")
    private String status;

    /**  创建人*/
    @NotEmpty(message = "创建人不能为空")
    @Length(min = 1, max = 32, message = "创建人1到32个字符以内")
    private String creator;

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
