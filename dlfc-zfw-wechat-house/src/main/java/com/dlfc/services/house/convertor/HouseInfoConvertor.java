package com.dlfc.services.house.convertor;

import com.dlfc.services.house.dto.HouseDTO;
import com.dlfc.services.house.dto.SysHouEquipsDTO;
import com.dlfc.services.house.dto.SysSurFaciesDTO;
import com.dlfc.services.house.dto.SysTranfficLinesDTO;
import com.dlfc.services.house.entity.HouLeaseInfo;
import com.dlfc.services.house.entity.SysInfoAtt;
import com.dlfc.services.house.enums.AuditStatusEnum;
import com.dlfc.services.house.service.*;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;
import com.housecenter.dlfc.framework.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class HouseInfoConvertor extends AbstractConvertor<HouLeaseInfo, HouseDTO> {

    private String[] array;

    @Autowired
    private SysInfoAttService sysInfoAttService;
    @Autowired
    private HouCollectionService houCollectionService;

    @Autowired
    private SysHouEquipsService sysHouEquipsService;
    @Autowired
    private SysDescriptionsService sysDescriptionsService;
    @Autowired
    private SysSurFaciService sysSurFaciService;
    @Autowired
    private SysTrafficLinesService sysTrafficLinesService;


    @Autowired
    private SysHouEquipsConvertor sysHouEquipsConvertor;
    @Autowired
    private SysTranfficLinesConvertor tranfficLinesConvertor;
    @Autowired
    private SysSurFaciesConvertor sysSurFaciesConvertor;
    @Autowired
    private SysDescriptionConvertor sysDescriptionConvertor;

    @Override
    public HouLeaseInfo toModel(HouseDTO dto) {
        HouLeaseInfo model = new HouLeaseInfo();
        model.setTitle(dto.getDesc());
        model.setDistrict(generate(dto.getDistrictArea(), dto.getDistrictTrade()));
        model.setDistrictName(dto.getDistrictAreaName() + StringUtils.SPACE + dto.getDistrictTradeName());
        model.setVillageName(dto.getVillageName());
        model.setRentalArea(dto.getHouseArea());
        model.setApartmentLayout(generate(dto.getLayoutRoom(), dto.getLayoutHall(), dto.getLayoutToilet()));
        model.setOrientation(dto.getOrientation());
        model.setFloor(generate(dto.getLiveFloor(), dto.getSumFloor()));
        model.setLeaseMode(dto.getLeaseMode());
        model.setRequirement(dto.getTermRequirement());
        model.setRent(dto.getPrice());
        model.setRentType(generate(dto.getDepositType(), dto.getPaymentType()));
        model.setUid(dto.getUid());
        model.setReleaseStatus(dto.getHouStatus());
        model.setAuditStatus(AuditStatusEnum.UNAUDITED_ENUM.getValue());
        return model;
    }

    @Override
    public HouseDTO toDTO(HouLeaseInfo model, Object... strs) {
        HouseDTO dto = new HouseDTO();
        dto.setId(model.getId());
        dto.setDesc(model.getTitle());
        String[] dictrict = split(model.getDistrict(),",");
        if (dictrict != null) {
            dto.setDistrictArea(dictrict[0]);
            dto.setDistrictTrade(dictrict[1]);
        }
        String[] dictrictName = split(model.getDistrictName(), StringUtils.SPACE);
        if (dictrictName != null) {
            dto.setDistrictAreaName(dictrictName[0]);
            dto.setDistrictTradeName(dictrictName[1]);
        }
        dto.setVillageName(model.getVillageName());
        dto.setHouseArea(model.getRentalArea());
        String[] layout = split(model.getApartmentLayout(), ",");
        if (layout != null){
            dto.setLayoutRoom(layout[0]);
            dto.setLayoutHall(layout[1]);
            dto.setLayoutToilet(layout[2]);
        }
        dto.setOrientation(model.getOrientation());
        String[] floor = split(model.getFloor(), ",");
        if (floor != null){
            dto.setLiveFloor(floor[0]);
            dto.setSumFloor(floor[1]);
        }
        dto.setLeaseMode(model.getLeaseMode());
        dto.setTermRequirement(model.getRequirement());
        dto.setPrice(model.getRent());
        String[] type = split(model.getRentType(), ",");
        if (type != null){
            dto.setDepositType(type[0]);
            dto.setPaymentType(type[1]);
        }

        dto.setHouStatus(model.getReleaseStatus());
        dto.setAuditStatus(model.getAuditStatus());
        List<SysInfoAtt> sysInfoAtts = sysInfoAttService.findByLidAndFileType(model.getId());
        dto.setHouImg(getImgPaths(sysInfoAtts));
        dto.setCollected(houCollectionService.collected((String) strs[0], model.getId()));
        try {
            dto.setDescriptionDTOS(sysDescriptionConvertor.toResultDTO(sysDescriptionsService.findByLid(model.getId())));
            dto.setEquips(sysHouEquipsConvertor.toResultDTO(sysHouEquipsService.findByLid(model.getId())));
            dto.setAround(sysSurFaciesConvertor.toResultDTO(sysSurFaciService.findByLid(model.getId())));
            dto.setVehicles(tranfficLinesConvertor.toResultDTO(sysTrafficLinesService.findByLid(model.getId())));
        } catch (CustomRuntimeException e) {
            e.printStackTrace();
        }
        return dto;
    }

    private List<String> getImgPaths(List<SysInfoAtt> sysinfos) {
        List<String> imgPaths = new ArrayList<>();
        for (SysInfoAtt sysInfoAtt : sysinfos) {
            imgPaths.add(sysInfoAtt.getFilePath());
        }
        return imgPaths;
    }

    private String[] split(String district,
                         String fix) {
        if (StringUtils.isNotEmpty(district)
                && StringUtils.isNotEmpty(fix)) {
            array=org.springframework.util.StringUtils.delimitedListToStringArray(district, fix);
            return array;
        }
        return null;
    }

    private String generate(String... array) {
        StringBuffer buffer = new StringBuffer();
        if (null != array && array.length > 0) {
            for (String str : array) {
                if (StringUtils.isNotEmpty(str)) {
                    buffer.append(str);
                }
                buffer.append(",");
            }
            buffer.deleteCharAt(array.length - 1);
        }
        return buffer.toString();
    }
}
