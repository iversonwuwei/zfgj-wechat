package com.dlfc.services.load.service.impl;

import com.dlfc.services.load.common.FileUtils;
import com.dlfc.services.load.enums.InfoAttFileTypeEnum;
import com.dlfc.services.load.service.UploadService;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.utils.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

/**
 * Created by K on 2017/6/8.
 */

@Service
public class UploadServiceImpl implements UploadService<MultipartFile> {

    private static final long UPLOAD_FILE_MAX_SIZE = 4194304;
    private static final String UPLOAD_FILE_EXT_ALLOWED = ".png,.jpg,.jpeg,.bmp";
    private static final String UPLOAD_FILE_REAL_DIRECTORY = "/mnt/samba/realImg";
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private File file;
    private int i;

    @Override
    public String upload(MultipartFile multipartFile,
                         int type) {
        String dateFormat = "/" + DateUtils.formatDate(new Date(), DATE_FORMAT);
        String filePathFix = StringUtils.EMPTY;
        String fileName = FileUtils.generateUUID();
        if (InfoAttFileTypeEnum.HOUSE_PIC_ENUM.getValue() == type) {
            filePathFix = "/lea";
            for (i = 0; i < 4; i++) {
                if (i == 0) {
                    fileName+="normal";
                }
            }
        }
        String path = UPLOAD_FILE_REAL_DIRECTORY + filePathFix + dateFormat;
        file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return null;
    }

    @Override
    public String validate(MultipartFile file,
                           int type) {
        if (null != file && file.getSize() > 0) {
            // 文件大小不合法
            if (file.getSize() > UPLOAD_FILE_MAX_SIZE) {
                return "上传文件大小不得超过" + UPLOAD_FILE_MAX_SIZE / 1048576 + "M。";
            }
            // 上传文件扩展名限制
            String[] extAllowedArray = UPLOAD_FILE_EXT_ALLOWED.split(",");
            String fileRealName = file.getOriginalFilename();
            // 获得文件后缀名
            String ext = fileRealName.substring(fileRealName.lastIndexOf(".")).toLowerCase();
            boolean extFlag = false;
            for (String str : extAllowedArray) {
                if (str.equals(ext)) {
                    extFlag = true;
                    break;
                }
            }
            //文件后缀名不合法
            if (!extFlag) {
                return "请上传后缀名为" + UPLOAD_FILE_EXT_ALLOWED.replace(",.", "/") + "的图片。";
            }
        } else {
            // 文件为空
            return "上传文件不能为空";
        }
        return null;
    }
}
