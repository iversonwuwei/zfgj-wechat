package com.dlfc.services.load.dto;

import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by K on 6/26/17.
 */

@Getter
@Setter
public class HouseItemDTO extends AbstractDTO {

    /**
     * 名称
     */
    private String name;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 损赔金额
     */
    private BigDecimal compensation;
}
