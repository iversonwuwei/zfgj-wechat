package com.dlfc.services.contract.controller;

import com.dlfc.services.contract.controller.base.BaseController;
import com.dlfc.services.contract.convertor.ContractListConvertor;
import com.dlfc.services.contract.dto.ContractListDTO;
import com.dlfc.services.contract.repository.ContractRService;
import com.dlfc.services.contract.service.SystemPersonService;
import com.dlfc.zfw.wechat.entities.entity.ConContract;
import com.housecenter.dlfc.commons.bases.dto.ListResultDTO;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangna on 2017/6/26.
 */
@RestController
@RequestMapping("/ww/contractList")
public class ListController extends BaseController {

    @Autowired
    private ContractRService contractRService;
    @Autowired
    private ContractListConvertor contractListConvertor;
    @Autowired
    private SystemPersonService systemPersonService;

    /**
     * 待处理合同列表
     * @param token
     * @return
     * @throws CustomRuntimeException
     */
    @RequestMapping(value = "pending",method = RequestMethod.GET)
    public ListResultDTO<ContractListDTO> pendingList(@RequestHeader String token) throws CustomRuntimeException {
        getUser(token);
        if (systemPersonService.certification(user.getPerId())){
            List<ConContract> conContracts = contractRService.findInactiveByPid(user.getPerId());
            return contractListConvertor.toResultDTO(conContracts);
        }
        return contractListConvertor.toResultDTO(new ArrayList<ConContract>());

    }

    /**
     * 已完成合同列表
     * @param token
     * @return
     * @throws CustomRuntimeException
     */
    @RequestMapping(value = "finish",method = RequestMethod.GET)
    public ListResultDTO<ContractListDTO> finishList(@RequestHeader String token) throws CustomRuntimeException {
        getUser(token);
        if (systemPersonService.certification(user.getPerId())){
            List<ConContract> conContracts = contractRService.findActiveByPid(user.getPerId());
            return contractListConvertor.toResultDTO(conContracts);
        }
        return contractListConvertor.toResultDTO(new ArrayList<ConContract>());
    }
}
