package com.dlfc.services.search.dto;

import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
public class UserDTO extends AbstractDTO {

    /**
     * 头像地址
     */
    private String imgUrl;

    /**
     * 用户ID
     */
    private String uid;

    /**
     * 电话号码
     */
    @Min(value = 11, message = "請填寫正確的電話號碼！")
    @Max(value = 11, message = "請填寫正確的電話號碼！")
    private String phoneNumber;

    /**
     * 经纪人认证状态
     */
    private String certified;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 证件类型
     */
    private Integer idNoType;

    /**
     * 证件号码
     */
    private String idNo;

    /**
     * 邮箱
     */
    private String email;
}
