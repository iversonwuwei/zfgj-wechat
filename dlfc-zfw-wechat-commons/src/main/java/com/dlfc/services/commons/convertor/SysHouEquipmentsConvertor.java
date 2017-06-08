package com.dlfc.services.commons.convertor;

import com.dlfc.services.commons.dto.CodeNameDTO;
import com.dlfc.services.commons.entity.SysHouEquipsContrast;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Component;

/**
 * Created by K on 2017/6/2.
 */

@Component
public class SysHouEquipmentsConvertor extends AbstractConvertor<SysHouEquipsContrast, CodeNameDTO> {
    @Override
    public SysHouEquipsContrast toModel(CodeNameDTO codeNameDTO) {
        return null;
    }

    @Override
    public CodeNameDTO toDTO(SysHouEquipsContrast model, Object... strings) {
        CodeNameDTO dto = new CodeNameDTO();
        if (null != model) {
            dto.setId(model.getId());
            dto.setValue(model.getCode());
            dto.setName(model.getName());
        }
        return dto;
    }
}
