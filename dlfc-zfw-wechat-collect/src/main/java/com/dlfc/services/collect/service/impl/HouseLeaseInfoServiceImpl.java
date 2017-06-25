package com.dlfc.services.collect.service.impl;

import com.dlfc.services.collect.repository.HouseRService;
import com.dlfc.services.collect.service.HouseLeaseInfoService;
import com.dlfc.zfw.wechat.entities.entity.HouLeaseInfo;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseLeaseInfoServiceImpl implements HouseLeaseInfoService {

    @Autowired
    private HouseRService houseRService;
    @Autowired
    private IConvertor<HouLeaseInfo> convertor;


    @Override
    public HouLeaseInfo findByHouseLeaseInfo(String id) {

        String houseInfo = houseRService.getLesseeById(id);

        return convertor.convert2Object(houseInfo, HouLeaseInfo.class);
    }

}
