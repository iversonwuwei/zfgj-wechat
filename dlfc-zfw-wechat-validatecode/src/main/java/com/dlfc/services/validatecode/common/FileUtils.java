package com.dlfc.services.validatecode.common;


import org.apache.commons.lang.StringUtils;

import java.util.UUID;

/**
 * Created by K on 2017/6/8.
 */
public class FileUtils {

    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", StringUtils.EMPTY);
    }
}
