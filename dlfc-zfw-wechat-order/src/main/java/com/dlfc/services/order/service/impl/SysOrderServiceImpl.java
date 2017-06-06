package com.dlfc.services.order.service.impl;

import com.dlfc.services.order.entity.SysOrder;
import com.dlfc.services.order.repository.OrderRepository;
import com.dlfc.services.order.service.SysOrderService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysOrderServiceImpl implements SysOrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private IConvertor<SysOrder> sysOrderIConvertor;

    @Override
    public List<SysOrder> findOrders(String id) {
        String orders = orderRepository.ordersByUid(id);
        return sysOrderIConvertor.convert2Objects(orders, SysOrder.class);
    }

    @Override
    public SysOrder findOrder(String lid) {
        String order = orderRepository.orders(lid);
        return sysOrderIConvertor.convert2Object(order, SysOrder.class);
    }
}
