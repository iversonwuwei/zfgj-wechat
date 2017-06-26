package com.dlfc.services.contract.service.impl;

import com.dlfc.services.contract.repository.SystemRService;
import com.dlfc.zfw.wechat.entities.entity.SysPerson;
import com.housecenter.dlfc.framework.common.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dlfc.services.contract.service.SystemPersonService;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by K on 6/20/17.
 */

@Service
@Slf4j
public class SystemPersonServiceImpl implements SystemPersonService {

    private static final String DATE_FORMAT = "yyyyMMdd";

    @Autowired
    private SystemRService systemRService;

    @Override
    public Integer getGenderFromIdNo(String idNo) {
        if (!checkIdNo(idNo)) {
            return null;
        }
        int i = Integer.parseInt(idNo.substring(16, 17));
        return i % 2;
    }

    @Override
    public Date getBirthdayFromIdNo(String idNo) {
        if (!checkIdNo(idNo)) {
            return null;
        }
        Date birthday = null;
        try {
            birthday = DateUtils.parseDate(idNo.substring(6, 14), DATE_FORMAT);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
        return birthday;
    }

    @Override
    public SysPerson findByNameInfos(SysPerson sysPerson) {
        return systemRService.findSysPersonByNameInfos(sysPerson);
    }

    private boolean checkIdNo(String idNo) {
        if (18 != idNo.length()) {
            return false;
        }
        return true;
    }
}
