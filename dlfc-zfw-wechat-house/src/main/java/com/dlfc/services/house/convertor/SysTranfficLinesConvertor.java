package com.dlfc.services.house.convertor;

import com.dlfc.services.house.convertor.base.AbstractConvertor;
import com.dlfc.services.house.dto.SysTranfficLinesDTO;
import com.dlfc.zfw.wechat.entities.entity.SysTrafficLines;
import org.springframework.stereotype.Component;


@Component
public class SysTranfficLinesConvertor extends AbstractConvertor<SysTrafficLines, SysTranfficLinesDTO> {
    @Override
    public SysTrafficLines toModel(SysTranfficLinesDTO sysTranfficLinesDTO) {
        SysTrafficLines sysTrafficLines = new SysTrafficLines();
        sysTrafficLines.setLid(sysTranfficLinesDTO.getLid());
        sysTrafficLines.setTrafficLine(sysTranfficLinesDTO.getName());
        if (sysTranfficLinesDTO.getOthers() != null) {
            sysTrafficLines.setOthers(sysTranfficLinesDTO.getOthers());
        }
        return sysTrafficLines;
    }

    @Override
    public SysTranfficLinesDTO toDTO(SysTrafficLines sysTrafficLines, Object... objects) {
        SysTranfficLinesDTO sysTranfficLinesDTO = new SysTranfficLinesDTO();
        sysTranfficLinesDTO.setId(sysTrafficLines.getId());
        sysTranfficLinesDTO.setLid(sysTrafficLines.getLid());
        if (sysTrafficLines.getTrafficLine() != null) {
            sysTranfficLinesDTO.setName(sysTrafficLines.getTrafficLine());
        }
        if (sysTrafficLines.getOthers() != null) {
            sysTranfficLinesDTO.setOthers(sysTrafficLines.getOthers());
        }

        return sysTranfficLinesDTO;
    }
}
