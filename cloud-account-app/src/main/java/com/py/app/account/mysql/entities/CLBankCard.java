package com.py.app.account.mysql.entities;

import java.util.Date;

public class CLBankCard {
    private Long id;

    private Long userId;

    private String bank;

    private String cardNo;

    private String phone;

    private String agreeNo;

    private Date bindTime;

    private Date baofooBindTime;

    private String baofooBindId;

    private String baofooType;

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

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAgreeNo() {
        return agreeNo;
    }

    public void setAgreeNo(String agreeNo) {
        this.agreeNo = agreeNo == null ? null : agreeNo.trim();
    }

    public Date getBindTime() {
        return bindTime;
    }

    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }

    public Date getBaofooBindTime() {
        return baofooBindTime;
    }

    public void setBaofooBindTime(Date baofooBindTime) {
        this.baofooBindTime = baofooBindTime;
    }

    public String getBaofooBindId() {
        return baofooBindId;
    }

    public void setBaofooBindId(String baofooBindId) {
        this.baofooBindId = baofooBindId == null ? null : baofooBindId.trim();
    }

    public String getBaofooType() {
        return baofooType;
    }

    public void setBaofooType(String baofooType) {
        this.baofooType = baofooType == null ? null : baofooType.trim();
    }
}