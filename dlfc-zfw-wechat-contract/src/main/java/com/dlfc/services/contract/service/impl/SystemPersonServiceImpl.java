package com.dlfc.services.contract.service.impl;

import com.dlfc.admin.common.utils.StringUtils;
import com.dlfc.services.contract.enums.PersonIdTypeEnum;
import com.dlfc.services.contract.repository.SystemRService;
import com.dlfc.services.contract.service.SystemPersonService;
import com.dlfc.zfw.wechat.entities.entity.SysPerson;
import com.housecenter.dlfc.framework.common.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by K on 6/20/17.
 */

@Service
@Transactional
@Slf4j
@Qualifier(value = "systemPersonServiceImpl")
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

    @Override
    public boolean certification(String pid) {
        if(StringUtils.isNotEmpty(pid)){
            SysPerson sysPerson = systemRService.findById(pid);
            if (null != sysPerson && sysPerson.getIdType() == PersonIdTypeEnum.ID_CARD_ENUM.getValue()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIdNo(String idNo) {
        if (18 != idNo.length()) {
            return false;
        }
        return true;
    }
}
