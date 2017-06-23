package com.dlfc.services.contract.controller;

import com.dlfc.services.contract.convertor.ContractConvertor;
import com.dlfc.services.contract.convertor.HouseUserChildrenConvertor;
import com.dlfc.services.contract.convertor.HouseUserConvertor;
import com.dlfc.services.contract.dto.ContractDTO;
import com.dlfc.services.contract.dto.ContractEndDateDTO;
import com.dlfc.services.contract.dto.HouseUserChildrenDTO;
import com.dlfc.services.contract.dto.HouseUserDTO;
import com.dlfc.services.contract.service.*;
import com.dlfc.zfw.wechat.entities.entity.ConContract;
import com.dlfc.zfw.wechat.entities.entity.ConHouseUser;
import com.dlfc.zfw.wechat.entities.entity.ConHouseUserChildren;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
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
public class SignController {

    private String user;

    @Autowired
    private PrincipalService principalService;
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
    private UserService userService;
    @Autowired
    private DateService dateService;

    @RequestMapping(method = RequestMethod.POST)
    public ResultDTO<Void> sign(@RequestBody ContractDTO contractDTO,
                                @RequestHeader String token) {
        AjaxResult ajaxResult = principalService.principal(token);
        user = ajaxResult.getData().toString();
        UsrUser usrUser = userService.findUser(user);
        ConContract conContract = contractConvertor.toModel(contractDTO);
        String id = contractService.save(conContract, usrUser);
        if (null != contractDTO.getUserList()
                && contractDTO.getUserList().size() > 0) {
            ConHouseUser conHouseUser;
            for (HouseUserDTO houseUser : contractDTO.getUserList()) {
                conHouseUser = houseUserConvertor.toModel(houseUser);
                conHouseUser.setCid(id);
                houseUserService.save(conHouseUser, usrUser);
            }
        }
        if (null != contractDTO.getChildrenList()
                && contractDTO.getChildrenList().size() > 0) {
            ConHouseUserChildren conHouseUserChildren;
            for (HouseUserChildrenDTO children : contractDTO.getChildrenList()) {
                conHouseUserChildren = houseUserChildrenConvertor.toModel(children);
                conHouseUserChildren.setCid(id);
                houseUserChildrenService.save(conHouseUserChildren, usrUser);
            }
        }
        return ResultDTO.success();
    }

    @RequestMapping(value = "/endDate", method = RequestMethod.POST)
    public Date getEndDate(@RequestBody ContractEndDateDTO dto) {
        return dateService.getEndDate(dto.getStartDate(), dto.getYears(), dto.getMonths());
    }
}
