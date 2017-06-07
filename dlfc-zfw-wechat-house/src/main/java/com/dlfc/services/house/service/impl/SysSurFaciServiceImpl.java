package com.dlfc.services.house.service.impl;

import com.dlfc.services.house.entity.SysSurFacis;
import com.dlfc.services.house.entity.SysSurFacisContrast;
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
            entity2 = (SysSurFacisContrast) convertor.convert2Object(result, SysSurFacisContrast.class);
            entity.setFacilityName(entity2.getName());
            save(entity);
        }
    }
}
