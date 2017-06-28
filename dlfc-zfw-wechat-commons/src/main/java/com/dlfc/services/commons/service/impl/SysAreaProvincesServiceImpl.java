package com.dlfc.services.commons.service.impl;

import com.dlfc.services.commons.repository.RepositoryService;
import com.dlfc.services.commons.service.DataService;
import com.dlfc.zfw.wechat.entities.entity.SysAreaProvinces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by K on 6/28/17.
 */

@Service("SysAreaProvincesServiceImpl")
public class SysAreaProvincesServiceImpl implements DataService<SysAreaProvinces> {

    @Autowired
    private RepositoryService repositoryService;

    @Override
    public List<SysAreaProvinces> findBy(String param) {
        return null;
    }

    @Override
    public List<SysAreaProvinces> findAll() {
        return repositoryService.findSysAreaProvincesAll();
    }
}
