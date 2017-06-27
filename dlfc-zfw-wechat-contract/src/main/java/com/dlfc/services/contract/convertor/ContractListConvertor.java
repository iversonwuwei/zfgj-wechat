package com.dlfc.services.contract.convertor;

import com.dlfc.admin.common.utils.DateUtils;
import com.dlfc.services.contract.dto.ContractListDTO;
import com.dlfc.zfw.wechat.entities.entity.ConContract;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by wangna on 2017/6/26.
 */
@Component
public class ContractListConvertor extends AbstractConvertor<ConContract,ContractListDTO> {
    @Override
    public ConContract toModel(ContractListDTO contractListDTO) {
        return null;
    }

    @Override
    public ContractListDTO toDTO(ConContract model, Object... objects) {
        ContractListDTO dto = new ContractListDTO();
        if ( null != model){
            dto.setId(model.getId());
            dto.setContractNo(model.getNo());
            //发起人
            dto.setInitiator(model.getLesseeName());
            //受邀人
            dto.setInvitedPerson(model.getLessorName());
            dto.setStatus(String.valueOf(model.getStatus()));
            dto.setDate(new Date(model.getStartTime()));
            dto.setDateStr(DateUtils.dateToStr(new Date(model.getStartTime()),"yyyy-MM-dd hh:mm:ss"));
        }
        return dto;
    }
}
