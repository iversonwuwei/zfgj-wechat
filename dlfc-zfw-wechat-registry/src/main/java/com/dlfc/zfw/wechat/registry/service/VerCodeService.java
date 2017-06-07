package com.dlfc.zfw.wechat.registry.service;

import com.dlfc.zfw.wechat.registry.dto.UserDTO;

public interface VerCodeService<T> {

    Object registry(T t);
}
