package com.dlfc.services.load.controller;

import com.dlfc.services.load.service.UploadService;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.bases.error.ResultError;
import com.housecenter.dlfc.framework.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by K on 2017/6/8.
 */

@RestController
@RequestMapping("/ww/upload")
public class UploadController {

    private String result;

    @Autowired
    private UploadService uploadService;

    @RequestMapping(method = RequestMethod.POST)
    public ResultDTO<List<String>> upload(@RequestBody MultipartFile[] files,
                                          @RequestParam int type) {
        List<String> paths = new ArrayList<>();

        return ResultDTO.success(paths);
    }

    @RequestMapping(value = "single", method = RequestMethod.POST)
    public ResultDTO<String> singleUpload(@RequestBody MultipartFile file,
                                          @RequestParam int type) {
        String path;
        result = uploadService.validate(file, type);
        if (StringUtils.isEmpty(result)) {
            return ResultDTO.failure(StringUtils.EMPTY, new ResultError(result, null));
        }
        path = uploadService.upload(file, type);
        return ResultDTO.success(path);
    }

}
