package com.dlfc.services.validatecode.service;


import com.dlfc.services.validatecode.entity.SysMobileCapcha;

/**
 * Created by K on 2017/5/10.
 */
public interface SysMobileCapchaService {

    boolean getCaptchaCountByMobile(String phone, String domain);

    SysMobileCapcha selectByVerCode(SysMobileCapcha sysMobileCapcha);
}
