package com.dlfc.services.order.service;

import com.dlfc.services.order.entity.SysOrder;

import java.util.List;

public interface SysOrderService {

    List<SysOrder> findOrders(String id);

    SysOrder findOrder(String lid);
}
