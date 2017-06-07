package com.dlfc.services.house.convertor;


import com.dlfc.services.house.dto.SysDescriptionDTO;
import com.dlfc.services.house.entity.SysDescriptions;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Component;

@Component
public class SysDescriptionConvertor extends AbstractConvertor<SysDescriptions, SysDescriptionDTO> {
    @Override
    public SysDescriptions toModel(SysDescriptionDTO sysDescriptionDTO) {
        SysDescriptions sysDescriptions = new SysDescriptions();
        sysDescriptions.setDescription1(sysDescriptionDTO.getLiveRequire());
        sysDescriptions.setDescription2(sysDescriptionDTO.getDdd());
        sysDescriptions.setDescription3(sysDescriptionDTO.getOthers());
        sysDescriptions.setLid(sysDescriptionDTO.getLid());

        return sysDescriptions;
    }

    @Override
    public SysDescriptionDTO toDTO(SysDescriptions sysDescriptions, Object... objects) {
        SysDescriptionDTO sysDescriptionDTO = new SysDescriptionDTO();
        sysDescriptionDTO.setId(sysDescriptions.getId());
        sysDescriptionDTO.setLid(sysDescriptions.getLid());
        sysDescriptionDTO.setLiveRequire(sysDescriptions.getDescription1());
        sysDescriptionDTO.setDdd(sysDescriptions.getDescription2());
        sysDescriptionDTO.setOthers(sysDescriptions.getDescription3());

        return sysDescriptionDTO;
    }
}
