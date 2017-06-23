package com.dlfc.services.house.convertor;


import com.dlfc.services.house.convertor.base.AbstractConvertor;
import com.dlfc.services.house.dto.SysDescriptionDTO;
import com.dlfc.zfw.wechat.entities.entity.SysDescriptions;
import org.springframework.stereotype.Component;

@Component
public class SysDescriptionConvertor extends AbstractConvertor<SysDescriptions, SysDescriptionDTO> {

    @Override
    public SysDescriptions toModel(SysDescriptionDTO sysDescriptionDTO) {
        SysDescriptions sysDescriptions = new SysDescriptions();
        sysDescriptions.setLid(sysDescriptionDTO.getLid());
        sysDescriptions.setDescription1(sysDescriptionDTO.getLiveRequire());
        sysDescriptions.setDescription2(sysDescriptionDTO.getOwnerBears());
        sysDescriptions.setDescription3(sysDescriptionDTO.getOthers());
        return sysDescriptions;
    }

    @Override
    public SysDescriptionDTO toDTO(SysDescriptions sysDescriptions, Object... objects) {
        SysDescriptionDTO sysDescriptionDTO = new SysDescriptionDTO();
        sysDescriptionDTO.setLid(sysDescriptions.getLid());
        sysDescriptionDTO.setLiveRequire(sysDescriptions.getDescription1());
        sysDescriptionDTO.setOwnerBears(sysDescriptions.getDescription2());
        sysDescriptionDTO.setOthers(sysDescriptions.getDescription3());

        return sysDescriptionDTO;
    }
}
