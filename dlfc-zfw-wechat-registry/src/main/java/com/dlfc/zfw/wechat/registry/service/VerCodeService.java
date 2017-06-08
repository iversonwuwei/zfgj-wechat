package com.dlfc.zfw.wechat.registry.service;

public interface VerCodeService<T> {

    String validate(T t);
}
