package com.dlfc.services.commons.service.impl;

import com.dlfc.services.commons.repository.RepositoryService;
import com.dlfc.services.commons.service.DataService;
import com.dlfc.zfw.wechat.entities.entity.SysCode;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by K on 2017/6/2.
 */

@Service
public class SysCodeServiceImpl implements DataService<SysCode> {

    private String result;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private IConvertor<SysCode> convertor;

    @Override
    public List<SysCode> findBy(String type) {
        result = repositoryService.findSysCodeByType(type);
        return convertor.convert2Objects(result, SysCode.class);
    }

    @Override
    public List<SysCode> findAll() {
        return null;
    }
}
