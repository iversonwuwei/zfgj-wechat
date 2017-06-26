package com.dlfc.services.commons.convertor;

import com.dlfc.services.commons.dto.CodeNameDTO;
import com.dlfc.services.commons.entity.SysSurFacisContrast;
import com.dlfc.zfw.wechat.entities.entity.SysCode;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Component;

/**
 * Created by K on 2017/6/7.
 */

@Component
public class SysSurFacisContrastConvertor extends AbstractConvertor<SysCode, CodeNameDTO> {
    @Override
    public SysCode toModel(CodeNameDTO codeNameDTO) {
        return null;
    }

    @Override
    public CodeNameDTO toDTO(SysCode model, Object... objects) {
        CodeNameDTO dto = new CodeNameDTO();
        dto.setId(model.getId());
        dto.setValue(model.getCode());
        dto.setName(model.getName());
        return dto;
    }
}
