package com.dlfc.services.load.controller;

import com.dlfc.admin.common.utils.PropertyUtils;
import com.dlfc.services.load.repository.ContractWService;
import com.dlfc.services.load.service.ClassfyUploadService;
import com.dlfc.services.load.service.ImageService;
import com.dlfc.services.load.service.UploadService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.bases.error.ResultError;
import com.housecenter.dlfc.framework.common.util.StringUtils;
import com.housecenter.dlfc.framework.starter.web.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by K on 2017/6/8.
 */

@RestController
@RequestMapping("/ww/upload")
@Slf4j
public class UploadController {

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
    private ClassfyUploadService UserAvatarUploadServiceImpl;
    @Autowired
    @Qualifier("ContractSignUploadServiceImpl")
    private ClassfyUploadService ContractSignUploadServiceImpl;
    @Autowired
    private ContractWService contractWService;

    @RequestMapping(value = "/uploadHouPic", method = RequestMethod.POST)
    public ResultDTO<String> uploadHouPic(@RequestBody MultipartFile files) {
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
            path = (String) UserAvatarUploadServiceImpl.upload(files);
        } catch (IOException e) {
            log.error(e.getMessage());
            return ResultDTO.failure(StringUtils.EMPTY,
                    new ResultError(PropertyUtils.getErrorMsg("SYS-0112"), null));
        }
        return ResultDTO.success(path);
    }

    @RequestMapping(value = "/lessorSign", method = RequestMethod.POST)
    public ResultDTO<String> uploadLessorSign(@RequestBody MultipartFile files,
                                              @RequestParam String contractId) {
        String path;
        result = uploadService.validate(files);
        if (StringUtils.isNotEmpty(result)) {
            return ResultDTO.failure(StringUtils.EMPTY, new ResultError(result, null));
        }
        try {
            path = (String) ContractSignUploadServiceImpl.upload(files);
        } catch (IOException e) {
            log.error(e.getMessage());
            return ResultDTO.failure(StringUtils.EMPTY,
                    new ResultError(PropertyUtils.getErrorMsg("SYS-0112"), null));
        }
        ResultDTO<Void> result = contractWService.lessorSign(contractId, path);
        if (result.isFailure()) {
            log.error(result.errorsToString());
            return ResultDTO.failure(StringUtils.EMPTY,
                    new ResultError(PropertyUtils.getErrorMsg("SYS-0112"), null));
        }
        return ResultDTO.success(path);
    }

    @RequestMapping(value = "/lesseeSign", method = RequestMethod.POST)
    public ResultDTO<String> uploadLesseeSign(@RequestBody MultipartFile files,
                                              @RequestParam String contractId) {
        String path;
        result = uploadService.validate(files);
        if (StringUtils.isNotEmpty(result)) {
            return ResultDTO.failure(StringUtils.EMPTY, new ResultError(result, null));
        }
        try {
            path = (String) ContractSignUploadServiceImpl.upload(files);
        } catch (IOException e) {
            log.error(e.getMessage());
            return ResultDTO.failure(StringUtils.EMPTY,
                    new ResultError(PropertyUtils.getErrorMsg("SYS-0112"), null));
        }
        ResultDTO<Void> result = contractWService.lesseeSign(contractId, path);
        if (result.isFailure()) {
            log.error(result.errorsToString());
            return ResultDTO.failure(StringUtils.EMPTY,
                    new ResultError(PropertyUtils.getErrorMsg("SYS-0112"), null));
        }
        return ResultDTO.success(path);
    }
}
