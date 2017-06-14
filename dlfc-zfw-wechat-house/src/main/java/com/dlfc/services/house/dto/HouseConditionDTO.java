package com.dlfc.services.house.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * 从页面获取的数据源
 * Created by K on 2017/5/31.
 */

@Component
@Getter
@Setter
public class HouseConditionDTO {

    /**
     * 区域ID或者商圈ID（空：全大连）
     */
    private String districtId;

    /**
     * 价格区间枚举key
     */
    private String priceRange;

    /**
     * 价格排序==>0：从小到大，1：从大到小
     */
    private String orderByPrice;

    /**
     * 来源==>1：经纪人，0：个人，空：不限
     */
    private String source;

    /**
     * 出租方式枚举key
     */
    private Integer rentMode;

    /**
     * 房屋朝向枚举key
     */
    private String orientation;

    /**
     * 付款方式
     */
    private String paymentStyle;

    /**
     * 周边设施
     */
    private String[] surroundingFacilities;

    /**
     * 单页显示条数
     */
    private Integer pageSize = 10;

    /**
     * 页码
     */
    private Integer pageNo = 1;
}
