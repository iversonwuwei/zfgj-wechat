package com.dlfc.services.house.convertor;

import com.dlfc.services.house.convertor.base.AbstractConvertor;
import com.dlfc.services.house.dto.SysSurFaciesDTO;
import com.dlfc.services.house.entity.SysSurFacis;
import org.springframework.stereotype.Component;


@Component
public class SysSurFaciesConvertor extends AbstractConvertor<SysSurFacis, SysSurFaciesDTO> {
    @Override
    public SysSurFacis toModel(SysSurFaciesDTO sysSurFaciesDTO) {
        SysSurFacis sysSurFacis = new SysSurFacis();
        sysSurFacis.setLid(sysSurFaciesDTO.getLid());
        sysSurFacis.setFacilityName(sysSurFaciesDTO.getName());
        if (sysSurFaciesDTO.getCode() != null) {
            sysSurFacis.setFacilityCode(sysSurFaciesDTO.getCode());
        }
        if (sysSurFaciesDTO.getOthers() != null){
            sysSurFacis.setOthers(sysSurFaciesDTO.getOthers());
        }

        return sysSurFacis;
    }

    @Override
    public SysSurFaciesDTO toDTO(SysSurFacis sysSurFacis, Object... objects) {
        SysSurFaciesDTO sysSurFaciesDTO = new SysSurFaciesDTO();
        sysSurFaciesDTO.setId(sysSurFacis.getId());
        sysSurFaciesDTO.setLid(sysSurFacis.getLid());
        sysSurFaciesDTO.setCode(sysSurFacis.getFacilityCode());
        sysSurFaciesDTO.setName(sysSurFacis.getFacilityName());
        if (sysSurFacis.getOthers() != null){
            sysSurFaciesDTO.setOthers(sysSurFacis.getOthers());
        }

        return sysSurFaciesDTO;
    }
}
