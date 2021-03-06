package com.dlfc.services.house.service.impl;

import com.dlfc.services.house.repository.MoreRService;
import com.dlfc.services.house.repository.SystemRService;
import com.dlfc.services.house.service.SysSurFaciService;
import com.dlfc.zfw.wechat.entities.entity.SysSurFacis;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by K on 2017/6/3.
 */

@Service
public class SysSurFaciServiceImpl implements SysSurFaciService {

    @Autowired
    private SystemRService systemRService;
    @Autowired
    private IConvertor convertor;
    @Autowired
    private MoreRService moreRService;

    @Override
    public String save(SysSurFacis sysSurFacis,
                       UsrUser user) {
        if (null != sysSurFacis
                && null != user) {
            sysSurFacis.preInsert(user);
            return systemRService.saveSysSurFacis(sysSurFacis);
        }
        return null;
    }

    @Override
    public List<SysSurFacis> findByLid(String lid) {
        String surFacis = moreRService.findsysSurroundingFacilitiesByLid(lid);
        if (surFacis == null) {
            return null;
        }
        return convertor.convert2Objects(surFacis, SysSurFacis.class);
    }

    @Override
    public void remove(String lid) {
        moreRService.surFacRemove(lid);
    }
}
