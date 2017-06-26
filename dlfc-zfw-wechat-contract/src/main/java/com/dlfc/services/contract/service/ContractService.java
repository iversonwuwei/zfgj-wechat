package com.dlfc.services.contract.service;

import com.dlfc.zfw.wechat.entities.entity.ConContract;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;

/**
 * Created by K on 6/19/17.
 */
public interface ContractService {
    String save(ConContract conContract, UsrUser user);

    String updateById(ConContract conContract, UsrUser user);

    String updateSignStatus(String id, int status, UsrUser user);
}
