package com.dlfc.services.house.service.impl;

import com.dlfc.services.house.entity.SysDescriptions;
import com.dlfc.services.house.repository.SystemRService;
import com.dlfc.services.house.service.SysDescriptionsService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by K on 2017/6/7.
 */

@Service
public class SysDescriptionsServiceImpl implements SysDescriptionsService {

    @Autowired
    private SystemRService systemRService;
    @Autowired
    private IConvertor convertor;

    @Override
    public void save(SysDescriptions sysDescriptions) {
        systemRService.saveSysDescriptions(sysDescriptions);
    }
}
