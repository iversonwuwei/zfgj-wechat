package com.dlfc.services.auth.dto;

import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by walden on 17-6-30.
 */
@Getter
@Setter
public class CreditAuthDTO extends AbstractDTO {

    @NotNull(message = "姓名不能为空")
    @NotEmpty(message = "姓名不能为空")
    private String name;

    private String type = "1";

    @NotNull(message = "身份证不能为空")
    @NotEmpty(message = "身份证不能为空")
    private String idCard;

    @NotNull(message = "预留手机不能为空")
    @NotEmpty(message = "预留手机不能为空")
    private String bankMobile;

    @NotNull(message = "银行卡不能为空")
    @NotEmpty(message = "银行卡不能为空")
    private String bankNum;
}
