package com.dlfc.services.contract.convertor;

import com.dlfc.services.contract.dto.HouseUserChildrenDTO;
import com.dlfc.services.contract.service.SystemPersonService;
import com.dlfc.zfw.wechat.entities.entity.ConHouseUserChildren;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by K on 6/20/17.
 */

@Component
public class HouseUserChildrenConvertor extends AbstractConvertor<ConHouseUserChildren, HouseUserChildrenDTO> {

    @Autowired
    private SystemPersonService systemPersonService;

    @Override
    public ConHouseUserChildren toModel(HouseUserChildrenDTO dto) {
        ConHouseUserChildren model = new ConHouseUserChildren();
        if (null != dto) {
            model.setName(dto.getName());
            model.setIdNo(dto.getIdNo());
            model.setGender(systemPersonService.getGenderFromIdNo(dto.getIdNo()));
            Date birthday = systemPersonService.getBirthdayFromIdNo(dto.getIdNo());
            if (null != birthday) {
                model.setBirthday(birthday.getTime());
            }
        }
        return model;
    }

    @Override
    public HouseUserChildrenDTO toDTO(ConHouseUserChildren model, Object... objects) {
        HouseUserChildrenDTO dto = new HouseUserChildrenDTO();
        if (null != model) {
            dto.setName(model.getName());
            dto.setIdNo(model.getIdNo());
            dto.setGender(model.getGender());
            dto.setBirthday(new Date(model.getBirthday()));
        }
        return dto;
    }
}
