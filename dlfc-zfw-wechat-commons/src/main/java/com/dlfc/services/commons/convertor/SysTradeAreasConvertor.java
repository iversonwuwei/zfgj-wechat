package com.dlfc.services.commons.convertor;

import com.dlfc.services.commons.dto.CodeNameDTO;
import com.dlfc.services.commons.entity.SysTradeAreas;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Component;

/**
 * Created by K on 2017/6/2.
 */

@Component
public class SysTradeAreasConvertor extends AbstractConvertor<SysTradeAreas, CodeNameDTO> {
    @Override
    public SysTradeAreas toModel(CodeNameDTO codeNameDTO) {
        return null;
    }

    @Override
    public CodeNameDTO toDTO(SysTradeAreas model, String... strings) {
        CodeNameDTO dto = new CodeNameDTO();
        if (null != model) {
            dto.setId(model.getId());
            dto.setCode(model.getTradeId());
            dto.setName(model.getName());
        }
        return dto;
    }
}