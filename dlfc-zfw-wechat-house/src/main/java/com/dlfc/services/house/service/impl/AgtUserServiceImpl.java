package com.dlfc.services.house.service.impl;

import com.dlfc.services.house.repository.AgtInfoRService;
import com.dlfc.services.house.service.AgtUserService;
import com.dlfc.zfw.wechat.entities.entity.AgtEmpInfo;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import com.housecenter.dlfc.framework.boot.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by walden on 17-6-15.
 */
@Service
public class AgtUserServiceImpl implements AgtUserService {

    @Autowired
    private AgtInfoRService agtInfoRService;
    @Autowired
    private IConvertor<AgtEmpInfo> convertor;

    @Override
    public AgtEmpInfo findById(String eid) {
        AgtEmpInfo agtEmpInfo = null;
        String agtUser =null;
        if (eid!=null) {
            agtUser = agtInfoRService.findEmpUser(eid);
        }
        if (agtUser != null){
            agtEmpInfo = convertor.convert2Object(agtUser, AgtEmpInfo.class);
        }
        return agtEmpInfo;
    }
}
