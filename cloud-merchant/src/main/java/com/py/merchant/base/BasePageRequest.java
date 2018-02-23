/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.base;

/**
 * 
 * @author jinlilong
 * @version $Id: BaseRequest.java, v 0.1 2017年12月13日 下午6:04:35 jinlilong Exp $
 */
public class BasePageRequest {

    /**  */
    private int pageNum;

    /**  */
    private int pageSize;

    /**
     * Getter method for property <tt>pageNum</tt>.
     * 
     * @return property value of pageNum
     */
    public int getPageNum() {
        if (pageNum <= 0) {
            pageNum = 1;
        }
        return pageNum;
    }

    /**
     * Setter method for property <tt>pageNum</tt>.
     * 
     * @param pageNum value to be assigned to property pageNum
     */
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * Getter method for property <tt>pageSize</tt>.
     * 
     * @return property value of pageSize
     */
    public int getPageSize() {
        if (pageSize <= 0) {
            pageSize = 10;
        }
        return pageSize;
    }

    /**
     * Setter method for property <tt>pageSize</tt>.
     * 
     * @param pageSize value to be assigned to property pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
