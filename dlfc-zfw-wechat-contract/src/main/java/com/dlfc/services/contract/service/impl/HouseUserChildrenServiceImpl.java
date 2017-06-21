package com.dlfc.services.contract.service.impl;

import entity.ConHouseUserChildren;
import com.dlfc.services.contract.repository.ContractRService;
import com.dlfc.services.contract.service.HouseUserChildrenService;
import entity.UsrUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by K on 6/20/17.
 */

@Service
public class HouseUserChildrenServiceImpl implements HouseUserChildrenService {

    @Autowired
    private ContractRService contractRService;

    @Override
    public void save(ConHouseUserChildren conHouseUserChildren,
                     UsrUser user) {
        conHouseUserChildren.preInsert(user);
        contractRService.saveConHouseUserChildren(conHouseUserChildren);
    }
}
