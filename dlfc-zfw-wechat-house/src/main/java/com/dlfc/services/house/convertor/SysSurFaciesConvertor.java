package com.dlfc.services.house.convertor;

import com.dlfc.services.house.convertor.base.AbstractConvertor;
import com.dlfc.services.house.dto.SysSurFaciesDTO;
import com.dlfc.zfw.wechat.entities.entity.SysCode;
import com.dlfc.zfw.wechat.entities.entity.SysSurFacis;
import org.springframework.stereotype.Component;


@Component
public class SysSurFaciesConvertor extends AbstractConvertor<SysCode, SysSurFaciesDTO> {
    @Override
    public SysCode toModel(SysSurFaciesDTO sysSurFaciesDTO) {
        SysCode sysSurFacis = new SysCode();
        sysSurFacis.setName(sysSurFaciesDTO.getName());
        if (sysSurFaciesDTO.getCode() != null) {
            sysSurFacis.setCode(sysSurFaciesDTO.getCode());
        }
        return sysSurFacis;
    }

    @Override
    public SysSurFaciesDTO toDTO(SysCode sysCode, Object... objects) {
        SysSurFaciesDTO sysSurFaciesDTO = new SysSurFaciesDTO();
        sysSurFaciesDTO.setId(sysCode.getId());
        sysSurFaciesDTO.setCode(sysCode.getCode());
        sysSurFaciesDTO.setName(sysCode.getName());

        return sysSurFaciesDTO;
    }
}
