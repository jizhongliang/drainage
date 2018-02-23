package com.py.app.borrow.service;

import com.py.app.borrow.vo.MerchantInfoVo;
import com.py.app.borrow.vo.dto.ParsingMerchantInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.py.common.utils.GsonUtil;
import com.py.common.utils.ParamUtil;

/**商户服务接口
 * Created by jzl on 17/12/13.
 */
@Service
public class MerchantService {

    @Autowired
    RestTemplate restTemplate;

    public MerchantInfoVo getMerchantInfo(String merchantCode) {
        String res =  restTemplate.getForObject("http://service-merchant/queryMerchantByCode?code=" + merchantCode, String.class);
        if (ParamUtil.isEmpty(res)) {
            return null;
        }
        return GsonUtil.GsonToBean(res, ParsingMerchantInfoResponse.class).getData();
    }
}
