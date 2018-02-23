package com.py.app.borrow.vo;

/**借款信息返回参数实体
 * Created by jzl on 17/12/18.
 */
public class BorrowInfoVo {
    private String uid;         //用户id
    private String realName;    //真实姓名
    private String amount;      //借款金额(元)
    private String borrowTime;  //借款日期
    private String limitDays;   //借款期限(天)
    private String status;      //借款状态(10-审核中 20-自动审核成功  21自动审核不通过  22自动审核未决待人工复审 26人工复审通过 27人工复审不通过 30-待还款 40-已还款 41减免还款 50已逾期)
    private String address;     //发起借款地址
    private String repayTime;   //应还款时间
    private String penaltyAmount;//逾期罚金(元)
    private String penaltyDays; //逾期天数

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    public String getLimitDays() {
        return limitDays;
    }

    public void setLimitDays(String limitDays) {
        this.limitDays = limitDays;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRepayTime() {
        return repayTime;
    }

    public void setRepayTime(String repayTime) {
        this.repayTime = repayTime;
    }

    public String getPenaltyAmount() {
        return penaltyAmount;
    }

    public void setPenaltyAmount(String penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }

    public String getPenaltyDays() {
        return penaltyDays;
    }

    public void setPenaltyDays(String penaltyDays) {
        this.penaltyDays = penaltyDays;
    }
}
