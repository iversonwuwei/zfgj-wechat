package com.dlfc.services.contract.service;

import entity.ConContract;
import entity.UsrUser;

/**
 * Created by K on 6/19/17.
 */
public interface ContractService {
    String save(ConContract conContract, UsrUser user);
}
