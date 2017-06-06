package com.dlfc.services.order.controller;


import com.dlfc.services.order.convertor.OrderDetailConvertor;
import com.dlfc.services.order.convertor.OrderListConvertor;
import com.dlfc.services.order.dto.OrderDTO;
import com.dlfc.services.order.dto.OrderListDTO;
import com.dlfc.services.order.entity.SysOrder;
import com.dlfc.services.order.service.SysOrderService;
import com.housecenter.dlfc.commons.bases.dto.ListResultDTO;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public ResultDTO<OrderDTO> createOrder(@RequestParam String lid) throws CustomRuntimeException {
        SysOrder sysOrder = sysOrderService.findOrder(lid);
        if (sysOrder == null){
            throw new CustomRuntimeException("","");
        }
        return orderDetailConvertor.toResultDTO(sysOrder);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ListResultDTO<OrderListDTO> orderList() throws CustomRuntimeException {
        List<SysOrder> sysOrders = sysOrderService.findOrders("0bd68f142f324be59697e14f1e630205");
        if (sysOrders == null){
            throw new CustomRuntimeException("","");
        }
        return orderListConvertor.toResultDTO(sysOrders);
    }
}
