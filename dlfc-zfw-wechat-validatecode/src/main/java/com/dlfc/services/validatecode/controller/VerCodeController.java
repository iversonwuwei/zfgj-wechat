package com.dlfc.services.validatecode.controller;

import com.dlfc.services.validatecode.service.VerCodeService;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.bases.error.ResultError;
import com.housecenter.dlfc.framework.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerCodeController {

    private static final String OVER_COUNT = "该手机号码已超过当日提交次数，请明天再试或更换手机号码";

    @Autowired
    private VerCodeService verCodeService;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public ResultDTO<String> verCodeSend(@RequestParam String phone,
                                         @RequestParam String domain) {
        if (!verCodeService.checkCount(phone, domain)) {
            return ResultDTO.failure(StringUtils.EMPTY, new ResultError(OVER_COUNT, null));
        }
        String deviceId;
        deviceId = verCodeService.send(phone, domain);
        if (StringUtils.isEmpty(deviceId)) {
            return ResultDTO.failure(StringUtils.EMPTY, new ResultError("发送短信失败", null));
        }
        return ResultDTO.success(deviceId);
    }
}
