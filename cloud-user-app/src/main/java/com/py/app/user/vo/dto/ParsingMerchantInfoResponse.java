package com.py.app.user.vo.dto;

import com.py.app.user.vo.MerchantInfoVo;

/**
 * Created by jzl on 17/12/16.
 */
public class ParsingMerchantInfoResponse {
    private String code;
    private String msg;
    private MerchantInfoVo data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MerchantInfoVo getData() {
        return data;
    }

    public void setData(MerchantInfoVo data) {
        this.data = data;
    }
}
