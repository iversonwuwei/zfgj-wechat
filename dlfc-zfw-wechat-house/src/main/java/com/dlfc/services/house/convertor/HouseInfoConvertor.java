package com.dlfc.services.house.convertor;

import com.dlfc.services.house.dto.HouseDTO;
import com.dlfc.services.house.entity.HouLeaseInfo;
import com.dlfc.services.house.entity.SysInfoAtt;
import com.dlfc.services.house.service.HouCollectionService;
import com.dlfc.services.house.service.SysInfoAttService;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class HouseInfoConvertor extends AbstractConvertor<HouLeaseInfo, HouseDTO> {

    @Autowired
    private SysInfoAttService sysInfoAttService;
    @Autowired
    private HouCollectionService houCollectionService;

    @Override
    public HouLeaseInfo toModel(HouseDTO dto) {
        HouLeaseInfo model=new HouLeaseInfo();
        model.setTitle(dto.getDesc());
        model.setDistrict(dto.getDistrict());
        model.setVillageName(dto.getVillageName());
        model.setRentalArea(dto.getHouseArea());
        model.setApartmentLayout(dto.getLayout());
        model.setOrientation(dto.getOrientation());
        model.setFloor(dto.getFloor());
        model.setLeaseMode(dto.getLeaseMode());
        model.setRequirement(dto.getTermRequirement());
        model.setRent(dto.getPrice());
        model.setRentType(dto.getRentType());
        return model;
    }

    @Override
    public HouseDTO toDTO(HouLeaseInfo houLeaseInfo, String...strs) {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setId(houLeaseInfo.getId());
        houseDTO.setOrientation(houLeaseInfo.getOrientation());
        houseDTO.setHouseArea(houLeaseInfo.getRentalArea());
        houseDTO.setFloor(houLeaseInfo.getFloor());
        houseDTO.setDesc(houLeaseInfo.getTitle());
        houseDTO.setLayout(houLeaseInfo.getApartmentLayout());
        houseDTO.setRentType(houLeaseInfo.getRentType());
        houseDTO.setPrice(houLeaseInfo.getRent());
        houseDTO.setLeaseMode(houLeaseInfo.getLeaseMode());
        List<SysInfoAtt> sysInfoAtts = sysInfoAttService.findByLidAndFileType(houLeaseInfo.getId());
        houseDTO.setHouImg(getImgPaths(sysInfoAtts));
        houseDTO.setCollected(houCollectionService.collected(strs[0],houLeaseInfo.getId()));
        houseDTO.setHouStatus(houLeaseInfo.getReleaseStatus());
        houseDTO.setAuditStatus(houLeaseInfo.getAuditStatus());
        return houseDTO;
    }

    private List<String> getImgPaths(List<SysInfoAtt> sysinfos){
        List<String> imgPaths = new ArrayList<>();

        for (SysInfoAtt sysInfoAtt: sysinfos){
            imgPaths.add(sysInfoAtt.getFilePath());
        }

        return imgPaths;
    }
}
