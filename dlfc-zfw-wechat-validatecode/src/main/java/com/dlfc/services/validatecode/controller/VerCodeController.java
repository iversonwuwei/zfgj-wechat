package com.dlfc.services.validatecode.controller;

import com.dlfc.services.validatecode.service.SysMobileCapchaService;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.bases.error.ResultError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ww")
public class VerCodeController {

    @Autowired
    private SysMobileCapchaService sysMobileCapchaService;
    @Autowired
    private UserMService userMService;


    @RequestMapping(value = "/verCodeSend", method = RequestMethod.GET)
    public ResultDTO<String> verCodeSend(@RequestParam String phone,
                                         @RequestParam String domain) {
        if (!sysMobileCapchaService.getCaptchaCountByMobile(phone, domain)) {
            ResultError resultError = new ResultError();
            resultError.setErrmsg(PropertyUtils.getErrorMsg("SYS-0132"));
            return ResultDTO.failure("", resultError);
        }
        String id;
        try {
            id = userMService.codeSend(phone, domain);
        } catch (Exception e) {
            return ResultDTO.failure("",new ResultError(e.getMessage(),null));
        }
        return ResultDTO.success(id);
    }
}
