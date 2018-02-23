package com.py.app.borrow.service.impl;

import java.util.Date;

import com.py.app.borrow.bo.MerchantSummaryRequestBo;
import com.py.app.borrow.mysql.entities.CLInterfaceMerchantSummary;
import com.py.app.borrow.mysql.mapper.CLInterfaceMerchantSummaryMapper;
import com.py.app.borrow.service.InterfaceAccessRecordService;
import com.py.app.borrow.service.InterfaceMerchantSummaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.py.common.utils.ParamUtil;

/**
 * Created by jzl on 17/12/14.
 */
@Service
public class InterfaceMerchantSummaryServiceImpl implements InterfaceMerchantSummaryService {
    private static Logger logger = LoggerFactory.getLogger(InterfaceMerchantSummaryServiceImpl.class);
    @Autowired
    private CLInterfaceMerchantSummaryMapper interfaceMerchantSummaryMapper;
    @Autowired
    private InterfaceAccessRecordService recordService;


    /**
     * 记录这次调用
     * @param merchantCode
     * @param method
     * @param type
     */
    @Override
    public void recordThisAccess(String merchantCode, String method, int type) {
        //1.插入记录
        recordService.insertRecord(merchantCode, method, type);
        //2.修改并增加次数
        //先查询，如果没有就插入新纪录，有就更新次数
        MerchantSummaryRequestBo requestBo = fillSummaryRequestBo(merchantCode, type);
        CLInterfaceMerchantSummary summary = interfaceMerchantSummaryMapper.findOneByMerchantAndType(requestBo);
        if (!ParamUtil.isEmpty(summary)) {
            //update
            updateSummary(summary);
            logger.info("修改summary");
        }else {
            //insert
            insertSummary(merchantCode, method, type);
            logger.info("新增summary");
        }
    }



    /******************************* 私有方法 ***********************************************/
    /**
     * 修改记录
     * @param summary
     */
    private void updateSummary(CLInterfaceMerchantSummary summary) {
        summary.setUpdateTime(new Date());
        summary.setTotalCounts(summary.getTotalCounts() + 1);
        interfaceMerchantSummaryMapper.updateByPrimaryKeySelective(summary);
    }

    /**
     * 插入记录
     * @param merchantCode
     * @param method
     * @param type
     */
    private void insertSummary(String merchantCode, String method, int type) {
        CLInterfaceMerchantSummary summary = new CLInterfaceMerchantSummary();
        summary.setMerchantCode(merchantCode);
        summary.setInterfaceType(type);
        summary.setTotalCounts(1);
        summary.setCreateTime(new Date());
        summary.setUpdateTime(new Date());
        interfaceMerchantSummaryMapper.insertSelective(summary);
    }

    /**
     * 填充
     * @param merchantCode
     * @param type
     * @return
     */
    private MerchantSummaryRequestBo fillSummaryRequestBo(String merchantCode, int type) {
        MerchantSummaryRequestBo requestBo = new MerchantSummaryRequestBo();
        requestBo.setMerchantCode(merchantCode);
        requestBo.setType(type);
        return requestBo;
    }
}
