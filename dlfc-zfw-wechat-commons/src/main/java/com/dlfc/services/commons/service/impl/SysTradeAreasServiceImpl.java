package com.dlfc.services.commons.service.impl;

import com.dlfc.services.commons.repository.RepositoryService;
import com.dlfc.services.commons.service.DataService;
import com.dlfc.zfw.wechat.entities.entity.SysTradeAreas;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by K on 2017/6/2.
 */

@Service
public class SysTradeAreasServiceImpl implements DataService<SysTradeAreas> {

    private String result;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private IConvertor convertor;

    @Override
    public List<SysTradeAreas> findBy(String parentId) {
        result = repositoryService.findSysTradeAreasByParentId(parentId);
        return convertor.convert2Objects(result, SysTradeAreas.class);
    }

    @Override
    public List<SysTradeAreas> findAll() {
        result = repositoryService.findSysTradeAreasAll();
        return convertor.convert2Objects(result, SysTradeAreas.class);
    }
}
