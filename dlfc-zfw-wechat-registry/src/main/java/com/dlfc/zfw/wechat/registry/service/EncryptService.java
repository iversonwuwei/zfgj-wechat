package com.dlfc.zfw.wechat.registry.service;

/**
 * Created by K on 2017/6/8.
 */
public interface EncryptService<T> {
    String generatePassword(T t);

    String generateUsername(T t);
}
