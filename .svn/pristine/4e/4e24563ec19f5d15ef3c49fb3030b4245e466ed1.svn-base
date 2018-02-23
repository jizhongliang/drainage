package com.py.app.account.controllers;

import com.py.app.account.bo.GetAccountInfoRequestBo;
import com.py.app.account.mysql.entities.CLBankCard;
import com.py.app.account.mysql.entities.CLUserBaseInfo;
import com.py.app.account.service.BankCardService;
import com.py.app.account.service.InterfaceMerchantSummaryService;
import com.py.app.account.service.MerchantService;
import com.py.app.account.service.UserBaseInfoService;
import com.py.app.account.vo.AccountInfoVo;
import com.py.app.account.vo.MerchantInfoVo;
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

/**
 * Created by jzl on 17/12/16.
 */
@RestController
public class AccountController {
    private static Logger logger = LoggerFactory.getLogger(AccountController.class);
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
    private static final String PRIVATEKEY = resourceBundle.getString("private.key");
    @Autowired
    private UserBaseInfoService userBaseInfoService;
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private BankCardService bankCardService;
    @Autowired
    private InterfaceMerchantSummaryService summaryService;



    @RequestMapping(value = "/get_account_info", method = {RequestMethod.POST, RequestMethod.GET})
    public String getAccountInfo(@RequestParam(value = "params", required = false) String params) {
        logger.info("查询开户信息接口收到的参数：params:{}", params);
        try {
            //1.解密
            if (ParamUtil.isEmpty(params)) {
                logger.info("请求参数为空，返回");
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.NONEPARAM, Code.msg.NONEPARAM));
            }

            String decStr;
            try {
                decStr = RSAUtil.decrypt(params, PRIVATEKEY, "utf-8");
            } catch (Exception e) {
                logger.error("用户信息接口解密出现异常,e:{}", e);
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.DECRYPTERROR, Code.msg.DECRYPTERROR));
            }
            //解析属性
            GetAccountInfoRequestBo requestBo = GsonUtil.GsonToBean(decStr, GetAccountInfoRequestBo.class);
            if (ParamUtil.isEmpty(requestBo)) {
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.PARAMERROR, Code.msg.PARAMERROR));
            }

            //2.查询商户信息
            MerchantInfoVo merchantInfoVo = merchantService.getMerchantInfo(requestBo.getMerchantCode());
            if (ParamUtil.isEmpty(merchantInfoVo)) {
                logger.info("获取开户信息接口，无此商户，merchantCode:{}", requestBo.getMerchantCode());
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.NOMERCHANT, Code.msg.NOMERCHAT));
            }

            //3.查询开户信息和用户信息
            CLUserBaseInfo userBaseInfo = userBaseInfoService.findOneByPhone(requestBo.getPhone());
            if (ParamUtil.isEmpty(userBaseInfo)) {
                logger.info("查询账户信息接口，无此用户，phone:{}", requestBo.getPhone());
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.NOTHISUSER, Code.msg.NOTHISUSER));
            }

            CLBankCard bankCard = bankCardService.findOneByUid(userBaseInfo.getUserId());
            if (ParamUtil.isEmpty(bankCard)) {
                logger.info("查询账户信息接口，无此用户的开户信息,phone:{},uid:{}",requestBo.getPhone(), userBaseInfo.getUserId());
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.NOTHISUSER, Code.msg.NOTHISUSER));
            }

            //4.记录请求次数和记录
            summaryService.recordThisAccess(requestBo.getMerchantCode(), "get_account_info", 2);
            logger.info("调用开户信息服务，请求记录成功, merchantCode:{}", requestBo.getMerchantCode());

            //5.组装返回
            AccountInfoVo vo = handleAccountInfos(userBaseInfo, bankCard);
            //6.获取公钥，加密
            String dataStr = GsonUtil.toJson(vo);
            String encyptStr = RSAUtil.encryptByPublicKey(dataStr, merchantInfoVo.getPublicKey());
            //7.返回
            logger.info("查询开户信息接口返回的参数：data:{}", encyptStr);
            return GsonUtil.toJson(Response.successResponse(encyptStr));
        }catch (Exception e) {
            logger.error("查询开户信息接口出现异常，e:{}", e);
            return GsonUtil.toJson(Response.systemErrorResponse());
        }
    }


    /*****************************************************************************/
    /**
     * 组装信息
     * @param userBaseInfo
     * @param bankCard
     * @return
     */
    private AccountInfoVo handleAccountInfos(CLUserBaseInfo userBaseInfo, CLBankCard bankCard) {
        AccountInfoVo vo = new AccountInfoVo();
        vo.setUid(String.valueOf(userBaseInfo.getUserId()));
        vo.setRealName(userBaseInfo.getRealName());
        vo.setBank(bankCard.getBank());
        vo.setCardNo(bankCard.getCardNo());
        return vo;
    }
}
