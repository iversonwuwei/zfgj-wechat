package com.dlfc.services.contract.convertor;

import com.dlfc.admin.common.utils.DateUtils;
import com.dlfc.services.contract.dto.ContractListDTO;
import com.dlfc.services.contract.enums.ConStatusEnum;
import com.dlfc.zfw.wechat.entities.entity.ConContract;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by wangna on 2017/6/26.
 */
@Component
public class ContractListConvertor extends AbstractConvertor<ConContract, ContractListDTO> {
    @Override
    public ConContract toModel(ContractListDTO contractListDTO) {
        return null;
    }

    @Override
    public ContractListDTO toDTO(ConContract model, Object... objects) {
        ContractListDTO dto = new ContractListDTO();
        if (null != model) {
            dto.setId(model.getId());
            dto.setContractNo(model.getNo());
            //发起人
            dto.setInitiator(model.getLesseeName());
            //受邀人
            dto.setInvitedPerson(model.getLessorName());
            dto.setStatus(String.valueOf(model.getStatus()));
            if (null != model.getModifyTime()) {
                dto.setDate(new Date(model.getModifyTime()));
                dto.setDateStr(DateUtils.dateToStr(new Date(model.getModifyTime()), "yyyy-MM-dd HH:mm:ss"));
            }
            if (ConStatusEnum.CREATING_ENUM.getValue() == model.getStatus()) {
                dto.setIsDelete(true);
            } else {
                dto.setIsDelete(false);
            }
            if (ConStatusEnum.CREATING_ENUM.getValue() == model.getStatus() ||
                    ConStatusEnum.LESSEE_REJECT_ENUM.getValue() == model.getStatus() ||
                    ConStatusEnum.LESSEE_REJECT_ENUM.getValue() == model.getStatus()){
                dto.setIsEdit(true);
            }else {
                dto.setIsEdit(false);
            }
        }
        return dto;
    }
}
