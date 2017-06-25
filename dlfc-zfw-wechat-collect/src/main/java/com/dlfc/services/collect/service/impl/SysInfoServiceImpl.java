package com.dlfc.services.collect.service.impl;

import com.dlfc.services.collect.enums.InfoAttFileTypeEnum;
import com.dlfc.services.collect.repository.SysInfoAttRService;
import com.dlfc.services.collect.service.SysInfoAttService;
import com.dlfc.zfw.wechat.entities.entity.SysInfoAtt;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysInfoServiceImpl implements SysInfoAttService {

    @Autowired
    private SysInfoAttRService sysInfoAttRService;
    @Autowired
    private IConvertor convertor;

    @Override
    public List<SysInfoAtt> findByLidAndFileType(String lid) {

        String sysInfoAtt = sysInfoAttRService.findByLidAndFileType(lid, InfoAttFileTypeEnum.HOUSE_PIC_ENUM.getValue());
        List<SysInfoAtt> sysInfoAtts = convertor.convert2Objects(sysInfoAtt, SysInfoAtt.class);
        return sysInfoAtts;
    }
}
