package com.dlfc.services.contract.service.impl;

import com.dlfc.services.contract.dto.ConditionDTO;
import com.dlfc.services.contract.enums.ConSourceEnum;
import com.dlfc.services.contract.enums.ConStatusEnum;
import com.dlfc.services.contract.repository.ContractRService;
import com.dlfc.services.contract.service.ContractService;
import com.dlfc.zfw.wechat.entities.entity.ConContract;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
                if (ConStatusEnum.CREATING_ENUM.getValue() == entity.getStatus()) {
                    entity.setStatus((short) status);
                } else if (status != entity.getStatus()) {
                    entity.setStatus((short) ConStatusEnum.ACTIVE_ENUM.getValue());
                }
                return updateById(entity, user);
            }
        }
        return null;
    }

    @Override
    public String deleteById(String id, UsrUser user) {
        ConContract conContract = contractRService.findConContractById(id);
        if (null != conContract &&
                conContract.getStatus() == ConStatusEnum.CREATING_ENUM.getValue()) {
            return contractRService.removeById(id);
        }
        return null;
    }

    @Override
    public List<ConContract> findFinishByParams(String pid ) {
        Short[] conStatus = {
                (short) ConStatusEnum.ACTIVE_ENUM.getValue(),
                (short) ConStatusEnum.EXPIRE_ENUM.getValue(),
                (short) ConStatusEnum.LESSOR_REJECT_ENUM.getValue(),
                (short) ConStatusEnum.LESSEE_REJECT_ENUM.getValue(),
                (short) ConStatusEnum.FINISH_ENUM.getValue()

        };
        Integer[] sources = {
                ConSourceEnum.APP_ENUM.getValue(),
                ConSourceEnum.WEBSITE_ENUM.getValue(),
                ConSourceEnum.ZFGJ_APP_ENUM.getValue(),
                ConSourceEnum.ZFGJ_ENUM.getValue(),
                ConSourceEnum.WECHAT_ENUM.getValue()
        };
        ConditionDTO dto = new ConditionDTO();
        dto.setPid(pid);
        dto.setSourceIn(sources);
        dto.setStatusIn(conStatus);
        List<ConContract> conContracts = contractRService.findByParams(dto);
        return conContracts;
    }

    @Override
    public List<ConContract> findPendingByParams( String pid) {
        Short[] conStatus = {
                (short) ConStatusEnum.LESSEE_WAIT_CONFIRM_ENUM.getValue(),
                (short) ConStatusEnum.LESSOR_WAIT_CONFIRM_ENUM.getValue(),
                (short) ConStatusEnum.CREATING_ENUM.getValue()
        };
        Integer[] sources = {
                ConSourceEnum.APP_ENUM.getValue(),
                ConSourceEnum.WEBSITE_ENUM.getValue(),
                ConSourceEnum.WECHAT_ENUM.getValue()
        };
        ConditionDTO dto = new ConditionDTO();
        dto.setPid(pid);
        dto.setSourceIn(sources);
        dto.setStatusIn(conStatus);
        List<ConContract> conContracts = contractRService.findByParams(dto);
        return conContracts;
    }

}
