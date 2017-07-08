package com.dlfc.services.contract.service.impl;

import com.dlfc.services.contract.enums.ConSourceEnum;
import com.dlfc.services.contract.enums.ConStatusEnum;
import com.dlfc.services.contract.repository.ContractRService;
import com.dlfc.services.contract.service.ContractService;
import com.dlfc.zfw.wechat.entities.entity.ConContract;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by K on 6/19/17.
 */

@Service
@Transactional
public class ContractServiceImpl implements ContractService {

    private ConContract entity;
    private List<ConContract> entityList;

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
    public List<ConContract> findFinishByParams(String pid) {
        Short[] statuses = {
                (short) ConStatusEnum.EXPIRE_ENUM.getValue(),
                (short) ConStatusEnum.LESSOR_REJECT_ENUM.getValue(),
                (short) ConStatusEnum.LESSEE_REJECT_ENUM.getValue(),
                (short) ConStatusEnum.FINISH_ENUM.getValue()

        };
        Integer[] sources = {
                ConSourceEnum.APP_ENUM.getValue(),
                ConSourceEnum.WEBSITE_ENUM.getValue(),
                ConSourceEnum.WECHAT_ENUM.getValue()
        };
        entityList = contractRService.findConContractByPid(pid," MODIFY_TIME DESC ");
        List<ConContract> conContracts = new ArrayList<>();
        if (null != entityList && entityList.size() > 0) {
            for (ConContract conContract : entityList) {
                if (ConStatusEnum.ACTIVE_ENUM.getValue() == conContract.getStatus()) {
                    conContracts.add(conContract);
                } else if (Arrays.asList(statuses).contains(conContract.getStatus())
                        && Arrays.asList(sources).contains(conContract.getSource())) {
                    conContracts.add(conContract);
                }
            }
        }
        return conContracts;
    }

    @Override
    public List<ConContract> findPendingByParams(String pid) {
        Short[] statuses = {
                (short) ConStatusEnum.LESSEE_WAIT_CONFIRM_ENUM.getValue(),
                (short) ConStatusEnum.LESSOR_WAIT_CONFIRM_ENUM.getValue(),
                (short) ConStatusEnum.CREATING_ENUM.getValue()
        };
        Integer[] sources = {
                ConSourceEnum.APP_ENUM.getValue(),
                ConSourceEnum.WEBSITE_ENUM.getValue(),
                ConSourceEnum.WECHAT_ENUM.getValue()
        };
        entityList = contractRService.findConContractByPid(pid," MODIFY_TIME DESC ");
        List<ConContract> conContracts = new ArrayList<>();
        if (null != entityList && entityList.size() > 0) {
            for (ConContract conContract : entityList) {
                if (Arrays.asList(statuses).contains(conContract.getStatus())
                        && Arrays.asList(sources).contains(conContract.getSource())) {
                    conContracts.add(conContract);
                }
            }
        }
        return conContracts;
    }

}
