package com.py.app.telecom.vo;

import java.util.List;

/**返回的运营商信息虚体
 * Created by jzl on 17/12/20.
 */
public class UserTelecomInfoVo {
    private List<CallsVo> calls;
    private List<SmsesVo> smses;

    public List<CallsVo> getCalls() {
        return calls;
    }

    public void setCalls(List<CallsVo> calls) {
        this.calls = calls;
    }

    public List<SmsesVo> getSmses() {
        return smses;
    }

    public void setSmses(List<SmsesVo> smses) {
        this.smses = smses;
    }
}
