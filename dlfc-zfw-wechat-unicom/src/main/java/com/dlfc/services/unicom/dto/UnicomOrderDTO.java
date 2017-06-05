package com.dlfc.services.unicom.dto;


import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class UnicomOrderDTO extends AbstractDTO {

    private String address;

    private Date installDate;

    private String contactPerson;

    private String phoneNumber;

    private String wayToPay;

    private BigDecimal productAmount;

    private BigDecimal installAmount;

    private BigDecimal promoteAmount;

    private BigDecimal amount;
}
