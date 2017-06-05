package com.dlfc.services.validate.controller;

import com.dlfc.services.validate.service.ValidateService;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ww/validates")
public class HouseValidateController {

    @Autowired
    @Qualifier("houseValidateServiceImpl")
    private ValidateService validateService;

    @RequestMapping(value = "/house", method = RequestMethod.GET)
    public ResultDTO<Void> validateHouseLessee(@RequestParam(name = "hid") String hid){
        if (validateService.validate(hid)){
            return ResultDTO.success();
        }
        return ResultDTO.failure();
    }
}
