package com.dlfc.services.commons.convertor;

import com.dlfc.services.commons.dto.CodeNameDTO;
import com.dlfc.zfw.wechat.entities.entity.SysAreaCities;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Component;

/**
 * Created by K on 6/28/17.
 */

@Component
public class SysAreaCitiesConvertor extends AbstractConvertor<SysAreaCities, CodeNameDTO> {
    @Override
    public SysAreaCities toModel(CodeNameDTO codeNameDTO) {
        return null;
    }

    @Override
    public CodeNameDTO toDTO(SysAreaCities model, Object... objects) {
        CodeNameDTO dto = new CodeNameDTO();
        if (null != model) {
            dto.setId(model.getId());
            dto.setValue(model.getCityId());
            dto.setName(model.getCity());
        }
        return dto;
    }
}
