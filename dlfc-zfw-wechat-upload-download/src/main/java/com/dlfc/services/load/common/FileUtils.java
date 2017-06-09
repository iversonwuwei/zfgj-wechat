package com.dlfc.services.load.common;


import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * Created by K on 2017/6/8.
 */
public class FileUtils {

    private static String fileRealName;

    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", StringUtils.EMPTY);
    }

    public static String getExt(MultipartFile file) {
        if (null != file) {
            fileRealName = file.getOriginalFilename();
            return fileRealName.substring(fileRealName.lastIndexOf(".")).toLowerCase();
        }
        return null;
    }

    public static String generateFileName(MultipartFile file) {
        return generateUUID() + getExt(file);
    }
}
