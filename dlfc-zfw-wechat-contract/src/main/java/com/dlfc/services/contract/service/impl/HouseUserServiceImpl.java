package com.dlfc.services.contract.service.impl;

import entity.ConHouseUser;
import com.dlfc.services.contract.repository.ContractRService;
import entity.UsrUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dlfc.services.contract.service.HouseUserService;

/**
 * Created by K on 6/19/17.
 */

@Service
public class HouseUserServiceImpl implements HouseUserService {

    @Autowired
    private ContractRService contractRService;

    @Override
    public void save(ConHouseUser conHouseUser,
                     UsrUser user) {
        conHouseUser.preInsert(user);
        contractRService.saveConHouseUser(conHouseUser);
    }
}
