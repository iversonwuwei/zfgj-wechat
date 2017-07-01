package com.dlfc.services.load.service.impl;

import com.dlfc.admin.common.utils.DateUtils;
import com.dlfc.admin.common.utils.PropertyUtils;
import com.dlfc.services.load.common.FileUtils;
import com.dlfc.services.load.service.ClassfyUploadService;
import com.dlfc.services.load.service.DecodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Created by K on 6/26/17.
 */

@Service("ContractSignUploadServiceImpl")
public class ContractSignUploadServiceImpl implements ClassfyUploadService<String> {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private File file;

    @Autowired
    private DecodeService decodeService;

    @Override
    public String upload(String fileCode) throws IOException {
        String realDir = PropertyUtils.getSysVal("upload.file.real.directory");
        String fix = "sign/" + DateUtils.getDate(DATE_FORMAT) + "/";
        realDir += fix;
        file = new File(realDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = FileUtils.generateUUID() + ".PNG";
        file = new File(file.getAbsolutePath() + "/" + fileName);
        decodeService.decode(file.getAbsolutePath(), fileCode);
        return fix + fileName;
    }
}
