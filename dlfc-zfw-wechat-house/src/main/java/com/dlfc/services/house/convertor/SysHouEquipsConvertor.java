package com.dlfc.services.house.convertor;

import com.dlfc.services.house.convertor.base.AbstractConvertor;
import com.dlfc.services.house.dto.SysHouEquipsDTO;
import com.dlfc.zfw.wechat.entities.entity.SysCode;
import org.springframework.stereotype.Component;


@Component
public class SysHouEquipsConvertor extends AbstractConvertor<SysCode, SysHouEquipsDTO> {
    @Override
    public SysCode toModel(SysHouEquipsDTO sysHouEquipsDTO) {
        SysCode sysHouEquips = new SysCode();
        sysHouEquips.setCode(sysHouEquipsDTO.getCode());
        sysHouEquips.setCode(sysHouEquipsDTO.getName());

        return sysHouEquips;
    }

    @Override
    public SysHouEquipsDTO toDTO(SysCode sysCode, Object... objects) {
        SysHouEquipsDTO sysHouEquipsDTO = new SysHouEquipsDTO();
        sysHouEquipsDTO.setId(sysCode.getId());
        sysHouEquipsDTO.setCode(sysCode.getCode());
        sysHouEquipsDTO.setName(sysCode.getName());

        return sysHouEquipsDTO;
    }
}
