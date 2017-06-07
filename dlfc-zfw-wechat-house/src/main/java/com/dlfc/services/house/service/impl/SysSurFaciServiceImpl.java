package com.dlfc.services.house.service.impl;

import com.dlfc.services.house.entity.SysSurFacis;
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

    @Autowired
    private SystemRService systemRService;
    @Autowired
    private IConvertor<SysSurFacis> convertor;

    @Override
    public String save(SysSurFacis sysSurFacis) {
        return systemRService.saveSysSurFacis(sysSurFacis);
    }

    @Override
    public void saveWithLidAndCode(String lid,
                                   List<String> around) {
        for (String str : around) {
            entity = new SysSurFacis();
            entity.setLid(lid);
            entity.setFacilityCode(str);
            result = systemRService.findSysSurFacisContrastByCode(str);
        }
    }
}
