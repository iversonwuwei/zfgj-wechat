package com.dlfc.services.date.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by K on 6/20/17.
 */

@Getter
@Setter
public class ContractEndDateDTO {

    private Date startDate;

    private Integer years;

    private Integer months;
}
