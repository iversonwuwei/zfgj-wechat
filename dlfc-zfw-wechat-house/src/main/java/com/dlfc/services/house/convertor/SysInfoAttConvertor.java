package com.dlfc.services.house.convertor;

import com.dlfc.services.house.dto.ImgDTO;
import com.dlfc.services.house.enums.InfoAttFileTypeEnum;
import com.dlfc.zfw.wechat.entities.entity.SysInfoAtt;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        if (sysInfoAtt.getFileName()!= null) {
            if (picNames().contains(sysInfoAtt.getFileName())) {
                imgDTO.setName(sysInfoAtt.getFileName());
            }
        }
        imgDTO.setPosition(sysInfoAtt.getSort());
        imgDTO.setPath(sysInfoAtt.getFilePath());
        return imgDTO;
    }

    private List<String> picNames(){
        List<String> names = new ArrayList<>();
        names.add("厨房");
        names.add("客厅");
        names.add("卫生间");
        names.add("主卧");
        names.add("次卧");
        names.add("书房");
        names.add("其他房间");

        return names;

    }
}
