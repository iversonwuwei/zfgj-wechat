package com.dlfc.services.commons.dto;

import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by K on 2017/6/2.
 */

@Getter
@Setter
public class CodeNameDTO extends AbstractDTO {

    private String code;

    private String name;
}
