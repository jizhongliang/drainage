package com.py.app.entrance.controllers;

import com.py.app.entrance.mysql.entities.CLEntranceMerchants;
import com.py.app.entrance.service.EntranceMerchantService;
import com.py.app.entrance.service.EntranceMerchantSummaryService;
import com.py.app.entrance.vo.EntranceAccessResponseVo;
import com.py.common.protocol.Response;
import com.py.common.utils.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jzl on 17/12/22.
 */
@Controller
@RequestMapping(value = "/entrance", method = RequestMethod.POST)
public class EntranceController {
    private static Logger logger = LoggerFactory.getLogger(EntranceController.class);
    private static final String ENTRANCEACCESS_METHOD_NAME = "/entrance/access";
    @Autowired
    private EntranceMerchantService merchantService;
    @Autowired
    private EntranceMerchantSummaryService summaryService;



    @ResponseBody
    @RequestMapping(value = "/access", method = RequestMethod.POST)
    public Response entranceAccess(@RequestParam(value = "merchantCode", required = false) String merchantCode,
                                   @RequestParam(value = "sourceFrom", required = false) String sourceFrom) {
        try {
            logger.info("引流接口entranceAccess方法收到的参数：merchantCode:{}, sourceFrom:{}", merchantCode, sourceFrom);
            //1.校验商户
            boolean checkMer = merchantService.checkMerchantIsAble(merchantCode);
            if (!checkMer) {
                return Response.failedResponse("商户校验不通过");
            }

            //2.查询需要返回的数据
            CLEntranceMerchants merchant = merchantService.findMerchantByCodeAndStatus(merchantCode);

            //3.记录调用
            summaryService.recordAccess(merchantCode, Integer.valueOf(sourceFrom), ENTRANCEACCESS_METHOD_NAME, merchant.getForwardUrl());

            //4.返回
            EntranceAccessResponseVo vo = new EntranceAccessResponseVo();
            vo.setForwardUrl(merchant.getForwardUrl());
            logger.info("返回的参数:{}", GsonUtil.toJson(vo));
            return Response.successResponse(vo);
        }catch (Exception e) {
            logger.error("引流接口entranceAccess出现异常,e:{}", e);
            return Response.systemErrorResponse();
        }

    }
}
