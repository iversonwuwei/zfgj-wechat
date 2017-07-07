package com.dlfc.services.unicom.controller;


import com.dlfc.services.unicom.dto.UnicomDTO;
import com.dlfc.services.unicom.entity.SysParam;
import com.dlfc.services.unicom.service.SysCodeService;
import com.dlfc.services.unicom.service.SysParamService;
import com.housecenter.dlfc.commons.bases.dto.ListResultDTO;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ww/unicoms")
public class UnicomController {

    @Autowired
    private SysCodeService sysCodeService;

    @Autowired
    private SysParamService sysParamService;

    @RequestMapping(method = RequestMethod.GET)
    public ListResultDTO<UnicomDTO> products(){
        return null;
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResultDTO<UnicomDTO> detail(@RequestParam String broadSpeed){
        List<SysParam> sysParams = sysParamService.findByScope("broadband");

        return null;
    }
}
