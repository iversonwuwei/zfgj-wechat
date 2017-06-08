package com.dlfc.zfw.wechat.registry.service;

import com.dlfc.zfw.wechat.registry.entity.UsrUser;

public interface UsrUserService<T> {

    UsrUser findUser(T t);
}
