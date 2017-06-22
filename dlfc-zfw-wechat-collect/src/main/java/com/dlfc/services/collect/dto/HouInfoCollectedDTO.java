package com.dlfc.services.collect.dto;

import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
public class HouInfoCollectedDTO extends AbstractDTO {

    private String chId;

    private List<String> houImg;

    private String desc;

    private String districtId;

    private String district;

    private String areaId;

    private String area;

    private String layoutRoom;

    private String layoutHall;

    private String layoutToilet;

    private String rentType;

    private Integer leaseMode;

    private BigDecimal price;
}
