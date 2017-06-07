package com.dlfc.services.commons.service.impl;

import com.dlfc.services.commons.entity.SysSurFacisContrast;
import com.dlfc.services.commons.repository.RepositoryService;
import com.dlfc.services.commons.service.DataService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by K on 2017/6/7.
 */

@Service
public class SysSurFacisContrastServiceImpl implements DataService<SysSurFacisContrast> {

    private String result;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private IConvertor convertor;

    @Override
    public List<SysSurFacisContrast> findBy(String param) {
        return null;
    }

    @Override
    public List<SysSurFacisContrast> findAll() {
        result = repositoryService.findSysSurFacisContrastAll();
        return convertor.convert2Objects(result, SysSurFacisContrast.class);
    }
}
