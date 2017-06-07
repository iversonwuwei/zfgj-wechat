package com.dlfc.zfw.wechat.registry.dto;


import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserVDTO extends AbstractDTO{

    @Length(max = 11, min = 11,message = "用户名过长")
    private String username;

    @Length(max = 50, min = 5)
    private String password;

    private String verCode;

    private String deviceId;
}
