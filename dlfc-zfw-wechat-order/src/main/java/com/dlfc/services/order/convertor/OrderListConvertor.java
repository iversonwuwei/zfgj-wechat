package com.dlfc.services.order.convertor;

import com.dlfc.services.order.dto.OrderListDTO;
import com.dlfc.services.order.entity.SysBroadband;
import com.dlfc.services.order.entity.SysOrder;
import com.dlfc.services.order.service.SysBroadBandService;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderListConvertor extends AbstractConvertor<SysOrder, OrderListDTO> {

    @Autowired
    private SysBroadBandService sysBroadBandService;

    @Override
    public SysOrder toModel(OrderListDTO orderListDTO) {
        return null;
    }

    @Override
    public OrderListDTO toDTO(SysOrder sysOrder, Object... objects) {
        SysBroadband sysBroadband = sysBroadBandService.findById(sysOrder.getLid());
        OrderListDTO orderListDTO = null;
        if (sysBroadband != null){
            orderListDTO = new OrderListDTO();
            orderListDTO.setId(sysOrder.getId());
            orderListDTO.setSpeed(sysBroadband.getSpeed());
            orderListDTO.setPrice(sysBroadband.getPrice());
            orderListDTO.setDesc(sysBroadband.getName());
            orderListDTO.setAmount(sysBroadband.getEprice());
            orderListDTO.setImgURL(sysBroadband.getImg1());
            orderListDTO.setStatus(sysBroadband.getStatus());
        }

        return orderListDTO;
    }
}
