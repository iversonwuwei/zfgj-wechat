package com.dlfc.services.unicom.service.impl;

import com.dlfc.services.unicom.entity.SysCode;
import com.dlfc.services.unicom.repository.UnicomRepository;
import com.dlfc.services.unicom.service.SysCodeService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysCodeServiceImpl implements SysCodeService {

    @Autowired
    private UnicomRepository unicomRepository;
    @Autowired
    private IConvertor<SysCode> convertor;

    @Override
    public List<SysCode> findByType(String type) {
        String types = unicomRepository.findByScope(type);
        List<SysCode> sysCodes = convertor.convert2Objects(types, SysCode.class);
        return sysCodes;
    }
}
