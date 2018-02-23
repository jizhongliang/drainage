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
import com.py.merchant.base.request.merchant.MerchantPermissionRequest;
import com.py.merchant.service.MerchantPermissionService;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author jinlilong
 * @version $Id: MerchantPermissionController.java, v 0.1 2017年12月14日 下午1:39:06 jinlilong Exp $
 */
@RestController
public class MerchantPermissionController extends BaseController {

    /**  */
    @Autowired
    private MerchantPermissionService merchantPermissionService;

    /**
     * 
     * @param request
     * @param map
     * @param merchantCode
     * @return
     */
    @RequestMapping(value = MerchantUrlConstants.QUERY_MERCHANT_PERMISSION_BY_CODE, method = RequestMethod.GET)
    @ApiOperation(value = "根据商户号查询所有的权限")
    public String queryMerchantPermissionByCode(ModelMap map, final String merchantCode) {

        return this.httpExecute(map, new ControllerCallback() {

            public void check(ModelMap map, UserContext context) {
                if (ParamUtil.isEmpty(merchantCode)) {
                    throw new BaseBizException(BaseBizErrorEnums.PARAM_IS_ILLEGAL, "商户号不能为空");
                }
            }

            public void execute(ModelMap map, UserContext context) {
                map.put(DATA, merchantPermissionService.queryMerchantPermission(merchantCode));
            }
        });
    }

    /**
     * 
     * @param map
     * @param merchantCode
     * @return
     */
    @RequestMapping(value = MerchantUrlConstants.QUERY_MERCHANT_NO_PERMISSION, method = RequestMethod.GET)
    @ApiOperation(value = "根据商户Id该商户未获得的权限")
    public String queryMerchantNoPermission(ModelMap map, final long merchantId) {

        return this.httpExecute(map, new ControllerCallback() {

            public void check(ModelMap map, UserContext context) {
                if (merchantId <= 0) {
                    throw new BaseBizException(BaseBizErrorEnums.PARAM_IS_ILLEGAL, "商户Id不能为空");
                }
            }

            public void execute(ModelMap map, UserContext context) {
                map.put(DATA, merchantPermissionService.queryMerchantNoPermission(merchantId));
            }
        });
    }

    /**
     * 
     * @param map
     * @param merchantCode
     * @return
     */
    @RequestMapping(value = MerchantUrlConstants.QUERY_MERCHANT_PERMISSION, method = RequestMethod.GET)
    @ApiOperation(value = "根据商户Id查询所有的权限")
    public String queryMerchantPermission(ModelMap map, final long merchantId) {

        return this.httpExecute(map, new ControllerCallback() {

            public void check(ModelMap map, UserContext context) {
                if (merchantId <= 0) {
                    throw new BaseBizException(BaseBizErrorEnums.PARAM_IS_ILLEGAL, "商户ID不能为空");
                }
            }

            public void execute(ModelMap map, UserContext context) {
                map.put(DATA, merchantPermissionService.queryMerchantPermission(merchantId));
            }
        });
    }

    /**
     * 
     * @param map
     * @param req
     * @return
     */
    @RequestMapping(value = MerchantUrlConstants.INSERT_MERCHANT_PERMISSION, method = RequestMethod.POST)
    @ApiOperation(value = "新增商户权限")
    public String queryMerchantPermissionByCode(ModelMap map, final MerchantPermissionRequest req) {

        return this.httpExecute(map, new ControllerCallback() {

            public void check(ModelMap map, UserContext context) {
                req.setCreator(context.getName());
                ValidateUtil.validate(req);
            }

            public void execute(ModelMap map, UserContext context) {
                map.put(DATA, merchantPermissionService.insertMerchantPermission(req));
            }
        });
    }

    /**
     * 
     * @param map
     * @param req
     * @return
     */
    @RequestMapping(value = MerchantUrlConstants.DELETE_MERCHANT_PERMISSION, method = RequestMethod.POST)
    @ApiOperation(value = "删除商户权限")
    public String DeleteMerchantPermission(ModelMap map, final MerchantPermissionRequest req) {

        return this.httpExecute(map, new ControllerCallback() {

            public void check(ModelMap map, UserContext context) {
                req.setCreator(context.getName());
                ValidateUtil.validate(req);
            }

            public void execute(ModelMap map, UserContext context) {
                map.put(DATA, merchantPermissionService.deleteMerchantPermission(req));
            }
        });
    }

}
