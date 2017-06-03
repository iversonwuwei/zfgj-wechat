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

    private List<String> houImg;

    private String desc;

    private String layout;

    private String rentType;

    private String leaseRoom;

    private Integer leaseMode;

    private BigDecimal price;

    private boolean collected;

    private Date refreshTime;

    private BigDecimal houseArea;

    private String orientation;

    private String floor;

    private List<String> equips;

    private String houseDesc;

    private List<String> vehicles;

    private List<String> around;

    private boolean published;

    private String requirement;

    private Integer houStatus;

    private Integer auditStatus;
}
