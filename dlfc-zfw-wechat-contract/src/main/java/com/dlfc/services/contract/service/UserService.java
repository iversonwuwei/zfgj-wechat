package com.dlfc.services.contract.service;

import com.dlfc.zfw.wechat.entities.entity.UsrUser;

/**
 * Created by K on 6/20/17.
 */
public interface UserService {
    UsrUser findUser(String id);
}
