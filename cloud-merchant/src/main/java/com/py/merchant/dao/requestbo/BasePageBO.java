/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.dao.requestbo;

/**
 * 
 * @author jinlilong
 * @version $Id: BaseBO.java, v 0.1 2017年12月13日 下午5:18:36 jinlilong Exp $
 */
public class BasePageBO {

    /**  */
    private int pageNum;

    /**  */
    private int pageSize;

    /**
     * Getter method for property <tt>start</tt>.
     * 
     * @return property value of start
     */
    public int getStart() {
        return (pageNum - 1) * pageSize;
    }

    /**
     * 
     * @return
     */
    public int getSize() {
        return pageSize;
    }

    /**
     * Getter method for property <tt>pageNum</tt>.
     * 
     * @return property value of pageNum
     */
    public int getPageNum() {
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
