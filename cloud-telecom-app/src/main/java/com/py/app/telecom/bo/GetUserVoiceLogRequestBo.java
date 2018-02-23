package com.py.app.telecom.bo;

/**查询user_voice_log表请求参数实体
 * Created by jzl on 17/12/20.
 */
public class GetUserVoiceLogRequestBo {
    private String tableName;
    private Long userId;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
