package com.dlfc.services.contract.convertor;

import com.dlfc.services.contract.dto.HouseUserDTO;
import entity.ConHouseUser;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by K on 6/19/17.
 */

@Component
public class HouseUserConvertor extends AbstractConvertor<ConHouseUser, HouseUserDTO> {
    @Override
    public ConHouseUser toModel(HouseUserDTO dto) {
        ConHouseUser model = new ConHouseUser();
        if (null != model) {
            model.setName(dto.getName());
            model.setIdNo(dto.getIdNo());
            if (StringUtils.isNotEmpty(dto.getIdType())) {
                model.setIdType(Integer.valueOf(dto.getIdType()));
            }
            model.setMobile(dto.getPhone());
        }
        return model;
    }

    @Override
    public HouseUserDTO toDTO(ConHouseUser conHouseUser, Object... objects) {
        return null;
    }
}
