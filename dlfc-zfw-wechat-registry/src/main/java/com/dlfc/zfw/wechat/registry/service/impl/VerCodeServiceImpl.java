package com.dlfc.zfw.wechat.registry.service.impl;

import com.dlfc.admin.common.utils.DateUtils;
import com.dlfc.admin.common.utils.StringUtils;
import com.dlfc.zfw.wechat.registry.entity.SysMobileCapcha;
import com.dlfc.zfw.wechat.registry.entity.UsrUser;
import com.dlfc.zfw.wechat.registry.repository.RegistryRService;
import com.dlfc.zfw.wechat.registry.repository.ValidateRService;
import com.dlfc.zfw.wechat.registry.service.VerCodeService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class VerCodeServiceImpl implements VerCodeService<SysMobileCapcha> {

    private static final int TIME_LIMIT = 1800;

    private String result;
    private SysMobileCapcha entity;
    private List<SysMobileCapcha> entityList;

    @Autowired
    private ValidateRService validateRService;
    @Autowired
    private RegistryRService registryRService;
    @Autowired
    private IConvertor convertor;

    @Override
    public String validate(SysMobileCapcha sysMobileCapcha) {
        result = validateRService.validate(sysMobileCapcha);
        entityList = convertor.convert2Objects(result, SysMobileCapcha.class);
        if (null == entityList || entityList.size() == 0) {
            return "验证码错误";
        }
        entity = entityList.get(0);
        int seconds = DateUtils.getSecondBetweenDate(entity.getCreateTime(), new Date());
        if (seconds > TIME_LIMIT) {
            return "验证码已失效，请重新发送";
        }
        result = registryRService.findByMobile(sysMobileCapcha.getMobile());
        UsrUser user = (UsrUser) convertor.convert2Object(result, UsrUser.class);
        if (null != user && StringUtils.isNotEmpty(user.getId())) {
            return "手机号已被使用且通过身份认证！如有需要请联系客服！";
        }
        return null;
    }
}
