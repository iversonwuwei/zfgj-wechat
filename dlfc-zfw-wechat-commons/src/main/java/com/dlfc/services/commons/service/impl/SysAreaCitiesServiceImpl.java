package com.dlfc.services.commons.service.impl;

import com.dlfc.services.commons.repository.RepositoryService;
import com.dlfc.services.commons.service.DataService;
import com.dlfc.zfw.wechat.entities.entity.SysAreaCities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by K on 6/28/17.
 */

@Service("SysAreaCitiesServiceImpl")
public class SysAreaCitiesServiceImpl implements DataService<SysAreaCities> {

    @Autowired
    private RepositoryService repositoryService;

    @Override
    public List<SysAreaCities> findBy(String param) {
        return repositoryService.findCitiesByProvince(param);
    }

    @Override
    public List<SysAreaCities> findAll() {
        return repositoryService.findCitiesAll();
    }
}
