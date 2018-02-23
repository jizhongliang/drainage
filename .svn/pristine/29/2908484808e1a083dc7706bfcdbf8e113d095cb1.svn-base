/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.py.common.service.entity.merchant.urls.PermissionUrlContants;
import com.py.common.utils.ValidateUtil;
import com.py.merchant.base.BaseBizErrorEnums;
import com.py.merchant.base.BaseBizException;
import com.py.merchant.base.BaseController;
import com.py.merchant.base.UserContext;
import com.py.merchant.base.request.permission.PermissionInsertRequest;
import com.py.merchant.base.request.permission.PermissionQueryRequest;
import com.py.merchant.base.request.permission.PermissionUpdateRequest;
import com.py.merchant.service.PermissionService;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author jinlilong
 * @version $Id: PermissionController.java, v 0.1 2017年12月14日 上午11:00:27 jinlilong Exp $
 */
@RestController
public class PermissionController extends BaseController {

    /**  */
    @Autowired
    private PermissionService permissionService;

    /**
     * 
     * @param request
     * @param map
     * @param id
     * @return
     */
    @RequestMapping(value = PermissionUrlContants.QUERY_PERMISSION_BY_ID, method = RequestMethod.GET)
    @ApiOperation(value = "根据ID查询权限")
    public String queryById(ModelMap map, final long id) {

        return this.httpExecute(map, new ControllerCallback() {

            public void check(ModelMap map, UserContext context) {
                if (id <= 0) {
                    throw new BaseBizException(BaseBizErrorEnums.PARAM_IS_ILLEGAL, "id不能为空");
                }
            }

            public void execute(ModelMap map, UserContext context) {
                map.put(DATA, permissionService.queryById(id));
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
    @RequestMapping(value = PermissionUrlContants.INSERT_PERMISSION, method = RequestMethod.POST)
    @ApiOperation(value = "插入权限")
    public String insertPermission(ModelMap map, PermissionInsertRequest req) {

        return this.httpExecute(map, new ControllerCallback() {

            public void check(ModelMap map, UserContext context) {
                req.setCreator(context.getName());
                ValidateUtil.validate(req);
            }

            public void execute(ModelMap map, UserContext context) {
                map.put(DATA, permissionService.insertPermission(req));
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
    @RequestMapping(value = PermissionUrlContants.UPDATE_PERMISSION, method = RequestMethod.POST)
    @ApiOperation(value = "更新权限")
    public String updatePermission(ModelMap map, PermissionUpdateRequest req) {

        return this.httpExecute(map, new ControllerCallback() {

            public void check(ModelMap map, UserContext context) {
                req.setCreator(context.getName());
                ValidateUtil.validate(req);
            }

            public void execute(ModelMap map, UserContext context) {
                map.put(DATA, permissionService.updatePermission(req));
            }
        });
    }

    /**
     * 
     * @param request
     * @param map
     * @param id
     * @return
     */
    @RequestMapping(value = PermissionUrlContants.DELETE_PERMISSION, method = RequestMethod.GET)
    @ApiOperation(value = "删除权限")
    public String deletePermission(ModelMap map, long id) {

        return this.httpExecute(map, new ControllerCallback() {

            public void check(ModelMap map, UserContext context) {
                if (id <= 0) {
                    throw new BaseBizException(BaseBizErrorEnums.PARAM_IS_ILLEGAL, "id不能为空");
                }
            }

            public void execute(ModelMap map, UserContext context) {
                map.put(DATA, permissionService.deletePermission(id));
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
    @RequestMapping(value = PermissionUrlContants.QUERY_PAGE_PERMISSION, method = RequestMethod.GET)
    @ApiOperation(value = "分页查询")
    public String queryPagePermission(ModelMap map, PermissionQueryRequest req) {

        return this.httpExecute(map, new ControllerCallback() {

            public void execute(ModelMap map, UserContext context) {
                map.put(DATA, permissionService.queryPagePermission(req));
                map.put(TOTAL, permissionService.queryPagePermissionCount(req));
            }
        });
    }

    /**
     * 
     * @param map
     * @param req
     * @return
     */
    @RequestMapping(value = PermissionUrlContants.QUERY_ALL_SERVICE, method = RequestMethod.GET)
    @ApiOperation(value = "分页查询")
    public String queryAllService(ModelMap map, PermissionQueryRequest req) {

        return this.httpExecute(map, new ControllerCallback() {

            public void execute(ModelMap map, UserContext context) {
                map.put(DATA, permissionService.queryAllService());
            }
        });
    }

}
