package com.dlfc.services.house.service.impl;

import com.dlfc.services.house.entity.SysSurFacis;
import com.dlfc.services.house.entity.SysSurFacisContrast;
import com.dlfc.services.house.repository.MoreRService;
import com.dlfc.services.house.repository.SystemRService;
import com.dlfc.services.house.service.SysSurFaciService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by K on 2017/6/3.
 */

@Service
public class SysSurFaciServiceImpl implements SysSurFaciService {

    private String result;
    private SysSurFacis entity;
    private SysSurFacisContrast entity2;

    @Autowired
    private SystemRService systemRService;
    @Autowired
    private IConvertor convertor;
    @Autowired
    private MoreRService moreRService;

    @Override
    public String save(SysSurFacis sysSurFacis) {
        return systemRService.saveSysSurFacis(sysSurFacis);
    }

    @Override
    public List<SysSurFacis> findByLid(String lid) {
        String surFacis = moreRService.findsysSurroundingFacilitiesByLid(lid);
        if (surFacis == null){
            return null;
        }
        return convertor.convert2Objects(surFacis, SysSurFacis.class);
    }
}
