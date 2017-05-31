package com.dlfc.services.search.service.impl;

import com.dlfc.services.search.convertor.base.IConvertor;
import com.dlfc.services.search.entity.SysInfoAtt;
import com.dlfc.services.search.enums.InfoAttFileTypeEnum;
import com.dlfc.services.search.repository.SysInfoAttRService;
import com.dlfc.services.search.service.SysInfoAttService;
import com.netflix.discovery.converters.Auto;
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
    public SysInfoAtt findByLidAndFileType(String lid) {

        String sysInfoAtt = sysInfoAttRService.findByLidAndFileType(lid, InfoAttFileTypeEnum.AVATAR_ENUM.getValue());
        List<Object> sysInfoAtts = convertor.convert2Objects(sysInfoAtt, SysInfoAtt.class);
        return (SysInfoAtt) sysInfoAtts.get(0);
    }
}
