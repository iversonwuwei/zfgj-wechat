package com.dlfc.services.contract.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by wangna on 2017/6/9.
 */
@Getter
@Setter
public class HouseUserChildrenDTO {

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String idNo;

    // 非页面输入项
    /**
     * 性别
     */
    private Integer gender;

    /**
     * 性别名
     */
    private String genderName;

    /**
     * 生日日期
     */
    private Date birthday;
}
