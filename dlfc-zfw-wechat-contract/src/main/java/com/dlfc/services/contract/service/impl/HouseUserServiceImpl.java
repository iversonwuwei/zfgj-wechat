package com.dlfc.services.contract.service.impl;

import com.dlfc.services.contract.repository.ContractRService;
import com.dlfc.services.contract.service.HouseUserService;
import com.dlfc.zfw.wechat.entities.entity.ConHouseUser;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<ConHouseUser> findByLid(String lid) {
        return contractRService.findConHouseUserByLid(lid);
    }
}
