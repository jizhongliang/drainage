package com.py.app.entrance.service.impl;

import com.py.app.entrance.bo.InsertRecordRequestBo;
import com.py.app.entrance.mysql.entities.CLEntranceAccessRecord;
import com.py.app.entrance.mysql.entities.CLEntranceMerchantSummary;
import com.py.app.entrance.mysql.entities.CLEntranceMerchants;
import com.py.app.entrance.mysql.mapper.CLEntranceMerchantSummaryMapper;
import com.py.app.entrance.service.EntranceAccessRecordService;
import com.py.app.entrance.service.EntranceMerchantSummaryService;
import com.py.common.utils.ParamUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by jzl on 17/12/22.
 */
@Service
public class EntranceMerchantSummaryServiceImpl implements EntranceMerchantSummaryService {
    private static Logger logger = LoggerFactory.getLogger(EntranceMerchantSummaryServiceImpl.class);
    @Autowired
    private CLEntranceMerchantSummaryMapper summaryMapper;
    @Autowired
    private EntranceAccessRecordService recordService;


    /**
     * 记录调用
     * @param merchantCode
     * @param sourceFrom
     */
    @Override
    public void recordAccess(String merchantCode, Integer sourceFrom, String methodName, String url) {

        InsertRecordRequestBo requestBo = fillRequestBo(merchantCode, sourceFrom, methodName, url);
        //1.往record表新增
        insertRecord(requestBo);

        //2.更新summary表  如果没有则新增记录
        //先查询，如果没有就插入新纪录，有就更新次数
        CLEntranceMerchantSummary summary = findSummaryByRequestBo(requestBo);
        if (ParamUtil.isEmpty(summary)) {
            //新增
            insertSummary(requestBo);
            logger.info("新增summary");
        }else {
            //修改
            updateSummary(summary);
            logger.info("更新summary");
        }
    }



    /****************************************************************************/

    /**
     * 新增汇总记录
     * @param requestBo
     */
    private void insertSummary(InsertRecordRequestBo requestBo) {
        CLEntranceMerchantSummary summary = new CLEntranceMerchantSummary();
        summary.setMerchantCode(requestBo.getMerchantCode());
        summary.setSourceFrom(requestBo.getSourceFrom());
        summary.setAccessMethod(requestBo.getMethodName());
        summary.setTotalCounts(1);
        summary.setCreateTime(new Date());
        summary.setUpdateTime(new Date());

        summaryMapper.insertSelective(summary);
    }

    /**
     * 查询有没有商户汇总记录
     * @param requestBo
     * @return
     */
    private CLEntranceMerchantSummary findSummaryByRequestBo(InsertRecordRequestBo requestBo) {
        CLEntranceMerchantSummary summary = summaryMapper.findSummaryByRequestBo(requestBo);
        return summary;
    }

    /**
     * 填充
     * @param merchantCode
     * @param sourceFrom
     * @param methodName
     * @param url
     * @return
     */
    private InsertRecordRequestBo fillRequestBo(String merchantCode, Integer sourceFrom, String methodName, String url) {
        InsertRecordRequestBo requestBo = new InsertRecordRequestBo();
        requestBo.setMerchantCode(merchantCode);
        requestBo.setSourceFrom(sourceFrom);
        requestBo.setMethodName(methodName);
        requestBo.setUrl(url);

        return requestBo;
    }

    /**
     * 更新汇总表
     * @param summary
     */
    private void updateSummary(CLEntranceMerchantSummary summary) {
        summary.setUpdateTime(new Date());
        summary.setTotalCounts(summary.getTotalCounts() + 1);
        summaryMapper.updateByPrimaryKeySelective(summary);
    }

    /**
     * 插入记录
     * @param requestBo
     */
    private void insertRecord(InsertRecordRequestBo requestBo) {
        CLEntranceAccessRecord record = new CLEntranceAccessRecord();
        record.setMerchantCode(requestBo.getMerchantCode());
        record.setSourceFrom(requestBo.getSourceFrom());
        record.setAccessMethod(requestBo.getMethodName());
        record.setForwardUrl(requestBo.getUrl());
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());

        recordService.insertRecord(record);
    }
}
