package com.dlfc.services.load.controller;

import com.dlfc.admin.common.utils.PropertyUtils;
import com.dlfc.services.load.service.ClassfyUploadService;
import com.dlfc.services.load.service.ImageService;
import com.dlfc.services.load.service.UploadService;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.bases.error.ResultError;
import com.housecenter.dlfc.framework.common.util.StringUtils;
import com.housecenter.dlfc.framework.starter.web.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by K on 2017/6/8.
 */

@RestController
@RequestMapping("/ww/upload")
@Slf4j
public class UploadController extends BaseController {

    /**
     * 水印类型 LOGO
     */
    public static final int WATER_MARK_TYPE_LOGO = 1;

    private String result;

    @Autowired
    private UploadService uploadService;
    @Autowired
    private ImageService imageService;
    @Autowired
    @Qualifier("UserAvatarUploadServiceImpl")
    private ClassfyUploadService classfyUploadService;

    @RequestMapping(value = "/uploadHouPic", method = RequestMethod.POST)
    public ResultDTO<String> uploadHouPic(@RequestBody MultipartFile files) {
        getRequest();
        String path;
        result = uploadService.validate(files);
        if (StringUtils.isNotEmpty(result)) {
            return ResultDTO.failure(StringUtils.EMPTY, new ResultError(result, null));
        }
        try {
            path = uploadService.uploadTemp(files);
            path = imageService.generateLeaseImage(path, WATER_MARK_TYPE_LOGO);
        } catch (IOException e) {
            log.error(e.getMessage());
            return ResultDTO.failure(StringUtils.EMPTY,
                    new ResultError(PropertyUtils.getErrorMsg("SYS-0112"), null));
        }
        return ResultDTO.success(path);
    }

    @RequestMapping(value = "/uploadUserAvatar", method = RequestMethod.POST)
    public ResultDTO<String> uploadUserAvatar(@RequestBody MultipartFile files) {
        String path;
        result = uploadService.validate(files);
        if (StringUtils.isNotEmpty(result)) {
            return ResultDTO.failure(StringUtils.EMPTY, new ResultError(result, null));
        }
        try {
            path = (String) classfyUploadService.upload(files);
        } catch (IOException e) {
            log.error(e.getMessage());
            return ResultDTO.failure(StringUtils.EMPTY,
                    new ResultError(PropertyUtils.getErrorMsg("SYS-0112"), null));
        }
        return ResultDTO.success(path);
    }
}
