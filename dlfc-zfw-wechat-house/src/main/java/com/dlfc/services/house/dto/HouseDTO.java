package com.dlfc.services.house.dto;

import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class HouseDTO extends AbstractDTO {

    /**
     * 房屋图片
     */
    private List<String> houImg;

    /**
     * 房源标题
     */
    private String desc;

    /**
     * 房源户型（室）
     */
    private String layoutRoom;

    /**
     * 房源户型（厅）
     */
    private String layoutHall;

    /**
     * 房源户型（卫）
     */
    private String layoutToilet;

    /**
     * 付款方式（押）
     */
    private String depositType;

    /**
     * 付款方式（付）
     */
    private String paymentType;

    /**
     * 主卧等（上哪去拿？？？）
     */
    private String leaseRoom;

    /**
     * 出租方式
     */
    private Integer leaseMode;

    /**
     * 租金
     */
    private BigDecimal price;

    /**
     * 是否被用户收藏
     */
    private boolean collected;

    /**
     * 上次刷新时间
     */
    private Date refreshTime;

    /**
     * 出租面积
     */
    private BigDecimal houseArea;

    /**
     * 朝向
     */
    private String orientation;

    /**
     * 总楼层
     */
    private String sumFloor;

    /**
     * 住楼层
     */
    private String liveFloor;

    /**
     * 配套设施
     */
    private List<String> equips;

    /**
     * 公交地铁
     */
    private List<String> vehicles;

    /**
     * 公交地铁其它
     */
    private String otherVehicles;

    /**
     * 周边商业
     */
    private List<String> around;

    /**
     * 发布状态
     */
    private Integer houStatus;

    /**
     * 审核状态
     */
    private Integer auditStatus;

    /**
     * 期限要求
     */
    private String TermRequirement;

    /**
     * 租住限制
     */
    private String liveRequirement;

    /**
     * 房主承担费用
     */
    private String ownerBears;

    /**
     * 其他描述
     */
    private String otherDcpt;

    /**
     * 商圈（区）
     */
    private String districtArea;

    /**
     * 商圈名区）
     */
    private String districtAreaName;

    /**
     * 商圈（商圈）
     */
    private String districtTrade;

    /**
     * 商圈名（商圈）
     */
    private String districtTradeName;

    /**
     * 小区名称
     */
    private String villageName;

    /**
     * 用户ID
     */
    private String uid;
}
