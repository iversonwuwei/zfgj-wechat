package com.dlfc.services.auth.service;

import com.dlfc.zfw.wechat.entities.entity.UsrUser;

/**
 * Created by walden on 17-7-3.
 */
public interface UsrUserService {

    UsrUser findById(String uid);

    UsrUser findByMobile(String mobile);
}
