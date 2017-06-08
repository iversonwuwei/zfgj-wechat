package com.dlfc.zfw.wechat.registry.service.impl;

import com.dlfc.admin.common.security.Digests;
import com.dlfc.admin.common.utils.Encodes;
import com.dlfc.zfw.wechat.registry.service.EncryptService;

/**
 * Created by K on 2017/6/8.
 */
public class EncryptServiceImpl implements EncryptService<String> {

    public static final int HASH_INTERATIONS = 1024;
    public static final int SALT_SIZE = 8;

    @Override
    public String generatePassword(String password) {
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        byte[] hashPassword = Digests.sha1(password.getBytes(), salt, HASH_INTERATIONS);
        return Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
    }

    @Override
    public String generateUsername(String mobile) {
        mobile += "_";
        for (int i = 0; i < 3; i++) {
            mobile += (char) (Math.random() * 26 + 'A');
        }
        return mobile;
    }
}
