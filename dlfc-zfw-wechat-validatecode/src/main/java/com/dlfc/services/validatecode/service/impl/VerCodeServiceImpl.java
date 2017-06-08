package com.dlfc.services.validatecode.service.impl;

import com.dlfc.services.validatecode.common.FileUtils;
import com.dlfc.services.validatecode.entity.SysMobileCapcha;
import com.dlfc.services.validatecode.enums.MsgEnums;
import com.dlfc.services.validatecode.enums.TemplateNoEnum;
import com.dlfc.services.validatecode.repository.MobileRService;
import com.dlfc.services.validatecode.service.VerCodeService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import com.housecenter.dlfc.framework.sms.SMSFacet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by K on 2017/6/7.
 */
@Transactional
@Service
public class VerCodeServiceImpl implements VerCodeService {

    private String result;
    private List<SysMobileCapcha> entityList;

    @Autowired
    private MobileRService mobileRService;
    @Autowired
    private IConvertor convertor;

    @Override
    public boolean checkCount(String phone,
                              String domain) {
        result = mobileRService.findSysMobileCapchaByMobileAndDomain(phone, domain);
        entityList = convertor.convert2Objects(result, SysMobileCapcha.class);
        if (null != entityList && entityList.size() > 5) {
            return false;
        }
        return true;
    }

    @Override
    public String send(String phone,
                       String domain) {
        String id = null;
        if (MsgEnums.REGESIT.getValue().equals(domain)) {
            id = SMSFacet.sendCapcha(phone, FileUtils.generateUUID(), null, TemplateNoEnum.REGESIT_NO.getValue(), domain);
        } else if (MsgEnums.FINDPWDCHECKPHONE.getValue().equals(domain)) {
            id = SMSFacet.sendCapcha(phone, FileUtils.generateUUID(), null, TemplateNoEnum.FINDPWDCHECKPHONE_NO.getValue(),
                    domain);
        } else if (MsgEnums.FINDPWDCHECKBANKPHONE.getValue().equals(domain)) {
            id = SMSFacet.sendCapcha(phone, FileUtils.generateUUID(), null, TemplateNoEnum.FINDPWDCHECKBANKPHONE_NO.getValue(),
                    domain);
        } else if (MsgEnums.SETAPPLYPWD.getValue().equals(domain)) {
            id = SMSFacet.sendCapcha(phone, FileUtils.generateUUID(), null, TemplateNoEnum.SETAPPLYPWD_NO.getValue(), domain);
        } else if (MsgEnums.FINDAPPLYPWD.getValue().equals(domain)) {
            id = SMSFacet.sendCapcha(phone, FileUtils.generateUUID(), null, TemplateNoEnum.FINDAPPLYPWD_NO.getValue(), domain);
        } else if (MsgEnums.REPLACEPHONETOOLD.getValue().equals(domain)) {
            id = SMSFacet.sendCapcha(phone, FileUtils.generateUUID(), null, TemplateNoEnum.REPLACEPHONETOOLD_NO.getValue(),
                    domain);
        } else if (MsgEnums.REPLACEPHONETONEW.getValue().equals(domain)) {
            id = SMSFacet.sendCapcha(phone, FileUtils.generateUUID(), null, TemplateNoEnum.REPLACEPHONETONEW_NO.getValue(),
                    domain);
        } else if (MsgEnums.BINDBANKPHONE.getValue().equals(domain)) {
            id = SMSFacet.sendCapcha(phone, FileUtils.generateUUID(), null, TemplateNoEnum.BINDBANKPHONE_NO.getValue(), domain);
        }
        return id;
    }
}
