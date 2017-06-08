package com.dlfc.services.validatecode.service;

/**
 * Created by K on 2017/6/7.
 */
public interface VerCodeService {
    boolean checkCount(String phone, String domain);

    String send(String phone, String domain);
}
