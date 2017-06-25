package com.dlfc.services.collect.convertor;

import com.dlfc.services.collect.dto.HouInfoCollectedDTO;
import com.dlfc.services.collect.service.HouseLeaseInfoService;
import com.dlfc.services.collect.service.SysInfoAttService;
import com.dlfc.zfw.wechat.entities.entity.HouLeaseInfo;
import com.dlfc.zfw.wechat.entities.entity.SysInfoAtt;
import com.dlfc.zfw.wechat.entities.entity.UsrHouCollection;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HouInfoColletedConvertor extends AbstractConvertor<UsrHouCollection, HouInfoCollectedDTO> {

    private String[] array;

    @Autowired
    private HouseLeaseInfoService houseLeaseInfoService;

    @Autowired
    private SysInfoAttService sysInfoAttService;


    @Override
    public UsrHouCollection toModel(HouInfoCollectedDTO houInfoCollectedDTO) {
        return null;
    }

    @Override
    public HouInfoCollectedDTO toDTO(UsrHouCollection usrHouCollection, Object... strings) {
        List<String> imgUrls = new ArrayList<>();
        final HouInfoCollectedDTO houInfoCollectedDTO = new HouInfoCollectedDTO();
        HouLeaseInfo houLeaseInfo = houseLeaseInfoService.findByHouseLeaseInfo(usrHouCollection.getHid());
        List<SysInfoAtt> sysInfoAtts = sysInfoAttService.findByLidAndFileType(houLeaseInfo.getId());
        if (sysInfoAtts != null) {
            for (SysInfoAtt sysInfoAtt : sysInfoAtts) {
                imgUrls.add(sysInfoAtt.getFilePath());
            }
        }
        houInfoCollectedDTO.setHouImg(imgUrls);
        String[] daId = this.split(houLeaseInfo.getDistrict(), ",");
        houInfoCollectedDTO.setDistrictId(daId[0]);
        houInfoCollectedDTO.setAreaId(daId[1]);
        houInfoCollectedDTO.setId(houLeaseInfo.getId());
        houInfoCollectedDTO.setChId(usrHouCollection.getId());
        String[] areas = this.split(houLeaseInfo.getDistrictName(), " ");
        houInfoCollectedDTO.setDistrict(areas[0]);
        houInfoCollectedDTO.setArea(areas[1]);
        houInfoCollectedDTO.setDesc(houLeaseInfo.getTitle());
        String[] layouts = split(houLeaseInfo.getApartmentLayout(), ",");
        houInfoCollectedDTO.setLayoutRoom(layouts[0]);
        houInfoCollectedDTO.setLayoutHall(layouts[1]);
        houInfoCollectedDTO.setLayoutToilet(layouts[2]);
        houInfoCollectedDTO.setRentType(houLeaseInfo.getRentType());
        houInfoCollectedDTO.setPrice(houLeaseInfo.getRent());
        houInfoCollectedDTO.setLeaseMode(houLeaseInfo.getLeaseMode());
        return houInfoCollectedDTO;
    }

    private String[] split(String district,
                           String fix) {
        if (com.housecenter.dlfc.framework.common.util.StringUtils.isNotEmpty(district)
                && com.housecenter.dlfc.framework.common.util.StringUtils.isNotEmpty(fix)) {
            array = org.springframework.util.StringUtils.delimitedListToStringArray(district, fix);
            return array;
        }
        return null;
    }
}
