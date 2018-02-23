package com.py.app.telecom.controllers;

import com.py.app.telecom.bo.GetTelecomInfoRequestBo;
import com.py.app.telecom.mysql.entities.CLUserBaseInfo;
import com.py.app.telecom.mysql.entities.UserVoiceLog;
import com.py.app.telecom.service.*;
import com.py.app.telecom.vo.MerchantInfoVo;
import com.py.app.telecom.vo.UserTelecomInfoVo;
import com.py.common.constant.Constants;
import com.py.common.protocol.Response;
import com.py.common.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ResourceBundle;

/**运营商接口服务
 * Created by jzl on 17/12/19.
 */
@RestController
public class TelecomController {
    private static Logger logger = LoggerFactory.getLogger(TelecomController.class);
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
    private static final String PRIVATEKEY = resourceBundle.getString("private.key");

    @Autowired
    private UserVoiceLogService userVoiceLogService;
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private UserBaseInfoService userBaseInfoService;
    @Autowired
    private UserAuthService userAuthService;
    @Autowired
    private InterfaceMerchantSummaryService summaryService;




    @RequestMapping(value = "/get_telecom_info", method = {RequestMethod.POST, RequestMethod.GET})
    public String getTelecomInfo(@RequestParam(value = "params", required = false) String params) {
        logger.info("查询运营商信息接口收到的参数params:{}", params);
        try {
            //1.解密
            if (ParamUtil.isEmpty(params)) {
                logger.info("查询运营商接口请求参数为空，返回");
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.NONEPARAM, Code.msg.NONEPARAM));
            }
            String dataStr;
            try {
                dataStr = RSAUtil.decrypt(params, PRIVATEKEY, "UTF-8");
            }catch (Exception e) {
                logger.error("查询运营商接口解密异常，e:{}", e);
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.DECRYPTERROR, Code.msg.DECRYPTERROR));
            }

            //2.解析属性
            GetTelecomInfoRequestBo requestBo = GsonUtil.GsonToBean(dataStr, GetTelecomInfoRequestBo.class);
            if (ParamUtil.isEmpty(requestBo)) {
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.PARAMERROR, Code.msg.PARAMERROR));
            }

            //3.查询商户信息
            MerchantInfoVo merchantInfoVo = merchantService.getMerchantInfo(requestBo.getMerchantCode());
            if (ParamUtil.isEmpty(merchantInfoVo)) {
                logger.info("查询运营商接口，无此商户,merchantCode:{}", requestBo.getMerchantCode());
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.NOMERCHANT, Code.msg.NOMERCHAT));
            }

            //4.查询用户信息
            CLUserBaseInfo userBaseInfo = userBaseInfoService.findOneByPhone(requestBo.getPhone());
            if (ParamUtil.isEmpty(userBaseInfo)) {
                logger.info("运营商接口，无此用户，phone:{}", requestBo.getPhone());
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.NOTHISUSER, Code.msg.NOTHISUSER));
            }

            //5.查询用户认证信息
            boolean isAuth = userAuthService.isTheUserAuthed(userBaseInfo.getUserId());
            if (!isAuth) {
                logger.info("查询运营商接口，该用户的手机号未认证，phone:{}", requestBo.getPhone());
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.NOPHONETELEINFO, Code.msg.NOPHONETELEINFO));
            }

            //6.根据uid分表
            String tableName = ShareTableUtil.generateTableName(Constants.TABLE_USER_VOICE_LOG, userBaseInfo.getUserId(), Constants.SHARED_TABLE_RULE);

            //7.查询－－先查mongo，无值，再查mysql
            UserVoiceLog voiceLog = userVoiceLogService.findUserTeleInfo(userBaseInfo.getUserId(), tableName);
            if (ParamUtil.isEmpty(voiceLog)) {
                logger.info("运营商接口，查询的运营商信息为空,返回");
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.NOPHONETELEINFO, Code.msg.NOPHONETELEINFO));
            }
            //解析数据
            UserTelecomInfoVo vo = userVoiceLogService.handleVoiceLogToTelecomVo(voiceLog);
            //8.记录请求
            summaryService.recordThisAccess(requestBo.getMerchantCode(), "get_telecom_info", 4);
            logger.info("查询运营商接口，记录调用服务成功，merchantCode:{}", requestBo.getMerchantCode());

            //9.组装数据，加密返回
            String encyptStr = RSAUtil.encryptByPublicKey(GsonUtil.toJson(vo), merchantInfoVo.getPublicKey());
            logger.info("查询运营商接口返回的数据:{}", encyptStr);
            return GsonUtil.toJson(Response.successResponse(encyptStr));
        }catch (Exception e) {
            logger.error("查询运营商接口服务出现异常，e:{}", e);
            return GsonUtil.toJson(Response.systemErrorResponse());
        }
    }
}
