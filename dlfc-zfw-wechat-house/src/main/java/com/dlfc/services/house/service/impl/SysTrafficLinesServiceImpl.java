package com.dlfc.services.house.service.impl;

import com.dlfc.services.house.repository.MoreRService;
import com.dlfc.services.house.repository.SystemRService;
import com.dlfc.services.house.service.SysTrafficLinesService;
import com.dlfc.zfw.wechat.entities.entity.SysTrafficLines;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by K on 2017/6/7.
 */

@Service
public class SysTrafficLinesServiceImpl implements SysTrafficLinesService {

    private SysTrafficLines entity;

    @Autowired
    private SystemRService systemRService;
    @Autowired
    private IConvertor convertor;
    @Autowired
    private MoreRService moreRService;

    @Override
    public String save(SysTrafficLines sysTrafficLines,
                       UsrUser user) {
        if (null != sysTrafficLines
                && null != user) {
            sysTrafficLines.preInsert(user);
            return systemRService.saveSysTrafficLines(sysTrafficLines);
        }
        return null;
    }

    @Override
    public List<SysTrafficLines> findByLid(String lid) {
        String lines = moreRService.findsysTrafficLinesById(lid);
        if (lines == null) {
            return null;
        }
        return convertor.convert2Objects(lines, SysTrafficLines.class);
    }

    @Override
    public void remove(String lid) {
        moreRService.trafficRemove(lid);
    }
}
