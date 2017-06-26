package com.dlfc.services.contract.convertor;

import com.dlfc.services.contract.dto.OtherCostDTO;
import com.dlfc.zfw.wechat.entities.entity.ConOtherCosts;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Controller;

import java.util.Date;

/**
 * Created by K on 6/26/17.
 */

@Controller
public class OtherCostConvertor extends AbstractConvertor<ConOtherCosts, OtherCostDTO> {

    @Override
    public ConOtherCosts toModel(OtherCostDTO dto) {
        ConOtherCosts model = new ConOtherCosts();
        if (null != dto) {
            model.setItem(dto.getItem());
            model.setUnit(dto.getUnit());
            model.setPrice(dto.getPrice());
            if (null != dto.getStartDate()) {
                model.setStime(dto.getStartDate().getTime());
            }
            model.setScount(dto.getMinQuantity());
        }
        return model;
    }

    @Override
    public OtherCostDTO toDTO(ConOtherCosts model, Object... objects) {
        OtherCostDTO dto = new OtherCostDTO();
        if (null != model) {
            dto.setId(model.getId());
            dto.setItem(model.getItem());
            dto.setUnit(model.getUnit());
            dto.setPrice(model.getPrice());
            if (null != model.getStime()) {
                dto.setStartDate(new Date(model.getStime()));
            }
            dto.setMinQuantity(model.getScount());
        }
        return dto;
    }
}
