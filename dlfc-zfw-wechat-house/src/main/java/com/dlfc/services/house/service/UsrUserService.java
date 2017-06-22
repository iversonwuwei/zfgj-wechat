package com.dlfc.services.house.service;

import com.dlfc.zfw.wechat.entities.entity.UsrUser;

/**
 * Created by walden on 17-6-15.
 */
public interface UsrUserService {

    UsrUser findById(String uid);
}
