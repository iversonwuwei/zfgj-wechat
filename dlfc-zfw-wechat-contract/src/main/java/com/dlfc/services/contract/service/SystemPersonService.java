package com.dlfc.services.contract.service;

import com.dlfc.zfw.wechat.entities.entity.SysPerson;

import java.util.Date;

/**
 * Created by K on 6/20/17.
 */
public interface SystemPersonService {
    Integer getGenderFromIdNo(String idNo);

    Date getBirthdayFromIdNo(String idNo);

    SysPerson findByNameInfos(SysPerson sysPerson);

    boolean certification(String pid);
}
