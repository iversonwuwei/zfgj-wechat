package com.dlfc.services.commons.service.impl;

import com.dlfc.services.commons.entity.SysHouEquipmentsContrast;
import com.dlfc.services.commons.repository.RepositoryService;
import com.dlfc.services.commons.service.DataService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by K on 2017/6/2.
 */
public class SysHouEquipmentsImpl implements DataService<SysHouEquipmentsContrast> {

    private String result;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private IConvertor<SysHouEquipmentsContrast> convertor;

    @Override
    public List<SysHouEquipmentsContrast> findBy(String param) {
        return null;
    }

    @Override
    public List<SysHouEquipmentsContrast> findAll() {
        result = repositoryService.findSysHouEquipmentsContrastAll();
        return convertor.convert2Objects(result, SysHouEquipmentsContrast.class);
    }
}
