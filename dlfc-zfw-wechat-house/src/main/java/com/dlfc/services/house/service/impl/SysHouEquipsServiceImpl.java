package com.dlfc.services.house.service.impl;

import com.dlfc.services.house.repository.MoreRService;
import com.dlfc.services.house.repository.SystemRService;
import com.dlfc.services.house.service.SysHouEquipsService;
import com.dlfc.zfw.wechat.entities.entity.SysHouEquips;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by K on 2017/6/7.
 */

@Service
public class SysHouEquipsServiceImpl implements SysHouEquipsService {

    @Autowired
    private SystemRService systemRService;
    @Autowired
    private IConvertor convertor;
    @Autowired
    private MoreRService moreRService;

    @Override
    public String save(SysHouEquips sysHouEquips,
                       UsrUser user) {
        if (null != sysHouEquips
                && null != user) {
            sysHouEquips.preInsert(user);
            return systemRService.saveSysHouEquips(sysHouEquips);
        }
        return null;
    }

    @Override
    public List<SysHouEquips> findByLid(String lid) {
        String houEquips = moreRService.findsysHouEquipsByLid(lid);
        if (houEquips == null) {
            return null;
        }
        return convertor.convert2Objects(houEquips, SysHouEquips.class);
    }

    @Override
    public void remove(String lid) {
        moreRService.houEquipRemove(lid);
    }
}
