package com.dlfc.services.order.dto;


import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderListDTO extends AbstractDTO {

    private String imgURL;

    private String desc;

    private String speed;

    private BigDecimal price;

    private String status;

    private BigDecimal amount;
}
