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
     * 房源户型
     */
    private String layout;

    /**
     * 付款方式
     */
    private String rentType;

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
     * 楼层
     */
    private String floor;

    /**
     * 配套设施
     */
    private List<String> equips;

    /**
     * 房源描述
     */
    private String houseDesc;

    /**
     * 公交地铁
     */
    private List<String> vehicles;

    /**
     * 周边商业
     */
    private List<String> around;

    /**
     * 发布状态
     */
    private boolean published;

    private String requirement;

    private Integer houStatus;

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
     * 商圈
     */
    private String district;

    /**
     * 小区名称
     */
    private String villageName;
}
