package com.dlfc.services.search.service.impl;

import com.dlfc.services.search.repository.PersonInfoRService;
import com.dlfc.services.search.service.SysPersonService;
import com.dlfc.zfw.wechat.entities.entity.SysPerson;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysPersonServiceImpl implements SysPersonService {

    @Autowired
    private IConvertor convertor;
    @Autowired
    private PersonInfoRService personInfoRService;

    @Override
    public SysPerson findById(String id) {
        String personInfo = personInfoRService.findPersonById(id);
        return (SysPerson) convertor.convert2Object(personInfo, SysPerson.class);
    }
}
