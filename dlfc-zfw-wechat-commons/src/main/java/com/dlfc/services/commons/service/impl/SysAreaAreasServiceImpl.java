package com.dlfc.services.commons.service.impl;

import com.dlfc.services.commons.repository.RepositoryService;
import com.dlfc.services.commons.service.DataService;
import com.dlfc.zfw.wechat.entities.entity.SysAreaAreas;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by K on 2017/6/2.
 */

@Service
public class SysAreaAreasServiceImpl implements DataService<SysAreaAreas> {

    private String result;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private IConvertor<SysAreaAreas> convertor;

    @Override
    public List<SysAreaAreas> findBy(String cityId) {
        result = repositoryService.findSysAreaAreasByCityId(cityId);
        return convertor.convert2Objects(result, SysAreaAreas.class);
    }

    @Override
    public List<SysAreaAreas> findAll() {
        return null;
    }
}
