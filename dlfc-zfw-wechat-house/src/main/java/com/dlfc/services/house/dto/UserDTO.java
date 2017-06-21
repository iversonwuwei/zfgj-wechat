package com.dlfc.services.house.dto;


import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends AbstractDTO{
    private String pid;

    private String username;

    private String phone;

    private String email;

    private String agtCert;
}
