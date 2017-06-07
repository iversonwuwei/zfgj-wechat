package com.dlfc.services.house.service.impl;

import com.dlfc.services.house.entity.SysHouEquips;
import com.dlfc.services.house.entity.SysHouEquipsContrast;
import com.dlfc.services.house.repository.SystemRService;
import com.dlfc.services.house.service.SysHouEquipsService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by K on 2017/6/7.
 */

@Service
public class SysHouEquipsServiceImpl implements SysHouEquipsService {

    private String result;
    private SysHouEquips entity;
    private SysHouEquipsContrast entity2;

    @Autowired
    private SystemRService systemRService;
    @Autowired
    private IConvertor convertor;

    @Override
    public String save(SysHouEquips sysSurFacis) {
        return systemRService.saveSysHouEquips(sysSurFacis);
    }

    @Override
    public void saveWithLidAndCode(String lid,
                                   List<String> around) {
        for (String str : around) {
            entity = new SysHouEquips();
            entity.setLid(lid);
            entity.setEquipmentCode(str);
            result = systemRService.findSysHouEquipsContrastByCode(str);
            entity2 = (SysHouEquipsContrast) convertor.convert2Object(result, SysHouEquipsContrast.class);
            entity.setEquipmentName(entity2.getName());
            save(entity);
        }
    }
}
