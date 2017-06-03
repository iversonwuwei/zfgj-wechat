package com.dlfc.services.house.service.impl;


import com.dlfc.services.house.dto.HouLeaseInfoDTO;
import com.dlfc.services.house.entity.HouLeaseInfo;
import com.dlfc.services.house.repository.LesseeRService;
import com.dlfc.services.house.service.HouseLeaseInfoService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HouseLeaseInfoServiceImpl implements HouseLeaseInfoService {

    private String result;

    @Autowired
    private LesseeRService lesseeRService;
    @Autowired
    private IConvertor<HouLeaseInfo> convertor;


    @Override
    public HouLeaseInfo findByHouseLeaseInfo(String id) {

        result = lesseeRService.getLesseeById(id);

        return convertor.convert2Object(result, HouLeaseInfo.class);
    }

    @Override
    public List<HouLeaseInfo> findByUid(String uid) {
        result = lesseeRService.findByUid(uid);
        return convertor.convert2Objects(result, HouLeaseInfo.class);
    }

    @Override
    public List<HouLeaseInfo> findByParams(HouLeaseInfoDTO dto) {
        result = lesseeRService.findByParams(dto);
        return convertor.convert2Objects(result, HouLeaseInfo.class);
    }

}
