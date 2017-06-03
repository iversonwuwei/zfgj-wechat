package com.dlfc.services.house.convertor;

import com.dlfc.services.house.dto.HouLeaseInfoDTO;
import com.dlfc.services.house.dto.HouseConditionDTO;
import com.dlfc.services.house.entity.SysSurFacis;
import com.dlfc.services.house.service.SysSurFaciService;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import com.housecenter.dlfc.framework.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by K on 2017/6/2.
 */

@Component
public class ConditionConvertor extends AbstractConvertor<HouLeaseInfoDTO, HouseConditionDTO> {

    @Autowired
    private SysSurFaciService sysSurFaciService;

    @Override
    public HouLeaseInfoDTO toModel(HouseConditionDTO conditionDTO) {
        HouLeaseInfoDTO dto = new HouLeaseInfoDTO();
        if (null != conditionDTO) {
            if (StringUtils.isNotEmpty(conditionDTO.getOrderByPrice())) {
                if ("0".equals(conditionDTO.getOrderByPrice())) {
                    dto.setOrderBy("RENT ASC");
                } else if ("1".equals(conditionDTO.getOrderByPrice())) {
                    dto.setOrderBy("RENT DESC");
                }
            }
            dto.setPageSize(conditionDTO.getPageSize());
            dto.setPageNo(conditionDTO.getPageNo());
            dto.setDistrictId(conditionDTO.getDistrictId());
            if (StringUtils.isNotEmpty(conditionDTO.getPriceRange())) {
                int i = Integer.valueOf(conditionDTO.getPriceRange());
                if (6 == i) {
                    dto.setMaxRent(null);
                    dto.setMinRent(2500);
                } else if (0 < i && 6 > i) {
                    dto.setMaxRent(i * 500);
                    dto.setMinRent((i - 1) * 500);
                }
            }
            dto.setSource(conditionDTO.getSource());
            dto.setRentMode(conditionDTO.getRentMode());
            dto.setOrientation(conditionDTO.getOrientation());
            dto.setPaymentStyle(conditionDTO.getPaymentStyle());
            List<String> idList = new ArrayList<>();
            if (null != conditionDTO.getSurroundingFacilities() && conditionDTO.getSurroundingFacilities().length > 0) {
                List<SysSurFacis> facilitiesList =
                        sysSurFaciService.findByFacilityIds(Arrays.asList(conditionDTO.getSurroundingFacilities()));
                for (SysSurFacis item : facilitiesList) {
                    idList.add(item.getId());
                }
            }
            dto.setFacilityIdList(idList);
        }
        return dto;
    }

    @Override
    public HouseConditionDTO toDTO(HouLeaseInfoDTO houLeaseInfoDTO, String... strings) {
        return null;
    }
}
