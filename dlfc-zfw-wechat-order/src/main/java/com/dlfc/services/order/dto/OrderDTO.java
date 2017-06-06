package com.dlfc.services.order.dto;


import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class OrderDTO extends AbstractDTO {

    private String orderCreateTime;

    private String paymentTime;

    private String prdDesc;

    private String contactName;

    private String phone;

    private String address;

    private String installTime;

    private String paymentWay;

    private BigDecimal price;

    private String installFee;

    private String promote;

    private BigDecimal amount;
}
