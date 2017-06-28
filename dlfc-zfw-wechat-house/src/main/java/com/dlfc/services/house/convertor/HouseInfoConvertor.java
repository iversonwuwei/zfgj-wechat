package com.dlfc.services.house.convertor;

import com.dlfc.admin.common.utils.Const;
import com.dlfc.admin.common.utils.DateUtils;
import com.dlfc.admin.common.utils.OrderUtils;
import com.dlfc.services.house.dto.HouseDTO;
import com.dlfc.services.house.dto.ImgDTO;
import com.dlfc.services.house.dto.SysHouEquipsDTO;
import com.dlfc.services.house.dto.SysSurFaciesDTO;
import com.dlfc.services.house.enums.AuditStatusEnum;
import com.dlfc.services.house.enums.LeaseInfoSysSourceEnum;
import com.dlfc.services.house.service.*;
import com.dlfc.zfw.wechat.entities.entity.*;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;
import com.housecenter.dlfc.framework.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private SysInfoAttConvertor sysInfoAttConvertor;

    @Autowired
    private AgtUserService agtUserService;
    @Autowired
    private UsrUserService usrUserService;
    @Autowired
    private SysCodeService sysCodeService;

    @Override
    public HouLeaseInfo toModel(HouseDTO dto) {
        HouLeaseInfo model = new HouLeaseInfo();
        model.setTitle(dto.getDesc());
        model.setId(dto.getId());
        model.setDistrict(generate(dto.getDistrictArea(), dto.getDistrictTrade()));
        model.setDistrictName(dto.getDistrictAreaName() + StringUtils.SPACE + dto.getDistrictTradeName());
        model.setVillageName(dto.getVillageName());
        model.setRentalArea(dto.getHouseArea());
        model.setApartmentLayout(generate(dto.getLayoutRoom(), dto.getLayoutHall(), dto.getLayoutToilet()));
        model.setOrientation(dto.getOrientation());
        model.setFloor(generate(dto.getLiveFloor(), dto.getSumFloor()));
        if (StringUtils.isNotEmpty(dto.getLeaseMode())) {
            model.setLeaseMode(Integer.valueOf(dto.getLeaseMode()));
        }
        if (!"0".equals(dto.getTermRequirement())) {
            model.setRequirement(dto.getTermRequirement());
        }
        model.setRent(dto.getPrice());
        model.setRentType(generate(dto.getDepositType(), dto.getPaymentType()));
        model.setUid(dto.getUid());
        model.setReleaseStatus(dto.getHouStatus());
        model.setAuditStatus(AuditStatusEnum.UNAUDITED_ENUM.getValue());
        // 房源编号
        model.setLno(OrderUtils.getBusinessNO(Const.BUSINESS_TYPE_LEASE));
        // 房源来源
        model.setSysSource(LeaseInfoSysSourceEnum.WECHAT.getValue());
        // 刷新时间
        model.setFreshTime(DateUtils.getSynchTime().getTime());
        // 上架时间
        model.setReleaseTime(DateUtils.getSynchTime().getTime());
        StringBuilder sb = null;
        if (dto.getAround() != null) {
            sb = new StringBuilder();
            for (SysSurFaciesDTO sysSurFaciesDTO : dto.getAround()) {
                sb.append(sysSurFaciesDTO.getCode());
                sb.append(",");
            }
        }
        model.setHouSurFacis(sb.toString());
        if (dto.getEquips() != null) {
            sb = new StringBuilder();
            for (SysHouEquipsDTO sysHouEquipsDTO : dto.getEquips()) {
                sb.append(sysHouEquipsDTO.getCode());
                sb.append(",");
            }
        }
        model.setFacilities(sb.toString());
        return model;
    }

    @Override
    public HouseDTO toDTO(HouLeaseInfo model, Object... strs) {
        HouseDTO dto = new HouseDTO();
        dto.setId(model.getId());
        dto.setDesc(model.getTitle());
        String[] dictrict = split(model.getDistrict(), ",");
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
        if (layout != null) {
            dto.setLayoutRoom(layout[0]);
            dto.setLayoutHall(layout[1]);
            dto.setLayoutToilet(layout[2]);
        }
        dto.setOrientation(model.getOrientation());
        String[] floor = split(model.getFloor(), ",");
        if (floor != null) {
            dto.setLiveFloor(floor[0]);
            dto.setSumFloor(floor[1]);
        }
        if (null != model.getLeaseMode()) {
            dto.setLeaseMode(model.getLeaseMode().toString());
        }
        if (StringUtils.isNotEmpty(model.getRequirement())) {
            array = model.getRequirement().split(",");
            for (String str : array) {
                if ("1".equals(str)) {
                    dto.setTermRequirement("1");
                    break;
                } else if ("2".equals(str)) {
                    dto.setTermRequirement("2");
                    break;
                }
            }
        } else {
            dto.setTermRequirement("0");
        }
        dto.setPrice(model.getRent());
        String[] type = split(model.getRentType(), ",");
        if (type != null) {
            dto.setDepositType(type[0]);
            dto.setPaymentType(type[1]);
        }
        dto.setDistrictTradeName(model.getDistrictName());
        dto.setHouStatus(model.getReleaseStatus());
        dto.setAuditStatus(model.getAuditStatus());
        List<SysInfoAtt> sysInfoAtts = sysInfoAttService.findByLidAndFileType(model.getId());
        dto.setHouImg(getImgPaths(sysInfoAtts));
        List<UsrHouCollection> houCollections = null;
        if (null != strs && null != strs[0]) {
            houCollections = houCollectionService.collected(strs[0].toString(), model.getId());
            if (houCollections != null && houCollections.size() > 0) {
                dto.setChid(houCollections.get(0).getId());
//                if (strs[0].equals("")) {
//                    if (model.getUid() != null) {
                dto.setCollected(true);
//                    } else {
//                        dto.setCollected(false);
//                    }
//                } else {
//                    dto.setCollected(true);
//                }
            } else {
                dto.setCollected(false);
            }
        }
        try {
            List<String> facilities = toList(split(model.getHouSurFacis(), ","));
            List<String> houEquips = toList(split(model.getFacilities(), ","));
            dto.setDescriptionDTOS(sysDescriptionConvertor.toResultDTO(sysDescriptionsService.findByLid(model.getId())));
            if (houEquips != null) {
                dto.setEquips(sysHouEquipsConvertor.toResultDTO(sysCodeService.findByType("house_facilities", houEquips)));
            }
            if (facilities != null) {
                dto.setAround(sysSurFaciesConvertor.toResultDTO(sysCodeService.findByType("house_sur_facilities", facilities)));
            }
            dto.setVehicles(tranfficLinesConvertor.toResultDTO(sysTrafficLinesService.findByLid(model.getId())));
        } catch (CustomRuntimeException e) {
            e.printStackTrace();
        }
        dto.setUid(model.getUid());
        dto.setLatitude(model.getLatitude());
        dto.setLongitude(model.getLongitude());
        UsrUser usrUser = usrUserService.findById(model.getUid());
        AgtEmpInfo agtEmpInfo = agtUserService.findById(model.getEid());
        if (usrUser == null) {
            dto.setPhone(agtEmpInfo.getPhone());
        }
        if (agtEmpInfo == null) {
            dto.setPhone(usrUser.getMobile());
        }
        if (model.getFreshTime() != null) {
            dto.setRefreshTime(new Date(model.getFreshTime()));
        }

        dto.setHouNumber(model.getLno());
        return dto;
    }

    private List<ImgDTO> getImgPaths(List<SysInfoAtt> sysinfos) {
        List<ImgDTO> imgPaths = new ArrayList<>();
        ImgDTO imgDTO = null;
        for (SysInfoAtt sysInfoAtt : sysinfos) {
            if (sysInfoAtt != null) {
                imgDTO = sysInfoAttConvertor.toDTO(sysInfoAtt);
            }
            imgPaths.add(imgDTO);
        }
        return imgPaths;
    }

    private String[] split(String district,
                           String fix) {
        if (StringUtils.isNotEmpty(district)
                && StringUtils.isNotEmpty(fix)) {
            array = org.springframework.util.StringUtils.delimitedListToStringArray(district, fix);
            return array;
        }
        return null;
    }

    private List<String> toList(String[] array) {
        List<String> toList = new ArrayList<>();
        if (array == null) {
            return null;
        }
        for (int i = 0; i < array.length; i++) {
            toList.add(array[i]);
        }

        return toList;
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
            buffer.deleteCharAt(buffer.length() - 1);
        }
        return buffer.toString();
    }
}
