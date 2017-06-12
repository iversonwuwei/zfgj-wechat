package com.dlfc.services.house.dto;

import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysSurFaciesDTO extends AbstractDTO{

    private String code;

    private String name;

    private String lid;

    private String others;
}
