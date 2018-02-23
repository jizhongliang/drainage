/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.base.request.merchant;

import javax.validation.constraints.Min;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantUpdateRequest.java, v 0.1 2017年12月14日 上午9:19:04 jinlilong Exp $
 */
public class MerchantUpdateRequest extends MerchantInsertRequest {

    /**  主键Id*/
    @Min(value = 1, message = "商户主键ID不能为空")
    private long id;

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

}
