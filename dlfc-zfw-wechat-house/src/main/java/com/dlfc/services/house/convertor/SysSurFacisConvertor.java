package com.dlfc.services.house.convertor;

import com.dlfc.services.house.dto.HouseDTO;
import com.dlfc.services.house.entity.SysSurFacis;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;

import java.util.List;

/**
 * Created by K on 2017/6/3.
 */
public class SysSurFacisConvertor extends AbstractConvertor<SysSurFacis, HouseDTO> {
    @Override
    public SysSurFacis toModel(HouseDTO dto) {
        SysSurFacis model = new SysSurFacis();
        if (null != dto) {
            model.setLid(dto.getId());
            model.setFacilityIds(generate(dto.getAround()));
        }
        return model;
    }

    @Override
    public HouseDTO toDTO(SysSurFacis sysSurFacis, String... strings) {
        return null;
    }

    private String generate(List<String> around) {
        if (null != around && around.size() > 0) {
            StringBuffer buffer = new StringBuffer();
            for (String str : around) {
                buffer.append(str);
                buffer.append(",");
            }
            buffer.deleteCharAt(buffer.length() - 1);
            return buffer.toString();
        }
        return null;
    }
}
