package com.dlfc.services.house.service.impl;


import com.dlfc.services.house.dto.HouLeaseInfoDTO;
import com.dlfc.services.house.enums.HouseReleaseStatusEnum;
import com.dlfc.services.house.repository.LesseeRService;
import com.dlfc.services.house.repository.SystemRService;
import com.dlfc.services.house.service.HouseLeaseInfoService;
import com.dlfc.zfw.wechat.entities.entity.HouLeaseInfo;
import com.dlfc.zfw.wechat.entities.entity.SysSurFacis;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        Integer releaseStatus = HouseReleaseStatusEnum.YES_ENUM.getValue();
        String orderBy = "AUDIT_STATUS DESC, FRESH_TIME DESC";
        String houLeaseInfos = lesseeRService.findAll(pageSize, pageNo, releaseStatus, orderBy);
        return convertor.convert2Objects(houLeaseInfos, HouLeaseInfo.class);
    }

    @Override
    public HouLeaseInfo findByHouseLeaseInfo(String id) {
        HouLeaseInfo result = lesseeRService.getLesseeById(id);
        if (null != result && 1 == result.getDeleteFlg()) {
            return null;
        }
        return result;
    }

    @Override
    public List<HouLeaseInfo> findByUid(String uid) {
        String orderBy = "AUDIT_STATUS DESC, FRESH_TIME DESC";
        result = lesseeRService.findByUid(uid, orderBy);
        return convertor.convert2Objects(result, HouLeaseInfo.class);
    }

    @Override
    public List<HouLeaseInfo> findByParams(HouLeaseInfoDTO dto) {
        if (lesseeRService.findByParams(dto) != null) {
            result = lesseeRService.findByParams(dto);
            entityList = convertor.convert2Objects(result, HouLeaseInfo.class);
        }
        /*List<String> facilityIdList = dto.getFacilityIdList();
        if (null == facilityIdList || facilityIdList.size() == 0) {
            return entityList;
        }
        List<HouLeaseInfo> houLeaseInfoList = new ArrayList<>();
        for (HouLeaseInfo item : entityList) {
            boolean flag = true;
            result = systemRService.findSysSurFacisByLid(item.getId());
            List<SysSurFacis> sysSurFacisList = null;
            if (result != null) {
                sysSurFacisList = sysSurFacisIConvertor.convert2Objects(result, SysSurFacis.class);
            }
            if (null == sysSurFacisList
                    || sysSurFacisList.size() < facilityIdList.size()) {
                flag = false;
            } else {
                for (SysSurFacis faci : sysSurFacisList) {
                    if (!facilityIdList.contains(faci)) {
                        flag = false;
                    }
                }
            }
            if (flag) {
                houLeaseInfoList.add(item);
            }
        }*/
        return entityList;
        //return houLeaseInfoList;
    }

    @Override
    public boolean publish(String id) {

        HouLeaseInfo lesseeInfo = lesseeRService.getLesseeById(id);
        if (lesseeInfo != null) {
            lesseeInfo.setReleaseStatus(HouseReleaseStatusEnum.YES_ENUM.getValue());
            lesseeInfo.setFreshTime(new Date().getTime());
            String lid = lesseeRService.update(lesseeInfo);
            if (lid != null) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean shutdown(String id) {
        HouLeaseInfo lesseeInfo = lesseeRService.getLesseeById(id);
        if (lesseeInfo != null) {
            lesseeInfo.setReleaseStatus(HouseReleaseStatusEnum.NO_ENUM.getValue());
            String lid = lesseeRService.update(lesseeInfo);
            if (lid != null) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String save(HouLeaseInfo houLeaseInfo,
                       UsrUser user) {
        if (null != houLeaseInfo
                && null != user) {
            houLeaseInfo.preInsert(user);
            return lesseeRService.save(houLeaseInfo);
        }
        return null;
    }

    @Override
    public boolean update(HouLeaseInfo houLeaseInfo) {

        if (houLeaseInfo != null) {
            String lid = lesseeRService.update(houLeaseInfo);
            if (lid != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String lid) {
        String id = lesseeRService.removeById(lid);
        if (id != null) {
            return true;
        }
        return false;
    }

}
