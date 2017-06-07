package com.dlfc.services.house.convertor;


import com.dlfc.services.house.dto.HouseDTO;
import com.dlfc.services.house.entity.SysDescriptions;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Component;

@Component
public class SysDescriptionConvertor extends AbstractConvertor<SysDescriptions, HouseDTO> {
    @Override
    public SysDescriptions toModel(HouseDTO dto) {
        SysDescriptions sysDescriptions = new SysDescriptions();
        sysDescriptions.setDescription1(dto.getLiveRequirement());
        sysDescriptions.setDescription2(dto.getOwnerBears());
        sysDescriptions.setDescription3(dto.getOtherDcpt());
        sysDescriptions.setLid(dto.getId());
        return sysDescriptions;
    }

    @Override
    public HouseDTO toDTO(SysDescriptions sysDescriptions, Object... objects) {
        HouseDTO dto = new HouseDTO();
        dto.setId(sysDescriptions.getLid());
        dto.setLiveRequirement(sysDescriptions.getDescription1());
        dto.setOwnerBears(sysDescriptions.getDescription2());
        dto.setOtherDcpt(sysDescriptions.getDescription3());
        return dto;
    }
}
