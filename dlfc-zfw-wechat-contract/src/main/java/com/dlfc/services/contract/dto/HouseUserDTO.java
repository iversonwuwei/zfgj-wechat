package com.dlfc.services.contract.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by K on 6/19/17.
 */

@Getter
@Setter
public class HouseUserDTO {

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 证件类型
     */
    private Integer idType;

    /**
     * 证件号码
     */
    private String idNo;
}
