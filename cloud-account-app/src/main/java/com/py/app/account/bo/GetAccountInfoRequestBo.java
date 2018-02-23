package com.py.app.account.bo;

/**
 * Created by jzl on 17/12/18.
 */
public class GetAccountInfoRequestBo {
    private String merchantCode;
    private String phone;

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
