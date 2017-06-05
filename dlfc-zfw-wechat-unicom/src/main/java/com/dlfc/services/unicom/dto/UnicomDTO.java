package com.dlfc.services.unicom.dto;

import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UnicomDTO extends AbstractDTO {

    private List<String> imgUrls;

    private String areaUnique;

    private String desc;

    private String speed;

    private String price;

    private String provider;

    private Integer payers;

    private String promote;

    private Integer period;

    private String district;

    private String districtId;

    private String address;
}
