package com.dlfc.services.house.service.impl;

import com.dlfc.services.house.repository.MoreRService;
import com.dlfc.services.house.repository.SystemRService;
import com.dlfc.services.house.service.SysDescriptionsService;
import com.dlfc.zfw.wechat.entities.entity.SysDescriptions;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by K on 2017/6/7.
 */

@Service
public class SysDescriptionsServiceImpl implements SysDescriptionsService {

    @Autowired
    private SystemRService systemRService;
    @Autowired
    private IConvertor convertor;
    @Autowired
    private MoreRService moreRService;

    @Override
    public String save(SysDescriptions sysDescriptions,
                     UsrUser user) {
        if (null != sysDescriptions
                && null != user) {
            sysDescriptions.preInsert(user);
            return systemRService.saveSysDescriptions(sysDescriptions);
        }
        return null;
    }

    @Override
    public List<SysDescriptions> findByLid(String lid) {
        String descriptions = moreRService.findByDescriptionLid(lid);
        if (descriptions == null){
            return null;
        }
        return convertor.convert2Objects(descriptions, SysDescriptions.class);
    }

    @Override
    public void remove(String lid) {
        moreRService.descRemove(lid);
    }
}
