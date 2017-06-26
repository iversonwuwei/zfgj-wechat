package com.dlfc.services.contract.service.impl;

import com.dlfc.services.contract.repository.ContractRService;
import com.dlfc.services.contract.service.HouseItemService;
import com.dlfc.zfw.wechat.entities.entity.ConHouseItems;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by K on 6/26/17.
 */

@Service
public class HouseItemServiceImpl implements HouseItemService {

    @Autowired
    private ContractRService contractRService;

    @Override
    public String save(ConHouseItems conHouseItems,
                       UsrUser user) {
        if (null != conHouseItems && null != user) {
            conHouseItems.preInsert(user);
            return contractRService.saveConHouseItems(conHouseItems);
        }
        return null;
    }

    @Override
    public List<ConHouseItems> findByLid(String lid) {
        if(StringUtils.isNotEmpty(lid)){
            return contractRService.findConHouseItemsByLid(lid);
        }
        return null;
    }
}
