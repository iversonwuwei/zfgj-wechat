package com.dlfc.services.contract.controller;

import com.dlfc.services.contract.controller.base.BaseController;
import com.dlfc.services.contract.convertor.ContractListConvertor;
import com.dlfc.services.contract.dto.ContractListDTO;
import com.dlfc.services.contract.enums.ConStatusEnum;
import com.dlfc.services.contract.repository.ContractRService;
import com.dlfc.services.contract.service.ContractService;
import com.dlfc.services.contract.service.SystemPersonService;
import com.dlfc.zfw.wechat.entities.entity.ConContract;
import com.housecenter.dlfc.commons.bases.dto.ListResultDTO;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
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
    @Autowired
    private ContractService contractService;

    /**
     * 待处理合同列表
     *
     * @param token
     * @return
     * @throws CustomRuntimeException
     */
    @RequestMapping(value = "/pending", method = RequestMethod.GET)
    public ListResultDTO<ContractListDTO> pendingList(@RequestHeader String token) throws CustomRuntimeException {
        getUser(token);
        if (systemPersonService.certification(user.getPerId())) {
            Short[] conStatus = {
                    (short) ConStatusEnum.LESSEE_WAIT_CONFIRM_ENUM.getValue(),
                    (short) ConStatusEnum.LESSOR_WAIT_CONFIRM_ENUM.getValue(),
                    (short) ConStatusEnum.CREATING_ENUM.getValue()
            };
            List<ConContract> conContracts = contractRService.findByPidAndStatuses(user.getPerId(), conStatus);
            return contractListConvertor.toResultDTO(conContracts);
        }
        return contractListConvertor.toResultDTO(new ArrayList<ConContract>());

    }

    /**
     * 已完成合同列表
     *
     * @param token
     * @return
     * @throws CustomRuntimeException
     */
    @RequestMapping(value = "/finish", method = RequestMethod.GET)
    public ListResultDTO<ContractListDTO> finishList(@RequestHeader String token) throws CustomRuntimeException {
        getUser(token);
        if (systemPersonService.certification(user.getPerId())) {
            Short[] conStatus = {
                    (short) ConStatusEnum.ACTIVE_ENUM.getValue(),
                    (short) ConStatusEnum.EXPIRE_ENUM.getValue(),
                    (short) ConStatusEnum.LESSOR_REJECT_ENUM.getValue(),
                    (short) ConStatusEnum.LESSEE_REJECT_ENUM.getValue(),
                    (short) ConStatusEnum.FINISH_ENUM.getValue()

            };
            List<ConContract> conContracts = contractRService.findByPidAndStatuses(user.getPerId(), conStatus);
            return contractListConvertor.toResultDTO(conContracts);
        }
        return contractListConvertor.toResultDTO(new ArrayList<ConContract>());
    }


    /**
     * 删除合同
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResultDTO<Void> delete(@RequestParam String id,
                                  @RequestHeader String token) throws CustomRuntimeException {
        getUser(token);
        String result = contractService.deleteById(id, user);
        if (null != result) {
            return ResultDTO.success();
        }
        return ResultDTO.failure();
    }
}
