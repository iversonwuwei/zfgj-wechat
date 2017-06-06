package com.dlfc.services.order.convertor;

import com.dlfc.services.order.dto.OrderDTO;
import com.dlfc.services.order.entity.SysBroadband;
import com.dlfc.services.order.entity.SysOrder;
import com.dlfc.services.order.service.SysBroadBandService;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderDetailConvertor extends AbstractConvertor<SysOrder, OrderDTO> {

    @Autowired
    private SysBroadBandService sysBroadBandService;

    @Autowired
    private IConvertor<SysBroadband> convertor;


    @Override
    public SysOrder toModel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO toDTO(SysOrder sysOrder, Object... objects) {
        SysBroadband sysBroadband = sysBroadBandService.findById(sysOrder.getLid());
        OrderDTO orderDTO = null;
        if (sysBroadband != null){
            orderDTO = new OrderDTO();
            orderDTO.setAddress(sysBroadband.getAdd1()+sysBroadband.getAdd2());
            orderDTO.setAmount(sysBroadband.getEprice());
            orderDTO.setContactName(sysBroadband.getContactName());
            orderDTO.setInstallFee("100");
            orderDTO.setPaymentWay(sysOrder.getPaymentChannels());
            orderDTO.setPhone(sysBroadband.getPhone());
            orderDTO.setPrdDesc(sysBroadband.getName());
            orderDTO.setInstallTime(sysBroadband.getTimeType());
            orderDTO.setPrice(sysBroadband.getPrice());
            orderDTO.setOrderCreateTime(sysOrder.getCreateTime());
            orderDTO.setPaymentTime("");
        }
        return orderDTO;
    }
}
