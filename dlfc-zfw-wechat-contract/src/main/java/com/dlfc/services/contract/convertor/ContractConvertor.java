package com.dlfc.services.contract.convertor;

import com.dlfc.services.contract.dto.ContractDTO;
import com.dlfc.services.contract.enums.ConSourceEnum;
import com.dlfc.services.contract.enums.ConStatusEnum;
import entity.ConContract;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by K on 6/19/17.
 */

@Component
public class ContractConvertor extends AbstractConvertor<ConContract, ContractDTO> {
    @Override
    public ConContract toModel(ContractDTO dto) {
        ConContract model = new ConContract();
        if (null != dto) {
            model.setId(dto.getId());
            // 房主
            model.setLessorName(dto.getOwnerName());
            model.setLessorIdNo(dto.getOwnerIdNo());
            model.setLessorMobile(dto.getOwnerPhone());
            model.setLessorEmail(dto.getOwnerEmail());
            model.setLessorAddress(dto.getOwnerDeliverAddress());
            model.setLessorBackupName(dto.getOwnerBackupName());
            model.setLessorBackupTel(dto.getOwnerBackupPhone());
            // 房客
            model.setLesseeName(dto.getRenterName());
            model.setLesseeIdNo(dto.getRenterIdNo());
            model.setLesseeMobile(dto.getRenterPhone());
            model.setLesseeEmail(dto.getRenterEmail());
            model.setLesseeAddress(dto.getRenterDeliverAddress());
            model.setLesseeBackupName(dto.getRenterBackupName());
            model.setLesseeBackupTel(dto.getRenterBackupPhone());
            model.setLesseeHouRegProvince(dto.getRenterRegProvince());
            model.setLesseeHouRegCity(dto.getRenterRegCity());
            // 房源
            model.setHouseAddr(dto.getHouseAddress());
            if (null != dto.getHouseArea()) {
                model.setBuildingArea(BigDecimal.valueOf(dto.getHouseArea()));
            }
            model.setPropertyIdNo(dto.getPropertyIdNo());
            if (StringUtils.isNotEmpty(dto.getPropertyType())) {
                model.setPropertyType(Integer.valueOf(dto.getPropertyType()));
            }
            if (StringUtils.isNotEmpty(dto.getHouseStructure())) {
                model.setHouseStructure(Integer.valueOf(dto.getHouseStructure()));
            }
            if (null != dto.getStartDate()) {
                model.setStartTime(dto.getStartDate().getTime());
            }
            if (null != dto.getEndDate()) {
                model.setEndTime(dto.getEndDate().getTime());
            }
            if (null != dto.getRentalMode()) {
                model.setRentalMode(dto.getRentalMode().shortValue());
            }
            if (null != dto.getRentalPurpose()) {
                model.setLeasePurpose(dto.getRentalPurpose().shortValue());
            }
            if (null != dto.getRentalDomain()) {
                model.setLeaseDomain(dto.getRentalDomain());
            } else {
                model.setLeaseDomain("整套");
            }
            if (null != dto.getRentalArea()) {
                model.setLeaseArea(BigDecimal.valueOf(dto.getRentalArea()));
            }
            model.setMonthlyRent(dto.getRent());
            model.setSettlementCycle(dto.getPaymentCycle());
            if (null != dto.getDeposit()) {
                model.setDepositAmt(BigDecimal.valueOf(dto.getDeposit()));
            }
            if (null != dto.getOwnerBears() && dto.getOwnerBears().length > 0) {
                StringBuffer buffer = new StringBuffer();
                for (String bear : dto.getOwnerBears()) {
                    if (StringUtils.isNotEmpty(bear)) {
                        buffer.append(bear);
                        buffer.append(",");
                    }
                }
                if (buffer.length() > 0) {
                    buffer.deleteCharAt(buffer.length() - 1);
                    model.setOwnerBear(buffer.toString());
                }
            }
            model.setOwnerBearOther(dto.getOwnerBearOthers());
            model.setAdditionalTerms(dto.getOthers());
            // 非页面业务
            model.setStatus((short) ConStatusEnum.WAIT_UPLOAD_ENUM.getValue());
            model.setSource(ConSourceEnum.WECHAT_ENUM.getValue());
        }
        return model;
    }

    @Override
    public ContractDTO toDTO(ConContract conContract, Object... objects) {
        return null;
    }
}
