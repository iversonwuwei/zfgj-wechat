package com.dlfc.services.validate.dto;

import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by walden on 17-6-21.
 */
@Getter
@Setter
public class ValidateResultDTO extends AbstractDTO {

    private String pid;

    private String username;

    private String phone;

    private String email;

    private String agtCert;
}
