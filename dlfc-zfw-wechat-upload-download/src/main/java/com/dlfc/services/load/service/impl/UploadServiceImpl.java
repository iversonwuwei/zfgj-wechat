package com.dlfc.services.load.service.impl;

import com.dlfc.admin.common.utils.DateUtils;
import com.dlfc.admin.common.utils.PropertyUtils;
import com.dlfc.admin.common.utils.StringUtils;
import com.dlfc.services.load.common.FileUtils;
import com.dlfc.services.load.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by K on 2017/6/8.
 */

@Service
public class UploadServiceImpl implements UploadService<MultipartFile> {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private File file;

    @Override
    public String validate(MultipartFile file) {
        if (null != file && file.getSize() > 0) {
            // 上传文件大小限制
            long maxSize = StringUtils.toLong(PropertyUtils.getSysVal("upload.file.max.size"));
            // 文件大小不合法
            if (file.getSize() > maxSize) {
                return PropertyUtils.getErrorMsg("SYS-0113", new Object[]{maxSize / 1048576});
            }
            // 上传文件扩展名限制
            String extAllowed = PropertyUtils.getSysVal("upload.file.ext.allowed");
            String[] extAllowedArray = extAllowed.split(",");
            // 获得文件后缀名
            String ext = FileUtils.getExt(file);
            boolean extFlag = false;
            for (String str : extAllowedArray) {
                if (str.equals(ext)) {
                    extFlag = true;
                    break;
                }
            }
            //文件后缀名不合法
            if (!extFlag) {
                String str = extAllowed.replace(",.", "/");
                return PropertyUtils.getErrorMsg("SYS-0114", new Object[]{str.substring(1, str.length())});
            }
        } else {
            // 文件为空
            return PropertyUtils.getErrorMsg("SYS-0115");
        }
        return null;
    }

    @Override
    public String uploadTemp(MultipartFile multipartFile) throws IOException {
        String tempDir = PropertyUtils.getSysVal("upload.file.temporary.directory");
        tempDir += DateUtils.getDate(DATE_FORMAT) + "/";
        file = new File(tempDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = FileUtils.generateFileName(multipartFile);
        file = new File(file.getAbsolutePath() + "/" + fileName);
        multipartFile.transferTo(file);
        return tempDir + "/" + fileName;
    }
}
