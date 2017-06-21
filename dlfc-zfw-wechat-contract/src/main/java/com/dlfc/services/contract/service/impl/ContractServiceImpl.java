package com.dlfc.services.contract.service.impl;

import entity.ConContract;
import com.dlfc.services.contract.repository.ContractRService;
import com.dlfc.services.contract.service.ContractService;
import entity.UsrUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by K on 6/19/17.
 */

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRService contractRService;

    @Override
    public String save(ConContract conContract,
                       UsrUser user) {
        conContract.preInsert(user);
        return contractRService.saveContract(conContract);
    }
}
