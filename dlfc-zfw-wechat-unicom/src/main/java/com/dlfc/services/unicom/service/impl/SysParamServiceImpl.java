package com.dlfc.services.unicom.service.impl;

import com.dlfc.services.unicom.entity.SysParam;
import com.dlfc.services.unicom.repository.UnicomRepository;
import com.dlfc.services.unicom.service.SysParamService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysParamServiceImpl implements SysParamService {

    @Autowired
    private UnicomRepository unicomRepository;
    @Autowired
    private IConvertor<SysParam> convertor;


    @Override
    public List<SysParam> findByScope(String scope) {
        String scopes = unicomRepository.findByScope(scope);
        List<SysParam> sysParams = convertor.convert2Objects(scopes, SysParam.class);
        return sysParams;
    }
}
