package com.py.app.user.vo;

/**用户信息返回参数虚体
 * Created by jzl on 17/12/13.
 */
public class UserInfoVo {
    private String uid;
    private String registerClient;  //注册客户端
    private String phone;
    private String realName;
    private String age;
    private String sex;
    private String national;
    private String idNo;
    private String idAddr;
    private String livingImg;   //自拍(人脸识别照片)
    private String ocrImg;      //身份证头像
    private String frontImg;    //身份证正面
    private String backImg;     //身份证反面
    private String education;
    private String marryState;
    private String companyName;
    private String companyPhone;
    private String companyAddr;
    private String companyDetailAddr;
    private String salary;
    private String liveDetailAddr;
    private String liveAddr;
    private String state;       //是否黑名单 ，10是20不是
    private String blackReason;
    private String level;       //用户等级

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRegisterClient() {
        return registerClient;
    }

    public void setRegisterClient(String registerClient) {
        this.registerClient = registerClient;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getIdAddr() {
        return idAddr;
    }

    public void setIdAddr(String idAddr) {
        this.idAddr = idAddr;
    }

    public String getLivingImg() {
        return livingImg;
    }

    public void setLivingImg(String livingImg) {
        this.livingImg = livingImg;
    }

    public String getOcrImg() {
        return ocrImg;
    }

    public void setOcrImg(String ocrImg) {
        this.ocrImg = ocrImg;
    }

    public String getFrontImg() {
        return frontImg;
    }

    public void setFrontImg(String frontImg) {
        this.frontImg = frontImg;
    }

    public String getBackImg() {
        return backImg;
    }

    public void setBackImg(String backImg) {
        this.backImg = backImg;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMarryState() {
        return marryState;
    }

    public void setMarryState(String marryState) {
        this.marryState = marryState;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }

    public String getCompanyDetailAddr() {
        return companyDetailAddr;
    }

    public void setCompanyDetailAddr(String companyDetailAddr) {
        this.companyDetailAddr = companyDetailAddr;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getLiveDetailAddr() {
        return liveDetailAddr;
    }

    public void setLiveDetailAddr(String liveDetailAddr) {
        this.liveDetailAddr = liveDetailAddr;
    }

    public String getLiveAddr() {
        return liveAddr;
    }

    public void setLiveAddr(String liveAddr) {
        this.liveAddr = liveAddr;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBlackReason() {
        return blackReason;
    }

    public void setBlackReason(String blackReason) {
        this.blackReason = blackReason;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
