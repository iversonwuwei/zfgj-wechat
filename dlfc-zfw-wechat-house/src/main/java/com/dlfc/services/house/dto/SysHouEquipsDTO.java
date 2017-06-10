package com.dlfc.services.house.dto;

import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SysHouEquipsDTO extends AbstractDTO {

    private String code;

    private String name;

    private String lid;
}
