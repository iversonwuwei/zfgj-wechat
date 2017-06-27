package com.dlfc.services.contract.service;

import com.dlfc.zfw.wechat.entities.entity.UsrUser;

/**
 * Created by K on 6/26/17.
 */
public interface SysInfoAttService {
    String saveSign(String lid, String path, int type, UsrUser user);
}
