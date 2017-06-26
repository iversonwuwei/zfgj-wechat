package com.dlfc.services.contract.controller;

import com.dlfc.services.contract.convertor.ContractConvertor;
import com.dlfc.services.contract.dto.ContractDTO;
import com.dlfc.services.contract.repository.ContractRService;
import com.dlfc.zfw.wechat.entities.entity.ConContract;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.bases.error.ResultError;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by K on 6/21/17.
 */

@RestController
@RequestMapping("/ww/ContractDetail")
public class DetailController {

    @Autowired
    private ContractRService contractRService;
    @Autowired
    private ContractConvertor contractConvertor;

    @RequestMapping(method = RequestMethod.GET)
    public ResultDTO<ContractDTO> detail(@RequestParam String id) {
        return contractConvertor.toResultDTO(contractRService.findConContractById(id));
    }
}
