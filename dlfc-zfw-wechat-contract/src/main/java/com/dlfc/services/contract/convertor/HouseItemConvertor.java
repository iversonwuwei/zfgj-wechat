package com.dlfc.services.contract.convertor;

import com.dlfc.services.contract.dto.HouseItemDTO;
import com.dlfc.zfw.wechat.entities.entity.ConHouseItems;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Component;

/**
 * Created by K on 6/26/17.
 */

@Component
public class HouseItemConvertor extends AbstractConvertor<ConHouseItems, HouseItemDTO> {
    @Override
    public ConHouseItems toModel(HouseItemDTO dto) {
        ConHouseItems model = new ConHouseItems();
        if (null != dto) {
            model.setId(dto.getId());
            model.setItem(dto.getName());
            model.setBrand(dto.getBrand());
            model.setNum(dto.getQuantity());
            model.setPrice(dto.getPrice());
            model.setCompenAmount(dto.getCompensation());
        }
        return model;
    }

    @Override
    public HouseItemDTO toDTO(ConHouseItems model, Object... objects) {
        HouseItemDTO dto = new HouseItemDTO();
        if (null != model) {
            dto.setId(model.getId());
            dto.setName(model.getItem());
            dto.setBrand(model.getBrand());
            dto.setQuantity(model.getNum());
            dto.setPrice(model.getPrice());
            dto.setCompensation(model.getCompenAmount());
        }
        return dto;
    }
}
