package com.dlfc.services.house.convertor;

import com.dlfc.services.house.convertor.base.AbstractConvertor;
import com.dlfc.services.house.dto.SysHouEquipsDTO;
import com.dlfc.services.house.entity.SysHouEquips;
import org.springframework.stereotype.Component;


@Component
public class SysHouEquipsConvertor extends AbstractConvertor<SysHouEquips, SysHouEquipsDTO> {
    @Override
    public SysHouEquips toModel(SysHouEquipsDTO sysHouEquipsDTO) {
        SysHouEquips sysHouEquips = new SysHouEquips();
        sysHouEquips.setEquipmentCode(sysHouEquipsDTO.getCode());
        sysHouEquips.setEquipmentName(sysHouEquipsDTO.getName());
        sysHouEquips.setLid(sysHouEquipsDTO.getLid());

        return sysHouEquips;
    }

    @Override
    public SysHouEquipsDTO toDTO(SysHouEquips sysHouEquips, Object... objects) {
        SysHouEquipsDTO sysHouEquipsDTO = new SysHouEquipsDTO();
        sysHouEquipsDTO.setId(sysHouEquips.getId());
        sysHouEquipsDTO.setLid(sysHouEquips.getLid());
        sysHouEquipsDTO.setCode(sysHouEquips.getEquipmentCode());
        sysHouEquipsDTO.setName(sysHouEquips.getEquipmentName());

        return sysHouEquipsDTO;
    }
}
