package com.dlfc.services.house.dto;


import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysDescriptionDTO extends AbstractDTO {

    private String liveRequire;

    private String ddd;

    private String others;

    private String lid;
}
