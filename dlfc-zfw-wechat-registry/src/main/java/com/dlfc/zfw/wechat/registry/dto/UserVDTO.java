package com.dlfc.zfw.wechat.registry.dto;


import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserVDTO extends AbstractDTO {

    @NotNull(message = "手机号码不能为空")
    @Length(max = 11, min = 11, message = "手机号位数不正确")
    private String mobile;

    @NotNull(message = "密码不能为空")
    @Length(max = 18, min = 8, message = "密码限8-18位")
    private String password;

    @NotNull(message = "验证码不能为空")
    private String verCode;

    private String deviceId;
}
