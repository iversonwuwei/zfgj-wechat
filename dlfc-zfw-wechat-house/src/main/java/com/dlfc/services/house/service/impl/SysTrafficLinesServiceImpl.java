package com.dlfc.services.house.service.impl;

import com.dlfc.services.house.entity.SysTrafficLines;
import com.dlfc.services.house.repository.MoreRService;
import com.dlfc.services.house.repository.SystemRService;
import com.dlfc.services.house.service.SysTrafficLinesService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by K on 2017/6/7.
 */

@Service
public class SysTrafficLinesServiceImpl implements SysTrafficLinesService {

    private String result;
    private SysTrafficLines entity;

    @Autowired
    private SystemRService systemRService;
    @Autowired
    private IConvertor convertor;
    @Autowired
    private MoreRService moreRService;

    @Override
    public String save(SysTrafficLines sysSurFacis) {
        return systemRService.saveSysTrafficLines(sysSurFacis);
    }

    @Override
    public void saveWithLidAndLines(String lid,
                                    List<String> lines) {
        for (String str : lines) {
            entity = new SysTrafficLines();
            entity.setLid(lid);
            entity.setTrafficLine(str);
            save(entity);
        }
    }

    @Override
    public void saveWithLidAndOthers(String lid,
                                     String others) {
        entity = new SysTrafficLines();
        entity.setLid(lid);
        entity.setOthers(others);
        save(entity);
    }

    @Override
    public List<SysTrafficLines> findByLid(String lid) {
        String lines = moreRService.findsysTrafficLinesById(lid);
        if (lines == null){
            return null;
        }
        return convertor.convert2Objects(lines, SysTrafficLines.class);
    }
}
