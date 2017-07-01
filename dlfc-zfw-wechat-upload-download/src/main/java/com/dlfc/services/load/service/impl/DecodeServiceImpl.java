package com.dlfc.services.load.service.impl;

import com.dlfc.admin.common.utils.StringUtils;
import com.dlfc.services.load.service.DecodeService;
import org.apache.commons.net.util.Base64;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by K on 7/1/17.
 */

@Service
public class DecodeServiceImpl implements DecodeService {

    private static final String PNG_IMAGE_TYPE = "data:image/png;base64";

    @Override
    public void decode(String filePath,
                       String fileCode) throws IOException {
        fileCode = fileCode.replace(PNG_IMAGE_TYPE, StringUtils.EMPTY);
        byte[] bytes = Base64.decodeBase64(fileCode);
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] < 0) {
                bytes[i] += 256;
            }
        }
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(filePath);
            os.write(bytes);
            os.flush();
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }
}
