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

    @Autowired
    private SystemRService systemRService;
    @Autowired
    private IConvertor<SysSurFacis> convertor;

    @Override
    public List<SysSurFacis> findByFacilityIds(List<String> facilityIds) {
        result = systemRService.findSysSurFacisByFacilityIds(facilityIds);
        return convertor.convert2Objects(result, SysSurFacis.class);
    }
}
