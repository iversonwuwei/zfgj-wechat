package com.dlfc.services.contract.dto;

import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by K on 6/26/17.
 */

@Getter
@Setter
public class OtherCostDTO extends AbstractDTO {

    /**
     * 项目
     */
    private String item;

    /**
     * 单位
     */
    private String unit;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 起计时间
     */
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startDate;

    /**
     * 起计底数
     */
    private String minQuantity;
}
