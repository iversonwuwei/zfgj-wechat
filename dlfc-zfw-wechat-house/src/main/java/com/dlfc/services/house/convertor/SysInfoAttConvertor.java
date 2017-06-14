package com.dlfc.services.house.convertor;

import com.dlfc.services.house.dto.ImgDTO;
import com.dlfc.services.house.entity.SysInfoAtt;
import com.dlfc.services.house.enums.InfoAttFileTypeEnum;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import com.housecenter.dlfc.framework.common.util.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by K on 2017/6/13.
 */
@Component
public class SysInfoAttConvertor extends AbstractConvertor<SysInfoAtt, ImgDTO> {
    @Override
    public SysInfoAtt toModel(ImgDTO imgDTO) {
        SysInfoAtt model = new SysInfoAtt();
        if (imgDTO != null) {
            model.setFileName(imgDTO.getName());
            model.setFilePath(imgDTO.getPath());
            model.setSort(imgDTO.getPosition());
            model.setFileType(InfoAttFileTypeEnum.HOUSE_PIC_ENUM.getValue());
        }
        return model;
    }

    @Override
    public ImgDTO toDTO(SysInfoAtt sysInfoAtt, Object... objects) {
        ImgDTO imgDTO = new ImgDTO();
        imgDTO.setName(sysInfoAtt.getFileName());
        imgDTO.setPosition(sysInfoAtt.getSort());
        imgDTO.setPath(sysInfoAtt.getFilePath());

        return imgDTO;
    }
}
