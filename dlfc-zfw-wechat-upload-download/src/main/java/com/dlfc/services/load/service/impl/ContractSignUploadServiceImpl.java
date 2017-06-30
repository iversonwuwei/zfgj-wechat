package com.dlfc.services.load.service.impl;

import com.dlfc.admin.common.utils.DateUtils;
import com.dlfc.admin.common.utils.PropertyUtils;
import com.dlfc.services.load.common.FileUtils;
import com.dlfc.services.load.service.ClassfyUploadService;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.*;

/**
 * Created by K on 6/26/17.
 */

@Service("ContractSignUploadServiceImpl")
public class ContractSignUploadServiceImpl implements ClassfyUploadService<String> {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private File file;

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
//        file = new File("/home/K/Downloads/test.PNG");
        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes = decoder.decodeBuffer(fileCode);
        for (int i = 0; i < bytes.length; ++i) {
            if (bytes[i] < 0) {// 调整异常数据
                bytes[i] += 256;
            }
        }
        bos.write(bytes);
        bos.flush();
        bos.close();
        return fix + fileName;
    }
}
