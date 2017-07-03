package com.dlfc.services.validate.controller;

import com.dlfc.services.validate.service.ValidateService;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.bases.error.ResultError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by walden on 17-6-30.
 */
@RestController
@RequestMapping(value = "/ww/validates")
public class PhoneValidateController {
    @Autowired
    @Qualifier("phoneValidateServiceImpl")
    private ValidateService phoneValidateService;

    @RequestMapping(value = "phone", method = RequestMethod.GET)
    public ResultDTO phoneValdaition(@RequestParam String phoneNumber) {
        ResultError resultError = null;
        if (phoneValidateService.validate(phoneNumber)) {
            resultError = new ResultError();
            resultError.setErrcode("110");
            resultError.setErrmsg("电话号码已被注册,请更换重试!");
            return ResultDTO.failure(resultError);
        }

        return ResultDTO.success("可以使用!");
    }
}
