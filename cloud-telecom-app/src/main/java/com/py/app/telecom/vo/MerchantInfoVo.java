package com.py.app.telecom.vo;

/**商户信息属性
 * Created by jzl on 17/12/13.
 */
public class MerchantInfoVo {
    /**  主键Id*/
    private String   id;

    /**  商户名称*/
    private String name;

    /**  商户code*/
    private String securityCode;

    /**  */
    private String gmtCreate;

    /**  */
    private String gmtModify;

    /**  */
    private String crator;

    /**  */
    private String modifier;

    /**  */
    private String status;

    /** 密钥 */
    private String publicKey;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(String gmtModify) {
        this.gmtModify = gmtModify;
    }

    public String getCrator() {
        return crator;
    }

    public void setCrator(String crator) {
        this.crator = crator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}
