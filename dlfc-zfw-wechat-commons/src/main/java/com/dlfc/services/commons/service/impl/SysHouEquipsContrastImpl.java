package com.dlfc.services.commons.service.impl;

import com.dlfc.services.commons.entity.SysHouEquipsContrast;
import com.dlfc.services.commons.repository.RepositoryService;
import com.dlfc.services.commons.service.DataService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by K on 2017/6/2.
 */
@Service
public class SysHouEquipsContrastImpl implements DataService<SysHouEquipsContrast> {

    private String result;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private IConvertor convertor;

    @Override
    public List<SysHouEquipsContrast> findBy(String param) {
        return null;
    }

    @Override
    public List<SysHouEquipsContrast> findAll() {
        result = repositoryService.findSysHouEquipsContrastAll();
        return convertor.convert2Objects(result, SysHouEquipsContrast.class);
    }
}
