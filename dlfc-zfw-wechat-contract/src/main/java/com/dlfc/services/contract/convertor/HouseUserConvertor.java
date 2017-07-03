package com.dlfc.services.contract.convertor;

import com.dlfc.services.contract.dto.HouseUserDTO;
import com.dlfc.zfw.wechat.entities.entity.ConHouseUser;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
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
            model.setIdType(dto.getIdType());
            model.setMobile(dto.getPhone());
        }
        return model;
    }

    @Override
    public HouseUserDTO toDTO(ConHouseUser model, Object... objects) {
        HouseUserDTO dto = new HouseUserDTO();
        if (null != model) {
            dto.setName(model.getName());
            dto.setIdType(model.getIdType());
            dto.setIdNo(model.getIdNo());
            dto.setPhone(model.getMobile());
        }
        return dto;
    }
}
