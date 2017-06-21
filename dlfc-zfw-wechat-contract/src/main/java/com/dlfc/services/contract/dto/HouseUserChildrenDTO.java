package com.dlfc.services.contract.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

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

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 生日日期
     */
    private Date birthday;
}
