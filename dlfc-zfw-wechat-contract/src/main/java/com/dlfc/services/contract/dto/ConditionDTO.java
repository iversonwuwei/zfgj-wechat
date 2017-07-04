package com.dlfc.services.contract.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by K on 7/3/17.
 */

@Getter
@Setter
public class ConditionDTO {

    private String pid;

    private Short[] statusIn;

    private Integer[] sourceIn;
}
