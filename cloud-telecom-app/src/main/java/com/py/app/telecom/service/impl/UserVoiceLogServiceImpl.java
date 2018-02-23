package com.py.app.telecom.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.py.app.telecom.bo.GetUserVoiceLogRequestBo;
import com.py.app.telecom.mysql.entities.UserVoiceLog;
import com.py.app.telecom.mysql.mapper.UserVoiceLogMapper;
import com.py.app.telecom.service.UserVoiceLogService;
import com.py.app.telecom.vo.CallsVo;
import com.py.app.telecom.vo.SmsesVo;
import com.py.app.telecom.vo.UserTelecomInfoVo;
import com.py.common.constant.Constants;
import com.py.common.utils.GsonUtil;
import com.py.common.utils.ParamUtil;
import org.apache.commons.lang.StringUtils;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jzl on 17/12/19.
 */
@Service
public class UserVoiceLogServiceImpl implements UserVoiceLogService {
    private static Logger logger = LoggerFactory.getLogger(UserVoiceLogServiceImpl.class);
    @Autowired
    private UserVoiceLogMapper userVoiceLogMapper;
    @Autowired
    private RestTemplate restTemplate;

    /** 先查mongo，无值，再查mysql
     *  查询运营商信息
     * @param userId
     * @param tableName
     * @return
     */
    @Override
    public UserVoiceLog findUserTeleInfo(Long userId, String tableName) {
        //先查mongo，无值，再查mysql
        UserVoiceLog userVoiceLog;
        userVoiceLog = getUserTeleInfoInMongo(userId, tableName);
        if (!ParamUtil.isEmpty(userVoiceLog)) {
            return userVoiceLog;
        }

        //mysql
        userVoiceLog = getUserVoiceLogByUid(userId, tableName);
        return userVoiceLog;
    }

    /**
     * 解析
     * @param voiceLog
     * @return
     */
    @Override
    public UserTelecomInfoVo handleVoiceLogToTelecomVo(UserVoiceLog voiceLog) {
        UserTelecomInfoVo vo = null;
        switch (voiceLog.getType()) {
            case "0":
                vo = handleForHulu(voiceLog.getLogjson());
                break;
            case "1":
                vo = handleForMohe(voiceLog.getLogjson());
                break;
            case "2":
                vo = handleForJuxinli(voiceLog.getLogjson());
                break;
            case "3":
                vo = handleForMojie(voiceLog.getLogjson());
                break;
            default:
                break;
        }
        return vo;
    }




    /*******************************************************************/

    /**
     * 解析魔蝎
     * @param logjson
     * @return
     */
    private UserTelecomInfoVo handleForMojie(String logjson) {
        List<CallsVo> callsVoList = new ArrayList<>();
        List<SmsesVo> smsesVoList = new ArrayList<>();
        JSONObject fieldJsonObj=(JSONObject) JSONObject.parse(logjson);
        String userPhone= StringUtils.trimToEmpty(fieldJsonObj.getString("mobile"));
        if (fieldJsonObj!=null && !fieldJsonObj.isEmpty()) {
            JSONArray callsJsonArr = fieldJsonObj.getJSONArray("calls");
            if(null!=callsJsonArr && callsJsonArr.size()>0){  //遍历通话记录
                for(int i=0;i<callsJsonArr.size();i++){
                    JSONObject callJsonObj=callsJsonArr.getJSONObject(i);
                    JSONArray itemsJsonArr  = callJsonObj.getJSONArray("items");//通话
                    if(null!=itemsJsonArr && itemsJsonArr.size()>0){
                        for(int j=0;j<itemsJsonArr.size();j++){
                            JSONObject item=itemsJsonArr.getJSONObject(j);
                            String otherCellPhone = StringUtils.trimToEmpty(item.getString("peer_number"));
                            String startTime = StringUtils.trimToEmpty(item.getString("time"));

                            CallsVo callsVo = new CallsVo();
                            callsVo.setStartTime(startTime);
                            callsVo.setOtherCellPhone(otherCellPhone);

                            callsVoList.add(callsVo);
                        }
                    }
                }
            }

            JSONArray smsesArr = fieldJsonObj.getJSONArray("smses");
            if(null!=smsesArr && smsesArr.size()>0){  //遍历短信记录
                for(int i=0;i<smsesArr.size();i++){
                    JSONObject smsesObj=smsesArr.getJSONObject(i);
                    JSONArray itemsJsonArr  = smsesObj.getJSONArray("items");//短信
                    if(null!=itemsJsonArr && itemsJsonArr.size()>0){
                        for(int j=0;j<itemsJsonArr.size();j++){
                            JSONObject item=itemsJsonArr.getJSONObject(j);
                            String otherCellPhone = StringUtils.trimToEmpty(item.getString("peer_number"));
                            String initType = StringUtils.trimToEmpty(item.getString("send_type"));
                            String startTime = StringUtils.trimToEmpty(item.getString("time"));

                            if("SEND".equalsIgnoreCase(initType)){
                                initType = "发送";
                            }else if("RECEIVE".equalsIgnoreCase(initType)){
                                initType = "收取";
                            }else{
                                initType = "未知";
                            }

                            SmsesVo smsesVo = new SmsesVo();
                            smsesVo.setStartTime(startTime);
                            smsesVo.setInitType(initType);
                            smsesVo.setOtherCellPhone(otherCellPhone);

                            smsesVoList.add(smsesVo);
                        }
                    }
                }
            }
        }
        UserTelecomInfoVo vo = new UserTelecomInfoVo();
        vo.setCalls(callsVoList);
        vo.setSmses(smsesVoList);
        return vo;
    }

    /**
     * 解析juxinli
     * @param logjson
     * @return
     */
    private UserTelecomInfoVo handleForJuxinli(String logjson) {
        List<CallsVo> callsVoList = new ArrayList<>();
        List<SmsesVo> smsesVoList = new ArrayList<>();

        JSONObject json=(JSONObject) JSONObject.parse(logjson);
        //raw_data
        JSONObject raw_data = json.getJSONObject("raw_data");
        //members
        JSONObject members = raw_data.getJSONObject("members");
        //接口调用状态
        String status = members.getString("status")==null?"":members.getString("status");
        if("success".equals(status)){
            //transactions--运营商记录
            JSONArray transactions = members.getJSONArray("transactions");
            if(null!=transactions && transactions.size()>0){
                for(int i=0;i<transactions.size();i++){
                    JSONObject transaction = transactions.getJSONObject(i);
                    //calls--通话记录
                    JSONArray calls = transaction.getJSONArray("calls");
                    if(null!=calls && calls.size()>0){  //遍历通话记录
                        for(int j=0;j<calls.size();j++){
                            JSONObject call = calls.getJSONObject(j);//通话
                            String startTime = call.get("start_time") == null ? ""
                                    : call.get("start_time").toString(); // 通话时间
                            String place = call.get("place") == null ? ""
                                    : call.get("place").toString();// 通话地点
                            String callType = call.get("init_type") == null ? ""
                                    : call.get("init_type").toString();// 通话类型
                            String otherCellPhone = call.get("other_cell_phone") == null ? ""
                                    : call.get("other_cell_phone").toString();// 对方号码
                            String cellPhone = call.getString("cell_phone") == null ? ""
                                    : call.getString("cell_phone");// 本机号码
                            String useTime = call.getString("use_time") == null ? ""
                                    : call.getString("use_time");// 用时 秒

                            CallsVo callsVo = new CallsVo();
                            callsVo.setStartTime(startTime);
                            callsVo.setPlace(place);
                            callsVo.setCallType(callType);
                            callsVo.setOtherCellPhone(otherCellPhone);
                            callsVo.setCellPhone(cellPhone);
                            callsVo.setUseTime(useTime);

                            callsVoList.add(callsVo);
                        }
                    }
                    //sms
                    JSONArray smses = transaction.getJSONArray("smses");
                    if(null!=smses && smses.size()>0){  //遍历sms
                        for(int j=0;j<smses.size();j++){
                            JSONObject sms = calls.getJSONObject(j);//
                            String startTime = sms.get("start_time") == null ? ""
                                    : sms.get("start_time").toString(); // 时间
                            String place = sms.get("place") == null ? ""
                                    : sms.get("place").toString();// 地点
                            String initType = sms.get("init_type") == null ? ""
                                    : sms.get("init_type").toString();// 类型
                            String otherCellPhone = sms.get("other_cell_phone") == null ? ""
                                    : sms.get("other_cell_phone").toString();// 对方号码
                            String cellPhone = sms.getString("cell_phone") == null ? ""
                                    : sms.getString("cell_phone");// 本机号码

                            SmsesVo smsesVo = new SmsesVo();
                            smsesVo.setStartTime(startTime);
                            smsesVo.setPlace(place);
                            smsesVo.setInitType(initType);
                            smsesVo.setOtherCellPhone(otherCellPhone);
                            smsesVo.setCellPhone(cellPhone);

                            smsesVoList.add(smsesVo);
                        }
                    }
                }
            }
        }
        UserTelecomInfoVo vo = new UserTelecomInfoVo();
        vo.setSmses(smsesVoList);
        vo.setCalls(callsVoList);
        return vo;
    }

    /**
     * 解析魔盒数据
     * @param logjson
     * @return
     */
    private UserTelecomInfoVo handleForMohe(String logjson) {
        List<CallsVo> callsVoList = new ArrayList<>();
        List<SmsesVo> smsesVoList = new ArrayList<>();
        JSONObject json=(JSONObject) JSONObject.parse(logjson);
        String data=json.getString("data");
        JSONObject data1=(JSONObject) JSONObject.parse(data);
        String taskdata1=data1.getString("task_data");
        JSONObject taskdata=(JSONObject) JSONObject.parse(taskdata1);
        //通话
        String logJson=taskdata.getString("call_info");
        JSONArray jsonArr = JSONArray.parseArray(logJson);
        if (jsonArr != null && jsonArr.size() > 0) {
            for (int m = 0; m < jsonArr.size(); m++) {
                JSONObject jsonObj = (JSONObject) jsonArr.get(m);
                JSONArray jsonArr_callrecord = jsonObj.getJSONArray("call_record");
                if(null!=jsonArr_callrecord&&jsonArr_callrecord.size()>0){
                    for(int n=0;n<jsonArr_callrecord.size();n++){
                        JSONObject detail = jsonArr_callrecord.getJSONObject(n);

                        String startTime = detail.get("call_start_time") == null ? "" : detail.get("call_start_time").toString(); // 通话时间
                        String place = detail.get("call_address") == null ? "" : detail.get("call_address").toString();// 通话地点
                        String callType = detail.get("call_type_name") == null ? "" : detail.get("call_type_name").toString();// 通话类型
                        String otherCellPhone = detail.get("call_other_number") == null ? ""
                                : detail.get("call_other_number").toString();// 对方号码
                        String cellPhone = data1.getString("user_mobile") == null ? "" : data1.getString("user_mobile");// 本机号码
                        String useTime = data1.getString("call_time") == null ? "" : data1.getString("call_time");// 本机号码

                        CallsVo callsVo = new CallsVo();
                        callsVo.setStartTime(startTime);
                        callsVo.setPlace(place);
                        callsVo.setCallType(callType);
                        callsVo.setOtherCellPhone(otherCellPhone);
                        callsVo.setCellPhone(cellPhone);
                        callsVo.setUseTime(useTime);

                        callsVoList.add(callsVo);
                    }
                }
            }
        }
        //短信
        String smsesJson = taskdata.getString("sms_info");
        JSONArray smsesArr = JSONArray.parseArray(smsesJson);
        if (smsesArr != null && smsesArr.size() > 0) {
            for (int n=0; n < smsesArr.size(); n++) {
                JSONObject jsonObj = (JSONObject) jsonArr.get(n);
                JSONArray recordArr = jsonObj.getJSONArray("sms_record");
                if (recordArr != null && recordArr.size() > 0 ) {
                    for (int m=0;m<recordArr.size();m++) {
                        JSONObject sms = recordArr.getJSONObject(m);

                        String startTime = sms.get("msg_start_time") == null ? "" : sms.get("msg_start_time").toString();
                        String place = sms.get("msg_address") == null ? "" : sms.get("msg_address").toString();// 地点
                        String initType = sms.get("msg_type") == null ? "" : sms.get("msg_type").toString();// 通话类型
                        String otherCellPhone = sms.get("msg_other_num") == null ? ""
                                : sms.get("msg_other_num").toString();// 对方号码
                        String cellPhone = data1.getString("user_mobile") == null ? "" : data1.getString("user_mobile");// 本机号码

                        SmsesVo smsesVo = new SmsesVo();
                        smsesVo.setStartTime(startTime);
                        smsesVo.setPlace(place);
                        smsesVo.setInitType(initType);
                        smsesVo.setOtherCellPhone(otherCellPhone);
                        smsesVo.setCellPhone(cellPhone);

                        smsesVoList.add(smsesVo);
                    }
                }

            }
        }
        UserTelecomInfoVo vo = new UserTelecomInfoVo();
        vo.setCalls(callsVoList);
        vo.setSmses(smsesVoList);
        return vo;
    }

    /**
     * 解析葫芦数据
     * @param logjson
     * @return
     */
    private UserTelecomInfoVo handleForHulu(String logjson) {
        List<CallsVo> callsVoList = new ArrayList<>();
        List<SmsesVo> smsesVoList = new ArrayList<>();
        JSONArray jsonArr = JSONArray.parseArray(logjson);
        if (jsonArr != null && jsonArr.size() > 0) {
            for (int m = 0; m < jsonArr.size(); m++) {
                JSONObject jsonObj = (JSONObject) jsonArr.get(m);
                if (jsonObj.get("calls") != null) //解析通话记录
                {
                    JSONArray callsArr = JSONArray.parseArray(jsonObj.get("calls").toString());
                    for (int n = 0; n < callsArr.size(); n++) {
                        JSONObject callsObj = (JSONObject) callsArr.get(n);
                        String startTime = callsObj.get("start_time") == null ? "" : callsObj.get("start_time").toString(); // 通话时间
                        String place = callsObj.get("place") == null ? "" : callsObj.get("place").toString();// 通话地点
                        String callType = callsObj.get("call_type") == null ? "" : callsObj.get("call_type").toString();// 通话类型
                        String otherCellPhone = callsObj.get("other_cell_phone") == null ? ""
                                : callsObj.get("other_cell_phone").toString();// 对方号码
                        String cellPhone = callsObj.get("cell_phone") == null ? "" : callsObj.get("cell_phone").toString();// 本机号码

                        CallsVo callsVo = new CallsVo();
                        callsVo.setStartTime(startTime);
                        callsVo.setPlace(place);
                        callsVo.setCallType(callType);
                        callsVo.setOtherCellPhone(otherCellPhone);
                        callsVo.setCellPhone(cellPhone);

                        callsVoList.add(callsVo);
                    }
                }

                if (jsonObj.get("smses") != null) {
                    //解析短信记录
                    JSONArray smsesArr = JSONArray.parseArray(jsonObj.get("smses").toString());
                    for (int n = 0; n < smsesArr.size(); n++) {
                        JSONObject smsesObj = (JSONObject) smsesArr.get(n);
                        String startTime = smsesObj.get("start_time") == null ? "" : smsesObj.get("start_time").toString();
                        String place = smsesObj.get("place") == null ? "" : smsesObj.get("place").toString();
                        String initType = smsesObj.get("init_type") == null ? "" : smsesObj.get("init_type").toString();
                        String otherCellPhone = smsesObj.get("other_cell_phone") == null ? ""
                                : smsesObj.get("other_cell_phone").toString();// 对方号码
                        String cellPhone = smsesObj.get("cell_phone") == null ? "" : smsesObj.get("cell_phone").toString();// 本机号码

                        SmsesVo smsesVo = new SmsesVo();
                        smsesVo.setStartTime(startTime);
                        smsesVo.setPlace(place);
                        smsesVo.setInitType(initType);
                        smsesVo.setOtherCellPhone(otherCellPhone);
                        smsesVo.setCellPhone(cellPhone);

                        smsesVoList.add(smsesVo);
                    }
                }
            }
        }
        UserTelecomInfoVo vo = new UserTelecomInfoVo();
        vo.setCalls(callsVoList);
        vo.setSmses(smsesVoList);
        return vo;
    }

    /**
     * 从mysql查询运营商信息
     * @param userId
     * @param tableName
     * @return
     */
    private UserVoiceLog getUserVoiceLogByUid(Long userId, String tableName) {
        GetUserVoiceLogRequestBo requestBo = new GetUserVoiceLogRequestBo();
        requestBo.setUserId(userId);
        requestBo.setTableName(tableName);

        UserVoiceLog userVoiceLog = userVoiceLogMapper.getUserVoiceLogByUid(requestBo);
        return userVoiceLog;
    }

    /**
     * 从mongo查询运营商信息
     * @param userId
     * @param tableName
     * @return
     */
    private UserVoiceLog getUserTeleInfoInMongo(Long userId, String tableName) {
        String mongJson = restTemplate.getForObject("http://cloud-intergration/mongo/findOne?dbName="+
                Constants.MONGODB_NAME_XQD + "&collectionName=" +
                tableName + "&key=user_id&value=" + userId, String.class);
        if (ParamUtil.isEmpty(mongJson)) {
            logger.info("getUserTeleInfoInMongo方法在mongo里没有查询到该条记录，userId:{},tableName:{}", userId, tableName);
            return null;
        }
        Document document = GsonUtil.GsonToBean(mongJson, Document.class);
        if (ParamUtil.isEmpty(document) || document.isEmpty()) {
            return null;
        }

        UserVoiceLog userVoiceLog = new UserVoiceLog();
        userVoiceLog.setId(document.get("id", Long.class));
        userVoiceLog.setUserId(document.get("user_id", Long.class));
        userVoiceLog.setLogjson(document.getString("logjson"));
        userVoiceLog.setType(document.getString("type"));
        return userVoiceLog;
    }
}
