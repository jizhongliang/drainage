/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.py.common.service.entity.merchant.urls.MerchantUrlConstants;
import com.py.common.utils.ParamUtil;
import com.py.common.utils.ValidateUtil;
import com.py.merchant.base.BaseBizErrorEnums;
import com.py.merchant.base.BaseBizException;
import com.py.merchant.base.BaseController;
import com.py.merchant.base.UserContext;
import com.py.merchant.base.request.merchant.MerchantInsertRequest;
import com.py.merchant.base.request.merchant.MerchantQueryRequest;
import com.py.merchant.base.request.merchant.MerchantUpdateRequest;
import com.py.merchant.base.request.merchant.MerchantUpdateStatusRequest;
import com.py.merchant.service.MerchantService;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantController.java, v 0.1 2017年12月13日 下午3:12:04 jinlilong Exp $
 */
@RestController
public class MerchantController extends BaseController {

    @Autowired
    private MerchantService merchantService;

    /**
     * 
     * @param request
     * @param map
     * @param id
     * @return
     */
    @RequestMapping(value = MerchantUrlConstants.QUERY_MERCHANT_BY_ID, method = RequestMethod.GET)
    @ApiOperation(value = "根据ID查询商户")
    public String queryMerchantById(ModelMap map, final long id) {

        return this.httpExecute(map, new ControllerCallback() {

            public void check(ModelMap map, UserContext context) {
                if (id <= 0) {
                    throw new BaseBizException(BaseBizErrorEnums.PARAM_IS_ILLEGAL, "id不能为空");
                }
            }

            public void execute(ModelMap map, UserContext context) {
                map.put(DATA, merchantService.queryById(id));
            }
        });
    }

    /**
     * 
     * @param request
     * @param map
     * @param code
     * @return
     */
    @RequestMapping(value = MerchantUrlConstants.QUERY_MERCHANT_BY_CODE, method = RequestMethod.GET)
    @ApiOperation(value = "根据商户号查询商户")
    public String queryMerchantByCode(ModelMap map, final String code) {

        return this.httpExecute(map, new ControllerCallback() {

            public void check(ModelMap map, UserContext context) {
                if (ParamUtil.isEmpty(code)) {
                    throw new BaseBizException(BaseBizErrorEnums.PARAM_IS_ILLEGAL, "商户号不能为空");
                }
            }

            public void execute(ModelMap map, UserContext context) {
                map.put(DATA, merchantService.queryByCode(code));
            }
        });
    }

    /**
     * 
     * @param request
     * @param map
     * @param req
     * @return
     */
    @RequestMapping(value = MerchantUrlConstants.INSERT_MERCHANT, method = RequestMethod.POST)
    @ApiOperation(value = "创建商户")
    public String insertMerchant(ModelMap map, MerchantInsertRequest req) {

        return this.httpExecute(map, new ControllerCallback() {

            public void check(ModelMap map, UserContext context) {
                req.setCreator(context.getName());
                ValidateUtil.validate(req);
            }

            public void execute(ModelMap map, UserContext context) {
                map.put(DATA, merchantService.insertMerchant(req));
            }
        });
    }

    /**
     * 
     * @param map
     * @param req
     * @return
     */
    @RequestMapping(value = MerchantUrlConstants.UPDATE_MERCHANT, method = { RequestMethod.POST })
    @ApiOperation(value = "更新商户")
    public String updateMerchantStatus(ModelMap map, MerchantUpdateRequest req) {
        return this.httpExecute(map, new ControllerCallback() {

            public void check(ModelMap map, UserContext context) {
                req.setCreator(context.getName());
                ValidateUtil.validate(req);
            }

            public void execute(ModelMap map, UserContext context) {
                map.put(DATA, merchantService.updateMerchant(req));
            }
        });
    }

    /**
     * 
     * @param map
     * @param req
     * @return
     */
    @RequestMapping(value = MerchantUrlConstants.UPDATE_MERCHANT_STATUS, method = { RequestMethod.POST })
    @ApiOperation(value = "更新商户状态")
    public String updateMerchantStatus(ModelMap map, MerchantUpdateStatusRequest req) {
        return this.httpExecute(map, new ControllerCallback() {

            public void check(ModelMap map, UserContext context) {
                req.setCreator(context.getName());
                ValidateUtil.validate(req);
            }

            public void execute(ModelMap map, UserContext context) {
                map.put(DATA, merchantService.updateMerchantStatus(req));
            }
        });
    }

    /**
     * 
     * @param request
     * @param map
     * @param req
     * @return
     */
    @RequestMapping(value = MerchantUrlConstants.QUERY_PAGE_MERCHANT, method = RequestMethod.GET)
    @ApiOperation(value = "商户分页查询")
    public String queryPageMerchant(ModelMap map, MerchantQueryRequest req) {

        return this.httpExecute(map, new ControllerCallback() {

            public void execute(ModelMap map, UserContext context) {
                map.put(DATA, merchantService.pageQuery(req));
                map.put(TOTAL, merchantService.pageQueryCount(req));
            }
        });
    }

    /**
     * 
     * @param request
     * @param map
     * @param req
     * @return
     */
    @RequestMapping(value = MerchantUrlConstants.DELETE_MERCHANT, method = RequestMethod.GET)
    @ApiOperation(value = "商户删除")
    public String queryPageMerchant(ModelMap map, long id) {

        return this.httpExecute(map, new ControllerCallback() {
            public void check(ModelMap map, UserContext context) {
                if (id <= 0) {
                    throw new BaseBizException(BaseBizErrorEnums.PARAM_IS_ILLEGAL, "id不能为空");
                }
            }

            public void execute(ModelMap map, UserContext context) {
                map.put(DATA, merchantService.deleteMerchant(id));
            }
        });
    }

}
