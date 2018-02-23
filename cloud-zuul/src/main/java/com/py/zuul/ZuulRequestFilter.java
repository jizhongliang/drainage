/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.zuul;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.py.common.exception.ParamterException;
import com.py.common.protocol.Response;
import com.py.common.utils.Code;
import com.py.zuul.base.entity.ValidateMerchantRequest;
import com.py.zuul.base.util.IPUtil;
import com.py.zuul.service.MerchantService;

/**
 * 
 * @author jinlilong
 * @version $Id: ZuulRequestFilter.java, v 0.1 2017年12月15日 下午5:51:01 jinlilong Exp $
 */
@Component
public class ZuulRequestFilter extends ZuulFilter {

    /**  */
    @Autowired
    private MerchantService merchantService;

    /**  */
    private static Logger   logger = LoggerFactory.getLogger(ZuulRequestFilter.class);

    /** 
     * @see com.netflix.zuul.IZuulFilter#run()
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        try {
            HttpServletResponse response = ctx.getResponse();
            response.setCharacterEncoding("UTF-8");
            HttpServletRequest request = ctx.getRequest();
            ValidateMerchantRequest req = new ValidateMerchantRequest();
            req.setUrl(request.getRequestURI());
            req.setIp(IPUtil.getIpAddress(request));
            req.setMerchantCode(request.getParameter("merchantCode"));
            boolean state = merchantService.queryMerchantPermission(req);
            if (state) {
                ctx.setSendZuulResponse(true);
                ctx.setResponseStatusCode(200);
                ctx.set("isSuccess", true);
            } else {
                logger.error("您无权限访问此地址,商户号=>", req.getMerchantCode());
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(401);
                ctx.set("isSuccess", false);
                ctx.setResponseBody(JSONObject.toJSONString(Response.failedDataResponse(null,
                    Code.codeData.REQUESTFAILED.code, "您无权限访问此地址")));
            }
        } catch (ParamterException e) {
            logger.error("商户权限查询异常", e);
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.set("isSuccess", false);
            ctx.setResponseBody(JSONObject.toJSONString(Response.failedDataResponse(null,
                Code.codeData.REQUESTFAILED.code, e.getMessage())));
        } catch (Exception e) {
            logger.error("商户权限查询异常", e);
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.set("isSuccess", false);
            ctx.setResponseBody(JSONObject.toJSONString(
                Response.failedDataResponse(null, Code.codeData.REQUESTFAILED.code, "系统异常")));

        }

        return null;
    }

    /** 
     * @see com.netflix.zuul.IZuulFilter#shouldFilter()
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /** 
     * @see com.netflix.zuul.ZuulFilter#filterOrder()
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /** 
     * @see com.netflix.zuul.ZuulFilter#filterType()
     */
    @Override
    public String filterType() {
        return "pre";
    }

}
