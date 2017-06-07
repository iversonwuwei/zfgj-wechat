package com.dlfc.zfw.wechat.registry.dto;


import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends AbstractDTO {

    private String mobile;

    private String token;
}
