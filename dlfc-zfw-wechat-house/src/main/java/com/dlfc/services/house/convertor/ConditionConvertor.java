package com.dlfc.services.house.convertor;

import com.dlfc.services.house.dto.HouLeaseInfoDTO;
import com.dlfc.services.house.dto.HouseConditionDTO;
import com.dlfc.services.house.enums.HouseReleaseStatusEnum;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import com.housecenter.dlfc.framework.common.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by K on 2017/6/2.
 */

@Component
public class ConditionConvertor extends AbstractConvertor<HouLeaseInfoDTO, HouseConditionDTO> {

    @Override
    public HouLeaseInfoDTO toModel(HouseConditionDTO conditionDTO) {
        HouLeaseInfoDTO dto = new HouLeaseInfoDTO();
        if (null != conditionDTO) {
            String orderBy = "FRESH_TIME DESC";
            if (StringUtils.isNotEmpty(conditionDTO.getOrderByPrice())) {
                if ("0".equals(conditionDTO.getOrderByPrice())) {
                    orderBy += ", RENT ASC";
                } else if ("1".equals(conditionDTO.getOrderByPrice())) {
                    orderBy += ", RENT DESC";
                }
            }
            dto.setOrderBy(orderBy);
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
            dto.setReleaseStatus(HouseReleaseStatusEnum.YES_ENUM.getValue());
            if (null != conditionDTO.getSurroundingFacilities()
                    && conditionDTO.getSurroundingFacilities().length > 0) {
                dto.setFacilityIdList(Arrays.asList(conditionDTO.getSurroundingFacilities()));
            }
        }
        return dto;
    }

    @Override
    public HouseConditionDTO toDTO(HouLeaseInfoDTO houLeaseInfoDTO, Object... strings) {
        return null;
    }
}
