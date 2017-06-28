package com.dlfc.services.commons.convertor;

import com.dlfc.services.commons.dto.CodeNameDTO;
import com.dlfc.zfw.wechat.entities.entity.SysAreaProvinces;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Component;

/**
 * Created by K on 6/28/17.
 */

@Component
public class SysAreaProvincesConvertor extends AbstractConvertor<SysAreaProvinces, CodeNameDTO> {
    @Override
    public SysAreaProvinces toModel(CodeNameDTO codeNameDTO) {
        return null;
    }

    @Override
    public CodeNameDTO toDTO(SysAreaProvinces model, Object... objects) {
        CodeNameDTO dto = new CodeNameDTO();
        if (null != model) {
            dto.setId(model.getId());
            dto.setValue(model.getProvinceId());
            dto.setName(model.getProvince());
        }
        return dto;
    }
}
