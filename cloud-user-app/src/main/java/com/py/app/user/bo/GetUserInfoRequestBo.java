package com.py.app.user.bo;

/**获取用户信息请求参数解密后的参数体
 * Created by jzl on 17/12/13.
 */
public class GetUserInfoRequestBo {

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
