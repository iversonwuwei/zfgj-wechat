package com.dlfc.services.order.controller;


import com.dlfc.services.order.convertor.OrderDetailConvertor;
import com.dlfc.services.order.convertor.OrderListConvertor;
import com.dlfc.services.order.dto.OrderDTO;
import com.dlfc.services.order.dto.OrderListDTO;
import com.dlfc.services.order.dto.UserDTO;
import com.dlfc.services.order.entity.SysBroadband;
import com.dlfc.services.order.entity.SysOrder;
import com.dlfc.services.order.repository.UserInfoRService;
import com.dlfc.services.order.service.SysBroadBandService;
import com.dlfc.services.order.service.SysOrderService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import com.housecenter.dlfc.commons.bases.dto.ListResultDTO;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;
import com.housecenter.dlfc.framework.ca.api.PrincipalService;
import com.housecenter.dlfc.framework.common.web.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/ww/orders")
public class OrderController {

    @Autowired
    private SysOrderService sysOrderService;
    @Autowired
    private OrderListConvertor orderListConvertor;
    @Autowired
    private OrderDetailConvertor orderDetailConvertor;

    @Autowired
    private UserInfoRService userInfoRService;
    @Autowired
    private IConvertor<UserDTO> convertor;
    @Autowired
    private PrincipalService principalService;
    @Autowired
    private SysBroadBandService sysBroadBandService;


    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public ResultDTO<OrderDTO> createOrder(@RequestParam String lid) throws CustomRuntimeException {
        SysOrder sysOrder = sysOrderService.findOrder(lid);
        if (sysOrder == null){
            throw new CustomRuntimeException("","");
        }
        return orderDetailConvertor.toResultDTO(sysOrder);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ListResultDTO<OrderListDTO> orderList(@RequestHeader String token) throws CustomRuntimeException {
        AjaxResult user = principalService.principal(token);
        List<SysOrder> newSysOrders = new ArrayList<>();
        UserDTO userDTO = convertor.convert2Object(userInfoRService.findUserByUser(user.getData().toString()),UserDTO.class);
        List<SysOrder> sysOrders = sysOrderService.findOrders(userDTO.getId());
        if (sysOrders == null){
            throw new CustomRuntimeException("","");
        }
        for (SysOrder sysOrder : sysOrders){
            SysBroadband sysBroadband = sysBroadBandService.findById(sysOrder.getLid());
            if(sysBroadband != null){
                newSysOrders.add(sysOrder);
            }
        }
        return orderListConvertor.toResultDTO(newSysOrders);
    }
}
