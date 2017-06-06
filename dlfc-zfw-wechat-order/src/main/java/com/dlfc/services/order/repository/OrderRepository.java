package com.dlfc.services.order.repository;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dlfc-datacenter-system")
public interface OrderRepository {

    @RequestMapping(value = "/wc/datas/sysOrder/findById")
    String orders(@RequestParam(name = "id") String id);

    @RequestMapping(value = "/wc/datas/sysOrder/findByUid")
    String ordersByUid(@RequestParam(name = "uid") String uid);

    @RequestMapping(value = "/wc/datas/sysBroadband/findById")
    String broadBand(@RequestParam(name = "id") String id);
}
