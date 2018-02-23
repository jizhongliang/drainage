package com.py.app.user.controllers;

import com.py.app.user.bo.GetUserInfoRequestBo;
import com.py.app.user.dao.mysql.entities.CLUser;
import com.py.app.user.dao.mysql.entities.CLUserBaseInfo;
import com.py.app.user.service.*;
import com.py.app.user.vo.MerchantInfoVo;
import com.py.app.user.vo.UserInfoVo;
import com.py.common.protocol.Response;
import com.py.common.utils.Code;
import com.py.common.utils.GsonUtil;
import com.py.common.utils.ParamUtil;
import com.py.common.utils.RSAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ResourceBundle;

/**用户信息服务接口
 * Created by jzl on 17/12/13.
 */
@RestController
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
    private static final String PRIVATEKEY = resourceBundle.getString("private.key");
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserBaseInfoService userBaseInfoService;
    @Autowired
    private InterfaceMerchantSummaryService summaryService;


    /**
     * 获取用户信息接口
     * @param params
     * @return
     */
    @RequestMapping(value = "/get_user_info", method = {RequestMethod.POST, RequestMethod.GET})
    public String getUserInfo(@RequestParam(value = "params", required = false) String params) {
        try {
            logger.info("获取用户信息接口收到的参数:params:{}", params);
            if (ParamUtil.isEmpty(params)) {
                logger.info("参数为空,返回");
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.NONEPARAM, Code.msg.NONEPARAM));
            }
            //解密
            String decStr;
            try {
                decStr = RSAUtil.decrypt(params, PRIVATEKEY, "utf-8");
            } catch (Exception e) {
                logger.error("用户信息接口解密出现异常,e:{}", e);
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.DECRYPTERROR, Code.msg.DECRYPTERROR));
            }

            //解析属性
            GetUserInfoRequestBo userInfoRequestBo = GsonUtil.GsonToBean(decStr, GetUserInfoRequestBo.class);
            if (ParamUtil.isEmpty(userInfoRequestBo)) {
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.PARAMERROR, Code.msg.PARAMERROR));
            }

            //查询该商户
            MerchantInfoVo merchantInfoVo = merchantService.getMerchantInfo(userInfoRequestBo.getMerchantCode());
            if (ParamUtil.isEmpty(merchantInfoVo)) {
                logger.info("获取用户信息接口，无此商户，merchantCode:{}", userInfoRequestBo.getMerchantCode());
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.NOMERCHANT, Code.msg.NOMERCHAT));
            }

            //查询用户信息
            CLUserBaseInfo userBaseInfo = userBaseInfoService.findOneByPhone(userInfoRequestBo.getPhone());
            if (ParamUtil.isEmpty(userBaseInfo)) {
                logger.info("获取用户基本信息实体为空，返回，phone:{}", userInfoRequestBo.getPhone());
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.NOTHISUSER, Code.msg.NOTHISUSER));
            }
            CLUser user = userService.findOneByUid(userBaseInfo.getUserId());
            if (ParamUtil.isEmpty(user)) {
                logger.info("获取用户信息实体为空，返回，phone:{}", userInfoRequestBo.getPhone());
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.NOTHISUSER, Code.msg.NOTHISUSER));
            }
            //记录调用记录
            summaryService.recordThisAccess(userInfoRequestBo.getMerchantCode(), "get_user_info", 1);
            //组装
            UserInfoVo vo = handleUserInfos(user, userBaseInfo);
            //获取公钥，加密 返回
            String dataStr = GsonUtil.toJson(vo);
            logger.info("返回串:{}", dataStr);
            String encyptStr = RSAUtil.encryptByPublicKey(dataStr, merchantInfoVo.getPublicKey());
            logger.info("加密后的串:{}", encyptStr);
            return GsonUtil.toJson(Response.successResponse(encyptStr));
        }catch (Exception e) {
            logger.info("获取用户信息接口出现异常，e:{}", e);
            return GsonUtil.toJson(Response.systemErrorResponse());
        }
    }


    /************************** 私有方法 *******************************************************/
    /**
     * 组装用户信息，用于返回
     * @param user
     * @param userBaseInfo
     * @return
     */
    private UserInfoVo handleUserInfos(CLUser user, CLUserBaseInfo userBaseInfo) {
        UserInfoVo vo = new UserInfoVo();
        vo.setUid(String.valueOf(user.getId()));
        vo.setRegisterClient(user.getRegisterClient());
        vo.setPhone(userBaseInfo.getPhone());
        vo.setRealName(userBaseInfo.getRealName());
        vo.setAge(String.valueOf(userBaseInfo.getAge()));
        vo.setSex(userBaseInfo.getSex());
        vo.setNational(userBaseInfo.getNational());
        vo.setIdNo(userBaseInfo.getIdNo());
        vo.setIdAddr(userBaseInfo.getIdAddr());
        vo.setLivingImg(userBaseInfo.getLivingImg());
        vo.setOcrImg(userBaseInfo.getOcrImg());
        vo.setFrontImg(userBaseInfo.getFrontImg());
        vo.setBackImg(userBaseInfo.getBackImg());
        vo.setEducation(userBaseInfo.getEducation());
        vo.setMarryState(userBaseInfo.getMarryState());
        vo.setCompanyName(userBaseInfo.getCompanyName());
        vo.setCompanyPhone(userBaseInfo.getCompanyPhone());
        vo.setCompanyAddr(userBaseInfo.getCompanyAddr());
        vo.setCompanyDetailAddr(userBaseInfo.getCompanyDetailAddr());
        vo.setSalary(userBaseInfo.getSalary());
        vo.setLiveAddr(userBaseInfo.getLiveAddr());
        vo.setLiveDetailAddr(userBaseInfo.getLiveDetailAddr());
        vo.setState(userBaseInfo.getState());
        vo.setBlackReason(userBaseInfo.getBlackReason());
        vo.setLevel(String.valueOf(userBaseInfo.getLevel()));
        return vo;
    }
}
