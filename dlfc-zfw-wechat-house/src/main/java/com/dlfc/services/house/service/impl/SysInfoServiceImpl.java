package com.dlfc.services.house.service.impl;


import com.dlfc.services.house.enums.InfoAttFileTypeEnum;
import com.dlfc.services.house.repository.MoreRService;
import com.dlfc.services.house.repository.SystemRService;
import com.dlfc.services.house.service.SysInfoAttService;
import com.dlfc.zfw.wechat.entities.entity.SysInfoAtt;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
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
    public String save(SysInfoAtt sysInfoAtt,
                       UsrUser user) {
        if (null != sysInfoAtt
                && null != user) {
            sysInfoAtt.preInsert(user);
            return systemRService.saveSysInfoAtt(sysInfoAtt);
        }
        return null;
    }

    @Override
    public void remove(String lid) {
        moreRService.SysInfoAttRemove(lid);
    }
}
