package com.dlfc.services.commons.convertor;

import com.dlfc.services.commons.dto.CodeNameDTO;
import com.dlfc.services.commons.entity.SysAreaAreas;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Component;

/**
 * Created by K on 2017/6/2.
 */

@Component
public class SysAreaAreasConvertor extends AbstractConvertor<SysAreaAreas, CodeNameDTO> {
    @Override
    public SysAreaAreas toModel(CodeNameDTO codeNameDTO) {
        return null;
    }

    @Override
    public CodeNameDTO toDTO(SysAreaAreas model, Object... strings) {
        CodeNameDTO dto = new CodeNameDTO();
        if (null != model) {
            dto.setId(model.getId());
            dto.setValue(model.getAreaId());
            dto.setName(model.getArea());
            dto.setParent("0");
        }
        return dto;
    }
}
