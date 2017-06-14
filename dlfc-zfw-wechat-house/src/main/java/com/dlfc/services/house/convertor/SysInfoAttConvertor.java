package com.dlfc.services.house.convertor;

import com.dlfc.services.house.entity.SysInfoAtt;
import com.dlfc.services.house.enums.InfoAttFileTypeEnum;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import com.housecenter.dlfc.framework.common.util.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by K on 2017/6/13.
 */
@Component
public class SysInfoAttConvertor extends AbstractConvertor<SysInfoAtt, String> {
    @Override
    public SysInfoAtt toModel(String str) {
        SysInfoAtt model = new SysInfoAtt();
        if (StringUtils.isNotEmpty(str)) {
            int i = str.indexOf("/");
            model.setFileName(str.substring(0, i));
            model.setFilePath(str.substring(i));
            model.setFileType(InfoAttFileTypeEnum.HOUSE_PIC_ENUM.getValue());
        }
        return model;
    }

    @Override
    public String toDTO(SysInfoAtt sysInfoAtt, Object... objects) {
        return null;
    }
}
