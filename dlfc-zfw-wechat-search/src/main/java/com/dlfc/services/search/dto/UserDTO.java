package com.dlfc.services.search.dto;

import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
public class UserDTO extends AbstractDTO {

    private String avatar;

    private String imgUrl;

    private String uid;

    @Min(value = 11, message = "請填寫正確的電話號碼！")
    @Max(value = 11, message = "請填寫正確的電話號碼！")
    private String phoneNumber;

    private boolean certified;
}
