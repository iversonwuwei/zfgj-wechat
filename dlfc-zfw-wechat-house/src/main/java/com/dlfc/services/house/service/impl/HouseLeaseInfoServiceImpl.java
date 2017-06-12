package com.dlfc.services.house.service.impl;


import com.dlfc.services.house.dto.HouLeaseInfoDTO;
import com.dlfc.services.house.entity.HouLeaseInfo;
import com.dlfc.services.house.entity.SysSurFacis;
import com.dlfc.services.house.entity.UsrUser;
import com.dlfc.services.house.repository.LesseeRService;
import com.dlfc.services.house.repository.SystemRService;
import com.dlfc.services.house.service.HouseLeaseInfoService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class HouseLeaseInfoServiceImpl implements HouseLeaseInfoService {

    private String result;
    private List<HouLeaseInfo> entityList;

    @Autowired
    private LesseeRService lesseeRService;
    @Autowired
    private SystemRService systemRService;
    @Autowired
    private IConvertor<HouLeaseInfo> convertor;
    @Autowired
    private IConvertor<SysSurFacis> sysSurFacisIConvertor;


    @Override
    public List<HouLeaseInfo> findAll(Integer pageNo, Integer pageSize) {
        String houLeaseInfos = lesseeRService.findAll(pageSize, pageNo);
        return convertor.convert2Objects(houLeaseInfos, HouLeaseInfo.class);
    }

    @Override
    public HouLeaseInfo findByHouseLeaseInfo(String id) {
        result = lesseeRService.getLesseeById(id);
        if(result == null){
            return null;
        }
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
        entityList = convertor.convert2Objects(result, HouLeaseInfo.class);
        List<HouLeaseInfo> houLeaseInfoList = new ArrayList<>();
        List<String> facilityIdList = dto.getFacilityIdList();
        for (HouLeaseInfo item : entityList) {
            boolean flag = true;
            result = systemRService.findSysSurFacisByLid(item.getId());
            List<SysSurFacis> sysSurFacisList = null;
            if (result != null) {
                sysSurFacisList = sysSurFacisIConvertor.convert2Objects(result, SysSurFacis.class);
            }
            if (facilityIdList!= null && sysSurFacisList.size() != facilityIdList.size()) {
                flag = false;
            } else {
                for (SysSurFacis sysSurFacis : sysSurFacisList) {
                    if (!facilityIdList.contains(sysSurFacis.getFacilityCode())) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                houLeaseInfoList.add(item);
            }
        }
        return houLeaseInfoList;
    }

    @Override
    public String save(HouLeaseInfo houLeaseInfo) {
        return lesseeRService.save(houLeaseInfo);
    }

}
