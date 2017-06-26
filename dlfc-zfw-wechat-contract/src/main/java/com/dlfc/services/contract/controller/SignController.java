package com.dlfc.services.contract.controller;

import com.dlfc.services.contract.controller.base.BaseController;
import com.dlfc.services.contract.convertor.*;
import com.dlfc.services.contract.dto.*;
import com.dlfc.services.contract.service.*;
import com.dlfc.zfw.wechat.entities.entity.*;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;
import com.housecenter.dlfc.framework.ca.api.PrincipalService;
import com.housecenter.dlfc.framework.common.web.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by K on 6/19/17.
 */

@RestController
@RequestMapping(value = "/ww/contractSign")
public class SignController extends BaseController {

    @Autowired
    private ContractConvertor contractConvertor;
    @Autowired
    private ContractService contractService;
    @Autowired
    private HouseUserConvertor houseUserConvertor;
    @Autowired
    private HouseUserService houseUserService;
    @Autowired
    private HouseUserChildrenConvertor houseUserChildrenConvertor;
    @Autowired
    private HouseUserChildrenService houseUserChildrenService;
    @Autowired
    private DateService dateService;
    @Autowired
    private HouseItemConvertor houseItemConvertor;
    @Autowired
    private HouseItemService houseItemService;
    @Autowired
    private OtherCostConvertor otherCostConvertor;
    @Autowired
    private OtherCostService otherCostService;

    @RequestMapping(method = RequestMethod.POST)
    public ResultDTO<String> sign(@RequestBody ContractDTO contractDTO,
                                  @RequestHeader String token) throws CustomRuntimeException {
        getUser(token);
        ConContract conContract = contractConvertor.toModel(contractDTO);
        String id = contractService.save(conContract, user);
        if (null != contractDTO.getUserList()
                && contractDTO.getUserList().size() > 0) {
            ConHouseUser conHouseUser;
            for (HouseUserDTO houseUser : contractDTO.getUserList()) {
                conHouseUser = houseUserConvertor.toModel(houseUser);
                conHouseUser.setCid(id);
                houseUserService.save(conHouseUser, user);
            }
        }
        if (null != contractDTO.getChildrenList()
                && contractDTO.getChildrenList().size() > 0) {
            ConHouseUserChildren conHouseUserChildren;
            for (HouseUserChildrenDTO children : contractDTO.getChildrenList()) {
                conHouseUserChildren = houseUserChildrenConvertor.toModel(children);
                conHouseUserChildren.setCid(id);
                houseUserChildrenService.save(conHouseUserChildren, user);
            }
        }
        if (null != contractDTO.getHouseItemsList()
                && contractDTO.getHouseItemsList().size() > 0) {
            ConHouseItems conHouseItems;
            for (HouseItemDTO houseItemDTO : contractDTO.getHouseItemsList()) {
                conHouseItems = houseItemConvertor.toModel(houseItemDTO);
                conHouseItems.setCid(id);
                houseItemService.save(conHouseItems, user);
            }
        }
        if (null != contractDTO.getOtherCostList()
                && contractDTO.getOtherCostList().size() > 0) {
            ConOtherCosts conOtherCosts;
            for (OtherCostDTO otherCostDTO : contractDTO.getOtherCostList()) {
                conOtherCosts = otherCostConvertor.toModel(otherCostDTO);
                conOtherCosts.setCid(id);
                otherCostService.save(conOtherCosts, user);
            }
        }
        return ResultDTO.success(id);
    }

    @RequestMapping(value = "/endDate", method = RequestMethod.POST)
    public Date getEndDate(@RequestBody ContractEndDateDTO dto) {
        return dateService.getEndDate(dto.getStartDate(), dto.getYears(), dto.getMonths());
    }
}
