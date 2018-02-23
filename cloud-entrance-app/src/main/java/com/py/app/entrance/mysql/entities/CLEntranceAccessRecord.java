package com.py.app.entrance.mysql.entities;

import java.util.Date;

public class CLEntranceAccessRecord {
    private Long id;

    private String merchantCode;

    private String accessMethod;

    private String forwardUrl;

    private Date createTime;

    private Date updateTime;

    private Integer sourceFrom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode == null ? null : merchantCode.trim();
    }

    public String getAccessMethod() {
        return accessMethod;
    }

    public void setAccessMethod(String accessMethod) {
        this.accessMethod = accessMethod == null ? null : accessMethod.trim();
    }

    public String getForwardUrl() {
        return forwardUrl;
    }

    public void setForwardUrl(String forwardUrl) {
        this.forwardUrl = forwardUrl == null ? null : forwardUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getSourceFrom() {
        return sourceFrom;
    }

    public void setSourceFrom(Integer sourceFrom) {
        this.sourceFrom = sourceFrom;
    }
}