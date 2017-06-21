package com.dlfc.services.contract.service;

import java.util.Date;

/**
 * Created by K on 6/20/17.
 */
public interface SystemPersonService {
    Integer getGenderFromIdNo(String idNo);

    Date getBirthdayFromIdNo(String idNo);
}
