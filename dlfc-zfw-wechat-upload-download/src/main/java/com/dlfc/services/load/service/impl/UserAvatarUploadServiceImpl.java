package com.dlfc.services.load.service.impl;

import com.dlfc.admin.common.utils.DateUtils;
import com.dlfc.admin.common.utils.PropertyUtils;
import com.dlfc.services.load.common.FileUtils;
import com.dlfc.services.load.service.ClassfyUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by K on 2017/6/9.
 */

@Service("UserAvatarUploadServiceImpl")
public class UserAvatarUploadServiceImpl implements ClassfyUploadService<MultipartFile> {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private File file;

    @Override
    public String upload(MultipartFile multipartFile) throws IOException {
        String realDir = PropertyUtils.getSysVal("upload.file.real.directory");
        String fix = "opr/" + DateUtils.getDate(DATE_FORMAT) + "/";
        realDir += fix;
        file = new File(realDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = FileUtils.generateFileName(multipartFile);
        file = new File(file.getAbsolutePath() + "/" + fileName);
        multipartFile.transferTo(file);
        return fix + fileName;
    }
}
