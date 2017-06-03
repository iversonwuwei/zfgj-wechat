package com.dlfc.services.house.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 为数据中心提供的数据源
 * Created by K on 2017/5/31.
 */

@Component
@Getter
@Setter
public class HouLeaseInfoDTO {

    /**
     * 排序结果（ORDER BY后面的参数）
     */
    private String orderBy;

    /**
     * 单页显示条数
     */
    private Integer pageSize;

    /**
     * 页码
     */
    private Integer pageNo;

    /**
     * 区域ID或者商圈ID
     */
    private String districtId;

    /**
     * 价格最小值
     */
    private Integer minRent;

    /**
     * 价格最大值
     */
    private Integer maxRent;

    /**
     * 来源==>1：经纪人，0：个人
     */
    private String source;

    /**
     * 出租方式
     */
    private Integer rentMode;

    /**
     * 房屋朝向
     */
    private String orientation;

    /**
     * 付款方式
     */
    private String paymentStyle;

    /**
     * 周边设施
     */
    private List<String> facilityIdList;
}
