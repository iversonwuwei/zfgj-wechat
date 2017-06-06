package com.dlfc.services.validatecode.service.impl;

import com.dlfc.services.validatecode.entity.SysMobileCapcha;
import com.dlfc.services.validatecode.service.SysMobileCapchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by K on 2017/5/10.
 */

@Service
public class SysMobileCapchaServiceImpl implements SysMobileCapchaService {

    private SysMobileCapcha sysMobileCapcha;

    private List<SysMobileCapcha> sysMobileCapchaList;

    private int count;

    @Autowired
    private SysMobileCapchaMapper sysMobileCapchaMapper;

    /**
     * @param phone
     * @param domain
     * @return
     */
    @Override
    public boolean getCaptchaCountByMobile(String phone,
                                           String domain) {
        SysMobileCapchaExample example = new SysMobileCapchaExample();
        SysMobileCapchaExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(phone);
        criteria.andDomainEqualTo(domain);
        criteria.andCreateTimeGreaterThan(DateUtils.getStartDate(DateUtils.getSynchTime()));
        count = sysMobileCapchaMapper.countByExample(example);
        if (count >= 5) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param sysMobileCapcha
     * @return
     */
    @Override
    public SysMobileCapcha selectByVerCode(SysMobileCapcha sysMobileCapcha) {
        SysMobileCapchaExample example = new SysMobileCapchaExample();
        SysMobileCapchaExample.Criteria criteria = example.createCriteria();
        criteria.andVerCodeEqualTo(sysMobileCapcha.getVerCode());
        criteria.andMobileEqualTo(sysMobileCapcha.getMobile());
        criteria.andDomainEqualTo(sysMobileCapcha.getDomain());
        criteria.andDeviceIdEqualTo(sysMobileCapcha.getDeviceId());
        example.setOrderByClause("CREATE_TIME DESC");
        sysMobileCapchaList = sysMobileCapchaMapper.selectByExample(example);
        if (null != sysMobileCapchaList && sysMobileCapchaList.size() > 0) {
            return sysMobileCapchaList.get(0);
        }
        return null;
    }
}
