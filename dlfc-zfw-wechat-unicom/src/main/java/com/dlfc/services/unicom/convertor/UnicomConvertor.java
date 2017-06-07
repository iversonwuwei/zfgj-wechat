package com.dlfc.services.unicom.convertor;

import com.dlfc.services.unicom.dto.UnicomDTO;
import com.dlfc.services.unicom.entity.SysParam;
import com.dlfc.services.unicom.service.SysCodeService;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.beans.factory.annotation.Autowired;

public class UnicomConvertor extends AbstractConvertor<SysParam, UnicomDTO> {

    @Autowired
    private SysCodeService sysCodeService;

    @Override
    public SysParam toModel(UnicomDTO unicomDTO) {
        return null;
    }

    @Override
    public UnicomDTO toDTO(SysParam sysParam, Object... objects) {

        return null;
    }
}
