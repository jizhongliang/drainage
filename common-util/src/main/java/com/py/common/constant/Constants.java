package com.py.common.constant;

/**
 * Created by jzl on 17/12/20.
 */
public class Constants {

    /********************** 手机运营商认证状态 ************************************/
    //手机运营商认证状态 ，10未认证/未完善，20认证中/完善中，30已认证/已完善
    //通过 30
    public static final String PHONE_STATUS_ALREADY = "30";
    //20
    public static final String PHONE_STATUS_ING = "20";
    //10
    public static final String PHONE_STATUS_NO = "10";

    /*********************** 要分表的表基础名 **************************************/
    //运营商表
    public static final String TABLE_USER_VOICE_LOG = "user_voice_log";

    /************************* 分表规则 *******************************************/
    public static final Integer SHARED_TABLE_RULE = 10000;

    /************************** mongoDB Name**************************************/
    public static final String MONGODB_NAME_XQD = "xinqiandai";

}
