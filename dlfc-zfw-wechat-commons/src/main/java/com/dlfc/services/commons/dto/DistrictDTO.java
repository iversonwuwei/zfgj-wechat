package com.dlfc.services.commons.dto;


import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class DistrictDTO extends AbstractDTO {

    @Length(max = 50)
    private String dCode;

    @Length(max = 10)
    private String dName;
}
