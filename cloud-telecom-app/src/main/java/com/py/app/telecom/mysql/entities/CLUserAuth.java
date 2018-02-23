package com.py.app.telecom.mysql.entities;

import java.util.Date;

public class CLUserAuth {
    private Long id;

    private Long userId;

    private String idState;

    private String contactState;

    private String bankCardState;

    private String phoneState;//手机运营商认证状态 ，10未认证/未完善，20认证中/完善中，30已认证/已完善

    private String zhimaState;

    private String workInfoState;

    private String otherInfoState;

    private String accFundState;

    private String registTimeComplete;

    private Date updatePhoneStateTime;

    private Date updateZhimaStateTime;

    private Date updateBankCardStateTime;

    private Date updateContactStateTime;

    private Date updateIdStateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIdState() {
        return idState;
    }

    public void setIdState(String idState) {
        this.idState = idState == null ? null : idState.trim();
    }

    public String getContactState() {
        return contactState;
    }

    public void setContactState(String contactState) {
        this.contactState = contactState == null ? null : contactState.trim();
    }

    public String getBankCardState() {
        return bankCardState;
    }

    public void setBankCardState(String bankCardState) {
        this.bankCardState = bankCardState == null ? null : bankCardState.trim();
    }

    public String getPhoneState() {
        return phoneState;
    }

    public void setPhoneState(String phoneState) {
        this.phoneState = phoneState == null ? null : phoneState.trim();
    }

    public String getZhimaState() {
        return zhimaState;
    }

    public void setZhimaState(String zhimaState) {
        this.zhimaState = zhimaState == null ? null : zhimaState.trim();
    }

    public String getWorkInfoState() {
        return workInfoState;
    }

    public void setWorkInfoState(String workInfoState) {
        this.workInfoState = workInfoState == null ? null : workInfoState.trim();
    }

    public String getOtherInfoState() {
        return otherInfoState;
    }

    public void setOtherInfoState(String otherInfoState) {
        this.otherInfoState = otherInfoState == null ? null : otherInfoState.trim();
    }

    public String getAccFundState() {
        return accFundState;
    }

    public void setAccFundState(String accFundState) {
        this.accFundState = accFundState == null ? null : accFundState.trim();
    }

    public String getRegistTimeComplete() {
        return registTimeComplete;
    }

    public void setRegistTimeComplete(String registTimeComplete) {
        this.registTimeComplete = registTimeComplete == null ? null : registTimeComplete.trim();
    }

    public Date getUpdatePhoneStateTime() {
        return updatePhoneStateTime;
    }

    public void setUpdatePhoneStateTime(Date updatePhoneStateTime) {
        this.updatePhoneStateTime = updatePhoneStateTime;
    }

    public Date getUpdateZhimaStateTime() {
        return updateZhimaStateTime;
    }

    public void setUpdateZhimaStateTime(Date updateZhimaStateTime) {
        this.updateZhimaStateTime = updateZhimaStateTime;
    }

    public Date getUpdateBankCardStateTime() {
        return updateBankCardStateTime;
    }

    public void setUpdateBankCardStateTime(Date updateBankCardStateTime) {
        this.updateBankCardStateTime = updateBankCardStateTime;
    }

    public Date getUpdateContactStateTime() {
        return updateContactStateTime;
    }

    public void setUpdateContactStateTime(Date updateContactStateTime) {
        this.updateContactStateTime = updateContactStateTime;
    }

    public Date getUpdateIdStateTime() {
        return updateIdStateTime;
    }

    public void setUpdateIdStateTime(Date updateIdStateTime) {
        this.updateIdStateTime = updateIdStateTime;
    }
}