package com.dlfc.services.collect.convertor;

import com.dlfc.services.collect.controller.HouInfoCollectedController;
import com.dlfc.services.collect.dto.HouInfoCollectedDTO;
import com.dlfc.services.collect.entity.HouLeaseInfo;
import com.dlfc.services.collect.entity.SysInfoAtt;
import com.dlfc.services.collect.entity.UsrHouCollection;
import com.dlfc.services.collect.service.HouCollectionService;
import com.dlfc.services.collect.service.HouseLeaseInfoService;
import com.dlfc.services.collect.service.SysInfoAttService;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import com.netflix.discovery.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


@Component
public class HouInfoColletedConvertor extends AbstractConvertor<UsrHouCollection, HouInfoCollectedDTO> {

    @Autowired
    private HouseLeaseInfoService houseLeaseInfoService;

    @Autowired
    private SysInfoAttService sysInfoAttService;

    @Autowired
    private HouCollectionService houCollectionService;


    @Override
    public UsrHouCollection toModel(HouInfoCollectedDTO houInfoCollectedDTO) {
        return null;
    }

    @Override
    public HouInfoCollectedDTO toDTO(UsrHouCollection usrHouCollection, boolean b) {
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
        String[] strings = this.splite(houLeaseInfo.getDistrict(), ",");
        houInfoCollectedDTO.setDistrictId(strings[0]);
        houInfoCollectedDTO.setAreaId(strings[1]);
        houInfoCollectedDTO.setId(houLeaseInfo.getId());
        String[] areas = this.splite(houLeaseInfo.getDistrictName(), " ");
        houInfoCollectedDTO.setDistrict(areas[0]);
        houInfoCollectedDTO.setArea(areas[1]);
        houInfoCollectedDTO.setDesc(houLeaseInfo.getTitle());
        String[] layouts = splite(houLeaseInfo.getApartmentLayout(), ",");
        houInfoCollectedDTO.setLayout(layouts[0]+'室'+layouts[1]+'厅');
        houInfoCollectedDTO.setRentType(houLeaseInfo.getRentType());
        houInfoCollectedDTO.setLeaseRoom(houLeaseInfo.getRoom());
        houInfoCollectedDTO.setPrice(houLeaseInfo.getRent());
        houInfoCollectedDTO.setCollected(houCollectionService.collected("0bd68f142f324be59697e14f1e630205", houLeaseInfo.getHid()));
        return houInfoCollectedDTO;
    }


    private String[] splite(String str, String spliteToken){
        String[] strings = StringUtils.delimitedListToStringArray(str, spliteToken);

        return strings;
    }
}
