package com.dlfc.services.house.service.impl;


import com.dlfc.services.house.entity.SysInfoAtt;
import com.dlfc.services.house.enums.InfoAttFileTypeEnum;
import com.dlfc.services.house.repository.MoreRService;
import com.dlfc.services.house.repository.SystemRService;
import com.dlfc.services.house.service.SysInfoAttService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysInfoServiceImpl implements SysInfoAttService {

    @Autowired
    private SystemRService systemRService;
    @Autowired
    private IConvertor convertor;
    @Autowired
    private MoreRService moreRService;

    @Override
    public List<SysInfoAtt> findByLidAndFileType(String lid) {

        String sysInfoAtt = systemRService.findSysInfoAttByLidAndFileType(lid, InfoAttFileTypeEnum.HOUSE_PIC_ENUM.getValue());
        List<SysInfoAtt> sysInfoAtts = convertor.convert2Objects(sysInfoAtt, SysInfoAtt.class);
        return sysInfoAtts;
    }

    @Override
    public String save(SysInfoAtt sysInfoAtt) {
        return systemRService.saveSysInfoAtt(sysInfoAtt);
    }

    @Override
    public void remove(String lid) {
        moreRService.SysInfoAttRemove(lid);
    }
}
