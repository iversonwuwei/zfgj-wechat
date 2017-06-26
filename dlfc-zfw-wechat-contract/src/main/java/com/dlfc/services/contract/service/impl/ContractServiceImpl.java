package com.dlfc.services.contract.service.impl;

import com.dlfc.services.contract.enums.ConStatusEnum;
import com.dlfc.services.contract.repository.ContractRService;
import com.dlfc.services.contract.service.ContractService;
import com.dlfc.zfw.wechat.entities.entity.ConContract;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by K on 6/19/17.
 */

@Service
public class ContractServiceImpl implements ContractService {

    private ConContract entity;

    @Autowired
    private ContractRService contractRService;

    @Override
    public String save(ConContract conContract,
                       UsrUser user) {
        conContract.preInsert(user);
        return contractRService.saveContract(conContract);
    }

    @Override
    public String updateById(ConContract conContract,
                             UsrUser user) {
        if (StringUtils.isNotEmpty(conContract.getId())) {
            return contractRService.updateConContractById(conContract);
        }
        return null;
    }

    @Override
    public String updateSignStatus(String id,
                                   int status,
                                   UsrUser user) {
        if (StringUtils.isNotEmpty(id)
                && null != user) {
            entity = contractRService.findConContractById(id);
            if (null != entity) {
                if (ConStatusEnum.WAIT_UPLOAD_ENUM.getValue() == entity.getStatus()) {
                    entity.setStatus((short) status);
                } else {
                    entity.setStatus((short) ConStatusEnum.ACTIVE_ENUM.getValue());
                }
                return updateById(entity, user);
            }
        }
        return null;
    }
}
