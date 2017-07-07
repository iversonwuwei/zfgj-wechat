package com.dlfc.services.auth.service.impl;

import com.dlfc.services.auth.entity.SysParam;
import com.dlfc.services.auth.repository.UserAuthRService;
import com.dlfc.services.auth.service.AuthParamService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AuthParamServiceImpl implements AuthParamService {

    @Autowired
    private UserAuthRService userAuthRService;

    @Autowired
    private IConvertor<SysParam> convertor;

    @Override
    public List<SysParam> findSysParam(String scope) {

        String sysParams = userAuthRService.findByScope("auth");
        List<SysParam> sysParamList = convertor.convert2Objects(sysParams, SysParam.class);
        AuthParamServiceImpl.log.info("test");
        AuthParamServiceImpl.log.debug("debug");
        return sysParamList;
    }
}
