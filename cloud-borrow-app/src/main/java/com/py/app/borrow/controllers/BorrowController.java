package com.py.app.borrow.controllers;

import com.py.app.borrow.bo.GetBorrowInfoRequestBo;
import com.py.app.borrow.mysql.entities.CLBorrow;
import com.py.app.borrow.mysql.entities.CLBorrowRepay;
import com.py.app.borrow.mysql.entities.CLUserBaseInfo;
import com.py.app.borrow.service.*;
import com.py.app.borrow.vo.BorrowInfoVo;
import com.py.app.borrow.vo.MerchantInfoVo;
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

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by jzl on 17/12/18.
 */
@RestController
public class BorrowController {
    private static Logger logger = LoggerFactory.getLogger(BorrowController.class);
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
    private static final String PRIVATEKEY = resourceBundle.getString("private.key");
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private UserBaseInfoService userBaseInfoService;
    @Autowired
    private BorrowService borrowService;
    @Autowired
    private BorrowRepayService borrowRepayService;
    @Autowired
    private InterfaceMerchantSummaryService summaryService;





    @RequestMapping(value = "/get_borrow_info", method = {RequestMethod.POST, RequestMethod.GET})
    public String getBorrowInfo(@RequestParam(value = "params", required = false) String params) {
        logger.info("借款信息接口收到的参数：{}", params);
        try {
            //1.解密
            if (ParamUtil.isEmpty(params)) {
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.NONEPARAM, Code.msg.NONEPARAM));
            }
            String decStr;
            try {
                decStr = RSAUtil.decrypt(params, PRIVATEKEY, "UTF-8");
            }catch (Exception e) {
                logger.error("借款信息接口解密异常，e:{}", e);
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.DECRYPTERROR, Code.msg.DECRYPTERROR));
            }

            //2.解析请求属性
            GetBorrowInfoRequestBo requestBo = GsonUtil.GsonToBean(decStr, GetBorrowInfoRequestBo.class);
            if (ParamUtil.isEmpty(requestBo)) {
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.PARAMERROR, Code.msg.PARAMERROR));
            }

            //3.查询商户信息
            MerchantInfoVo merchantInfoVo = merchantService.getMerchantInfo(requestBo.getMerchantCode());
            if (ParamUtil.isEmpty(merchantInfoVo)) {
                logger.info("借款信息接口查询商户信息为空,无此商户,merchantCode:{}", requestBo.getMerchantCode());
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.NOMERCHANT, Code.msg.NOMERCHAT));
            }

            //4.查询借款信息和用户详细信息
            CLUserBaseInfo userBaseInfo = userBaseInfoService.findOneByPhone(requestBo.getPhone());
            if (ParamUtil.isEmpty(userBaseInfo)) {
                logger.info("借款信息查询接口无此用户，phone:{}", requestBo.getPhone());
                return GsonUtil.toJson(Response.failedResponse(Code.codeData.NOTHISUSER, Code.msg.NOTHISUSER));
            }

            List<CLBorrow> borrowList = borrowService.findByUid(userBaseInfo.getUserId());
            if (ParamUtil.isEmpty(borrowList) || borrowList.size() < 1) {
                logger.info("查询借款信息接口，此用户无借款记录，uid:{}", userBaseInfo.getUserId());
                return GsonUtil.toJson(Response.successResponse(new ArrayList<>()));
            }
            logger.info("查询此用户的借款记录数量:{}", borrowList.size());

            List<CLBorrowRepay> borrowRepayList = borrowRepayService.findByUid(userBaseInfo.getUserId());

            //5.记录请求
            summaryService.recordThisAccess(requestBo.getMerchantCode(), "get_borrow_info", 3);
            logger.info("查询借款信息接口，记录调用服务成功，merchantCode:{}", requestBo.getMerchantCode());

            //6.组装返回参数
            List<BorrowInfoVo> voList = handleBorrowInfos(userBaseInfo, borrowList, borrowRepayList);
            //7.获取公钥加密
            String dataStr = GsonUtil.toJson(voList);
            String encyptStr = RSAUtil.encryptByPublicKey(dataStr, merchantInfoVo.getPublicKey());

            //8.返回
            logger.info("查询借款信息接口返回参数：data:{}", encyptStr);
            return GsonUtil.toJson(Response.successResponse(encyptStr));

        }catch (Exception e) {
            logger.error("借款信息接口出现异常，e:{}", e);
            return GsonUtil.toJson(Response.systemErrorResponse());
        }
    }


    /*******************************************************************************/
    /**
     * 处理结果集
     * @param userBaseInfo
     * @param borrowList
     * @param borrowRepayList
     * @return
     */
    private List<BorrowInfoVo> handleBorrowInfos(CLUserBaseInfo userBaseInfo, List<CLBorrow> borrowList, List<CLBorrowRepay> borrowRepayList) {
        List<BorrowInfoVo> voList = new ArrayList<>();
        for (CLBorrow borrow : borrowList) {
            BorrowInfoVo vo = new BorrowInfoVo();
            vo.setUid(String.valueOf(userBaseInfo.getUserId()));
            vo.setRealName(userBaseInfo.getRealName());
            vo.setAmount(String.valueOf(borrow.getAmount()));
            vo.setBorrowTime(String.valueOf(borrow.getCreateTime()));
            vo.setLimitDays(borrow.getTimeLimit());
            vo.setStatus(borrow.getState());
            vo.setAddress(borrow.getAddress());
            for (CLBorrowRepay borrowRepay : borrowRepayList) {
                if (borrow.getId() == borrowRepay.getBorrowId()) {
                    vo.setRepayTime(String.valueOf(borrowRepay.getRepayTime()));
                    vo.setPenaltyAmount(String.valueOf(borrowRepay.getPenaltyAmout()));
                    vo.setPenaltyDays(String.valueOf(borrowRepay.getPenaltyDay()));
                }
            }
            voList.add(vo);
        }

        return voList;
    }
}
