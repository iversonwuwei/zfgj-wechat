package com.dlfc.services.contract.service.impl;

import com.dlfc.services.contract.repository.ContractRService;
import com.dlfc.services.contract.service.OtherCostService;
import com.dlfc.zfw.wechat.entities.entity.ConOtherCosts;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by K on 6/26/17.
 */

@Service
public class OtherCostServiceImpl implements OtherCostService {

    @Autowired
    private ContractRService contractRService;

    @Override
    public String save(ConOtherCosts conOtherCosts,
                       UsrUser user) {
        if (null != conOtherCosts && null != user) {
            conOtherCosts.preInsert(user);
            return contractRService.saveConOtherCosts(conOtherCosts);
        }
        return null;
    }

    @Override
    public List<ConOtherCosts> findByLid(String lid) {
        if (StringUtils.isNotEmpty(lid)) {
            return contractRService.findConOtherCostsByLid(lid);
        }
        return null;
    }
}
