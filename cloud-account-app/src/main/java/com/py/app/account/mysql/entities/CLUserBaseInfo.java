package com.py.app.account.mysql.entities;

import java.util.Date;

public class CLUserBaseInfo {
    private Long id;

    private Long userId;

    private String phone;

    private String realName;

    private Integer age;

    private String sex;

    private String national;

    private String idNo;

    private String idAddr;

    private String livingImg;

    private String ocrImg;

    private String frontImg;

    private String backImg;

    private String education;

    private String marryState;

    private String companyName;

    private String companyPhone;

    private String companyAddr;

    private String companyDetailAddr;

    private String companyCoordinate;

    private String salary;

    private String workingYears;

    private String workingImg;

    private String liveTime;

    private String liveAddr;

    private String liveDetailAddr;

    private String liveCoordinate;

    private String phoneServerPwd;

    private String registerAddr;

    private String registerCoordinate;

    private String state;

    private String blackReason;

    private Date updateTime;

    private Date createTime;

    private String nickname;

    private String personsign;

    private String personimg;

    private Long level;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national == null ? null : national.trim();
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public String getIdAddr() {
        return idAddr;
    }

    public void setIdAddr(String idAddr) {
        this.idAddr = idAddr == null ? null : idAddr.trim();
    }

    public String getLivingImg() {
        return livingImg;
    }

    public void setLivingImg(String livingImg) {
        this.livingImg = livingImg == null ? null : livingImg.trim();
    }

    public String getOcrImg() {
        return ocrImg;
    }

    public void setOcrImg(String ocrImg) {
        this.ocrImg = ocrImg == null ? null : ocrImg.trim();
    }

    public String getFrontImg() {
        return frontImg;
    }

    public void setFrontImg(String frontImg) {
        this.frontImg = frontImg == null ? null : frontImg.trim();
    }

    public String getBackImg() {
        return backImg;
    }

    public void setBackImg(String backImg) {
        this.backImg = backImg == null ? null : backImg.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getMarryState() {
        return marryState;
    }

    public void setMarryState(String marryState) {
        this.marryState = marryState == null ? null : marryState.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone == null ? null : companyPhone.trim();
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr == null ? null : companyAddr.trim();
    }

    public String getCompanyDetailAddr() {
        return companyDetailAddr;
    }

    public void setCompanyDetailAddr(String companyDetailAddr) {
        this.companyDetailAddr = companyDetailAddr == null ? null : companyDetailAddr.trim();
    }

    public String getCompanyCoordinate() {
        return companyCoordinate;
    }

    public void setCompanyCoordinate(String companyCoordinate) {
        this.companyCoordinate = companyCoordinate == null ? null : companyCoordinate.trim();
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary == null ? null : salary.trim();
    }

    public String getWorkingYears() {
        return workingYears;
    }

    public void setWorkingYears(String workingYears) {
        this.workingYears = workingYears == null ? null : workingYears.trim();
    }

    public String getWorkingImg() {
        return workingImg;
    }

    public void setWorkingImg(String workingImg) {
        this.workingImg = workingImg == null ? null : workingImg.trim();
    }

    public String getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(String liveTime) {
        this.liveTime = liveTime == null ? null : liveTime.trim();
    }

    public String getLiveAddr() {
        return liveAddr;
    }

    public void setLiveAddr(String liveAddr) {
        this.liveAddr = liveAddr == null ? null : liveAddr.trim();
    }

    public String getLiveDetailAddr() {
        return liveDetailAddr;
    }

    public void setLiveDetailAddr(String liveDetailAddr) {
        this.liveDetailAddr = liveDetailAddr == null ? null : liveDetailAddr.trim();
    }

    public String getLiveCoordinate() {
        return liveCoordinate;
    }

    public void setLiveCoordinate(String liveCoordinate) {
        this.liveCoordinate = liveCoordinate == null ? null : liveCoordinate.trim();
    }

    public String getPhoneServerPwd() {
        return phoneServerPwd;
    }

    public void setPhoneServerPwd(String phoneServerPwd) {
        this.phoneServerPwd = phoneServerPwd == null ? null : phoneServerPwd.trim();
    }

    public String getRegisterAddr() {
        return registerAddr;
    }

    public void setRegisterAddr(String registerAddr) {
        this.registerAddr = registerAddr == null ? null : registerAddr.trim();
    }

    public String getRegisterCoordinate() {
        return registerCoordinate;
    }

    public void setRegisterCoordinate(String registerCoordinate) {
        this.registerCoordinate = registerCoordinate == null ? null : registerCoordinate.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getBlackReason() {
        return blackReason;
    }

    public void setBlackReason(String blackReason) {
        this.blackReason = blackReason == null ? null : blackReason.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPersonsign() {
        return personsign;
    }

    public void setPersonsign(String personsign) {
        this.personsign = personsign == null ? null : personsign.trim();
    }

    public String getPersonimg() {
        return personimg;
    }

    public void setPersonimg(String personimg) {
        this.personimg = personimg == null ? null : personimg.trim();
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }
}