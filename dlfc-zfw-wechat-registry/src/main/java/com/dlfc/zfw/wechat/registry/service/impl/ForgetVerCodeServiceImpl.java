package com.dlfc.zfw.wechat.registry.service.impl;

import com.dlfc.admin.common.utils.DateUtils;
import com.dlfc.zfw.wechat.entities.entity.SysMobileCapcha;
import com.dlfc.zfw.wechat.registry.repository.ValidateRService;
import com.dlfc.zfw.wechat.registry.service.VerCodeService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service("forgetVerCodeServiceImpl")
public class ForgetVerCodeServiceImpl implements VerCodeService<SysMobileCapcha> {


    private static final int TIME_LIMIT = 1800;

    private List<SysMobileCapcha> result;
    private SysMobileCapcha entity;
    private List<SysMobileCapcha> entityList;

    @Autowired
    private ValidateRService validateRService;
    @Autowired
    private IConvertor convertor;

    @Override
    public String validate(SysMobileCapcha sysMobileCapcha) {
        result = validateRService.validate(sysMobileCapcha);
        entityList = result;
        if (null == entityList || entityList.size() == 0) {
            return "验证码错误";
        }
        entity = entityList.get(0);
        int seconds = DateUtils.getSecondBetweenDate(new Date(entity.getCreateTime()), new Date());
        if (seconds > TIME_LIMIT) {
            return "验证码已失效，请重新发送";
        }
        return null;
    }
}
