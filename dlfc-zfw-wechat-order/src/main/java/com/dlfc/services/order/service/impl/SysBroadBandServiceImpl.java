package com.dlfc.services.order.service.impl;

import com.dlfc.services.order.entity.SysBroadband;
import com.dlfc.services.order.repository.OrderRepository;
import com.dlfc.services.order.service.SysBroadBandService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SysBroadBandServiceImpl implements SysBroadBandService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private IConvertor<SysBroadband> convertor;

    @Override
    public SysBroadband findById(String id) {
        String sysBroadband = orderRepository.broadBand(id);
        if (sysBroadband!=null) {
            return convertor.convert2Object(sysBroadband, SysBroadband.class);
        }
        return null;
    }
}
