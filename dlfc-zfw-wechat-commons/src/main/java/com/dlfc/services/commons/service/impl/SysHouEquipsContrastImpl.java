package com.dlfc.services.commons.service.impl;

import com.dlfc.services.commons.repository.RepositoryService;
import com.dlfc.services.commons.service.DataService;
import com.dlfc.zfw.wechat.entities.entity.SysCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by K on 2017/6/2.
 */
@Service("SysHouEquipsContrastImpl")
public class SysHouEquipsContrastImpl implements DataService<SysCode> {

    private List<SysCode> result;
    @Autowired
    private RepositoryService repositoryService;

    @Override
    public List<SysCode> findBy(String param) {
        return null;
    }

    @Override
    public List<SysCode> findAll() {
        result = repositoryService.findByCode("hou_surroundings");
        return result;
    }
}
