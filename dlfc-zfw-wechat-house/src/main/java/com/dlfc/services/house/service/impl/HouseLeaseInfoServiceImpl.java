package com.dlfc.services.house.service.impl;


import com.dlfc.services.house.entity.HouLeaseInfo;
import com.dlfc.services.house.repository.HouseRService;
import com.dlfc.services.house.service.HouseLeaseInfoService;
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
